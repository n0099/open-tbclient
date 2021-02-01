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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bRb;
    IZanResponseCallback bXv;
    private boolean hNp;
    private Runnable hSA;
    private int hSr;
    private final int hSs;
    private IAlaBdZan hSt;
    private View hSu;
    private boolean hSv;
    private int hSw;
    private int hSx;
    private int hSy;
    private boolean hSz;
    private com.baidu.live.liveroom.a.a htH;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hSr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hSs = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hSv = true;
        this.mIsHost = false;
        this.hSw = -1;
        this.hSx = 0;
        this.hSy = 0;
        this.hSz = false;
        this.hSA = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hSx > 0) {
                    a.this.s(a.this.mRoomId, a.this.mCastId, a.this.hSx);
                    a.this.hSy += a.this.hSx;
                    a.this.hSx = 0;
                }
            }
        };
        this.bXv = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hSz && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.q.a.aD(a.this.mLiveId, "zan_rmb");
                    a.this.hSz = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.htH = aVar;
        this.hSr = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hSw = -1;
            this.mIsHost = z;
            this.bRb = viewGroup;
            this.hSt = BdZanViewCreater.getInst().create();
            if (this.hSt != null) {
                this.hSt.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hSu = view;
                            a.this.hSu.setClickable(false);
                            a.this.aQ(a.this.bRb);
                        }
                    }
                });
                this.hSt.setZanResponseCallback(this.bXv);
                this.hSt.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(ViewGroup viewGroup) {
        if (this.hSu != null && viewGroup.indexOfChild(this.hSu) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aR((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aR((FrameLayout) viewGroup);
            }
        }
    }

    private void aR(ViewGroup viewGroup) {
        if (this.hSu != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hSr, this.hSs);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hSu, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hSr, this.hSs);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds96);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hSu, layoutParams2);
            }
            if (this.hSu instanceof SurfaceView) {
                ((SurfaceView) this.hSu).setZOrderOnTop(true);
                ((SurfaceView) this.hSu).getHolder().setFormat(-3);
            }
        }
    }

    public void clJ() {
        aQ(this.bRb);
    }

    public void clK() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hSu != null && this.bRb != null && this.bRb.indexOfChild(this.hSu) > 0) {
            this.bRb.removeView(this.hSu);
        }
    }

    public boolean clL() {
        return this.hSv;
    }

    public void oR(boolean z) {
        this.hSv = z;
    }

    public void oK(boolean z) {
        this.hNp = z;
    }

    public void oS(boolean z) {
        if (this.hNp && z) {
            z = false;
        }
        if (z) {
            if (this.hSu != null) {
                this.hSu.setVisibility(0);
            }
        } else if (this.hSu != null) {
            this.hSu.setVisibility(8);
        }
    }

    public void R(b bVar) {
        JSONObject jSONObject;
        if (this.hSu != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hSw > 0 && optInt > this.hSw && clL() && this.hSt != null) {
                        int i = optInt - this.hSw;
                        if (this.hSy > 0) {
                            if (i > this.hSy) {
                                addHeart(i - this.hSy);
                                this.hSy = 0;
                            } else {
                                this.hSy -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hSw = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hSA);
        this.bRb = null;
        this.hSu = null;
        this.hSz = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ax(String str, String str2, String str3) {
        if (this.hSt != null) {
            if (clL()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hSx == 0) {
                this.mHandler.removeCallbacks(this.hSA);
                this.mHandler.postDelayed(this.hSA, 1000L);
            }
            this.hSx++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hSt != null && this.hSu != null && this.hSu.getVisibility() == 0) {
            this.hSt.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, int i) {
        if (this.hSt != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hSt.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
