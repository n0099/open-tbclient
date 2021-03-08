package com.baidu.tieba.ala.liveroom.v;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.im.data.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bSB;
    IZanResponseCallback bYV;
    private boolean hPm;
    private int hUo;
    private final int hUp;
    private IAlaBdZan hUq;
    private View hUr;
    private boolean hUs;
    private int hUt;
    private int hUu;
    private int hUv;
    private boolean hUw;
    private Runnable hUx;
    private com.baidu.live.liveroom.a.a hvE;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hUo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hUp = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hUs = true;
        this.mIsHost = false;
        this.hUt = -1;
        this.hUu = 0;
        this.hUv = 0;
        this.hUw = false;
        this.hUx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hUu > 0) {
                    a.this.s(a.this.mRoomId, a.this.mCastId, a.this.hUu);
                    a.this.hUv += a.this.hUu;
                    a.this.hUu = 0;
                }
            }
        };
        this.bYV = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hUw && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.q.a.aD(a.this.mLiveId, "zan_rmb");
                    a.this.hUw = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.hvE = aVar;
        this.hUo = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hUt = -1;
            this.mIsHost = z;
            this.bSB = viewGroup;
            this.hUq = BdZanViewCreater.getInst().create();
            if (this.hUq != null) {
                this.hUq.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hUr = view;
                            a.this.hUr.setClickable(false);
                            a.this.aQ(a.this.bSB);
                        }
                    }
                });
                this.hUq.setZanResponseCallback(this.bYV);
                this.hUq.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(ViewGroup viewGroup) {
        if (this.hUr != null && viewGroup.indexOfChild(this.hUr) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aR((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aR((FrameLayout) viewGroup);
            }
        }
    }

    private void aR(ViewGroup viewGroup) {
        if (this.hUr != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hUo, this.hUp);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hUr, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hUo, this.hUp);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds96);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hUr, layoutParams2);
            }
            if (this.hUr instanceof SurfaceView) {
                ((SurfaceView) this.hUr).setZOrderOnTop(true);
                ((SurfaceView) this.hUr).getHolder().setFormat(-3);
            }
        }
    }

    public void clW() {
        aQ(this.bSB);
    }

    public void clX() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hUr != null && this.bSB != null && this.bSB.indexOfChild(this.hUr) > 0) {
            this.bSB.removeView(this.hUr);
        }
    }

    public boolean clY() {
        return this.hUs;
    }

    public void oR(boolean z) {
        this.hUs = z;
    }

    public void oK(boolean z) {
        this.hPm = z;
    }

    public void oS(boolean z) {
        if (this.hPm && z) {
            z = false;
        }
        if (z) {
            if (this.hUr != null) {
                this.hUr.setVisibility(0);
            }
        } else if (this.hUr != null) {
            this.hUr.setVisibility(8);
        }
    }

    public void R(b bVar) {
        JSONObject jSONObject;
        if (this.hUr != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hUt > 0 && optInt > this.hUt && clY() && this.hUq != null) {
                        int i = optInt - this.hUt;
                        if (this.hUv > 0) {
                            if (i > this.hUv) {
                                addHeart(i - this.hUv);
                                this.hUv = 0;
                            } else {
                                this.hUv -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hUt = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hUx);
        this.bSB = null;
        this.hUr = null;
        this.hUw = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ax(String str, String str2, String str3) {
        if (this.hUq != null) {
            if (clY()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hUu == 0) {
                this.mHandler.removeCallbacks(this.hUx);
                this.mHandler.postDelayed(this.hUx, 1000L);
            }
            this.hUu++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hUq != null && this.hUr != null && this.hUr.getVisibility() == 0) {
            this.hUq.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, int i) {
        if (this.hUq != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hUq.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
