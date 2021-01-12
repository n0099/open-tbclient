package com.baidu.tieba.ala.liveroom.w;

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
    private ViewGroup bNl;
    IZanResponseCallback bTw;
    private boolean hIR;
    private int hNV;
    private final int hNW;
    private IAlaBdZan hNX;
    private View hNY;
    private boolean hNZ;
    private int hOa;
    private int hOb;
    private int hOc;
    private boolean hOd;
    private Runnable hOe;
    private com.baidu.live.liveroom.a.a hpw;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hNV = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hNW = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hNZ = true;
        this.mIsHost = false;
        this.hOa = -1;
        this.hOb = 0;
        this.hOc = 0;
        this.hOd = false;
        this.hOe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.w.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hOb > 0) {
                    a.this.s(a.this.mRoomId, a.this.mCastId, a.this.hOb);
                    a.this.hOc += a.this.hOb;
                    a.this.hOb = 0;
                }
            }
        };
        this.bTw = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hOd && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.r.a.aD(a.this.mLiveId, "zan_rmb");
                    a.this.hOd = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.hpw = aVar;
        this.hNV = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hOa = -1;
            this.mIsHost = z;
            this.bNl = viewGroup;
            this.hNX = BdZanViewCreater.getInst().create();
            if (this.hNX != null) {
                this.hNX.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hNY = view;
                            a.this.hNY.setClickable(false);
                            a.this.aQ(a.this.bNl);
                        }
                    }
                });
                this.hNX.setZanResponseCallback(this.bTw);
                this.hNX.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(ViewGroup viewGroup) {
        if (this.hNY != null && viewGroup.indexOfChild(this.hNY) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aR((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aR((FrameLayout) viewGroup);
            }
        }
    }

    private void aR(ViewGroup viewGroup) {
        if (this.hNY != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hNV, this.hNW);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hNY, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hNV, this.hNW);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hNY, layoutParams2);
            }
            if (this.hNY instanceof SurfaceView) {
                ((SurfaceView) this.hNY).setZOrderOnTop(true);
                ((SurfaceView) this.hNY).getHolder().setFormat(-3);
            }
        }
    }

    public void ckL() {
        aQ(this.bNl);
    }

    public void ckM() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hNY != null && this.bNl != null && this.bNl.indexOfChild(this.hNY) > 0) {
            this.bNl.removeView(this.hNY);
        }
    }

    public boolean ckN() {
        return this.hNZ;
    }

    public void oH(boolean z) {
        this.hNZ = z;
    }

    public void oA(boolean z) {
        this.hIR = z;
    }

    public void oI(boolean z) {
        if (this.hIR && z) {
            z = false;
        }
        if (z) {
            if (this.hNY != null) {
                this.hNY.setVisibility(0);
            }
        } else if (this.hNY != null) {
            this.hNY.setVisibility(8);
        }
    }

    public void M(b bVar) {
        JSONObject jSONObject;
        if (this.hNY != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hOa > 0 && optInt > this.hOa && ckN() && this.hNX != null) {
                        int i = optInt - this.hOa;
                        if (this.hOc > 0) {
                            if (i > this.hOc) {
                                addHeart(i - this.hOc);
                                this.hOc = 0;
                            } else {
                                this.hOc -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hOa = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hOe);
        this.bNl = null;
        this.hNY = null;
        this.hOd = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void aw(String str, String str2, String str3) {
        if (this.hNX != null) {
            if (ckN()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hOb == 0) {
                this.mHandler.removeCallbacks(this.hOe);
                this.mHandler.postDelayed(this.hOe, 1000L);
            }
            this.hOb++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hNX != null && this.hNY != null && this.hNY.getVisibility() == 0) {
            this.hNX.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, int i) {
        if (this.hNX != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hNX.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
