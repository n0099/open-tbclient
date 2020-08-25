package com.baidu.tieba.ala.liveroom.x;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    IZanResponseCallback bwu;
    private ViewGroup fZu;
    private boolean gHT;
    private int gNa;
    private final int gNb;
    private IAlaBdZan gNc;
    private View gNd;
    private boolean gNe;
    private int gNf;
    private int gNg;
    private int gNh;
    private boolean gNi;
    private Runnable gNj;
    private com.baidu.live.liveroom.a.a gph;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gNa = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.gNb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.gNe = true;
        this.mIsHost = false;
        this.gNf = -1;
        this.gNg = 0;
        this.gNh = 0;
        this.gNi = false;
        this.gNj = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gNg > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.gNg);
                    a.this.gNh += a.this.gNg;
                    a.this.gNg = 0;
                }
            }
        };
        this.bwu = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.gNi && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.m.a.ay(a.this.mLiveId, "zan_rmb");
                    a.this.gNi = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gph = aVar;
        this.gNa = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.gNf = -1;
            this.mIsHost = z;
            this.fZu = viewGroup;
            this.gNc = BdZanViewCreater.getInst().create();
            if (this.gNc != null) {
                this.gNc.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.gNd = view;
                            a.this.gNd.setClickable(false);
                            a.this.aD(a.this.fZu);
                        }
                    }
                });
                this.gNc.setZanResponseCallback(this.bwu);
                this.gNc.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(ViewGroup viewGroup) {
        if (this.gNd != null && viewGroup.indexOfChild(this.gNd) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aE((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aE((FrameLayout) viewGroup);
            }
        }
    }

    private void aE(ViewGroup viewGroup) {
        if (this.gNd != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gNa, this.gNb);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.gNd, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.gNa, this.gNb);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.gNd, layoutParams2);
            }
            if (this.gNd instanceof SurfaceView) {
                ((SurfaceView) this.gNd).setZOrderOnTop(true);
                ((SurfaceView) this.gNd).getHolder().setFormat(-3);
            }
        }
    }

    public void bXI() {
        aD(this.fZu);
    }

    public void bXJ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gNd != null && this.fZu != null && this.fZu.indexOfChild(this.gNd) > 0) {
            this.fZu.removeView(this.gNd);
        }
    }

    public boolean bXK() {
        return this.gNe;
    }

    public void mH(boolean z) {
        this.gNe = z;
    }

    public void mB(boolean z) {
        this.gHT = z;
    }

    public void mI(boolean z) {
        if (this.gHT && z) {
            z = false;
        }
        if (z) {
            if (this.gNd != null) {
                this.gNd.setVisibility(0);
            }
        } else if (this.gNd != null) {
            this.gNd.setVisibility(8);
        }
    }

    public void C(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.gNd != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.gNf > 0 && optInt > this.gNf && bXK() && this.gNc != null) {
                        int i = optInt - this.gNf;
                        if (this.gNh > 0) {
                            if (i > this.gNh) {
                                addHeart(i - this.gNh);
                                this.gNh = 0;
                            } else {
                                this.gNh -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.gNf = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gNj);
        this.fZu = null;
        this.gNd = null;
        this.gNi = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ai(String str, String str2, String str3) {
        if (this.gNc != null) {
            if (bXK()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.gNg == 0) {
                this.mHandler.removeCallbacks(this.gNj);
                this.mHandler.postDelayed(this.gNj, 1000L);
            }
            this.gNg++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.gNc != null && this.gNd != null && this.gNd.getVisibility() == 0) {
            this.gNc.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.gNc != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.gNc.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
