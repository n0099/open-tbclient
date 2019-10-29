package com.baidu.tieba.ala.liveroom.s;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private static int esM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
    private static final int esN = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
    private String abd;
    IZanResponseCallback auX;
    private b dYQ;
    private ViewGroup dYV;
    private IAlaBdZan esO;
    private View esP;
    private boolean esQ;
    private int esR;
    private int esS;
    private int esT;
    private boolean esU;
    private Runnable esV;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.esQ = true;
        this.mIsHost = false;
        this.esR = -1;
        this.esS = 0;
        this.esT = 0;
        this.esU = false;
        this.esV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.esS > 0) {
                    a.this.m(a.this.abd, a.this.mCastId, a.this.esS);
                    a.this.esT += a.this.esS;
                    a.this.esS = 0;
                }
            }
        };
        this.auX = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.s.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.esU && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.f.a.N(a.this.mLiveId, "zan_rmb");
                    a.this.esU = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.dYQ = bVar;
        esM = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.esR = -1;
            this.mIsHost = z;
            this.dYV = viewGroup;
            this.esO = BdZanViewCreater.getInst().create();
            if (this.esO != null) {
                this.esO.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.esP = view;
                            a.this.esP.setClickable(false);
                            a.this.al(a.this.dYV);
                        }
                    }
                });
                this.esO.setZanResponseCallback(this.auX);
                this.esO.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(ViewGroup viewGroup) {
        if (this.esP != null && viewGroup.indexOfChild(this.esP) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                am((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                am((FrameLayout) viewGroup);
            }
        }
    }

    private void am(ViewGroup viewGroup) {
        if (this.esP != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(esM, esN);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.esP, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(esM, esN);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.esP, layoutParams2);
            }
            if (this.esP instanceof SurfaceView) {
                ((SurfaceView) this.esP).setZOrderOnTop(true);
                ((SurfaceView) this.esP).getHolder().setFormat(-3);
            }
        }
    }

    public void aXc() {
        al(this.dYV);
    }

    public void aXd() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.esP != null && this.dYV != null && this.dYV.indexOfChild(this.esP) > 0) {
            this.dYV.removeView(this.esP);
        }
    }

    private boolean aXe() {
        return this.esQ;
    }

    public void im(boolean z) {
        this.esQ = z;
    }

    public void in(boolean z) {
        if (z) {
            if (this.esP != null) {
                this.esP.setVisibility(0);
            }
        } else if (this.esP != null) {
            this.esP.setVisibility(8);
        }
    }

    public void t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.esP != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.esR > 0 && optInt > this.esR && aXe() && this.esO != null) {
                        int i = optInt - this.esR;
                        if (this.esT > 0) {
                            if (i > this.esT) {
                                addHeart(i - this.esT);
                                this.esT = 0;
                            } else {
                                this.esT -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.esR = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.esV);
        this.dYV = null;
        this.esP = null;
        this.esU = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void R(String str, String str2, String str3) {
        if (this.esO != null) {
            if (aXe()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.abd = str2;
            this.mCastId = str3;
            if (this.esS == 0) {
                this.mHandler.removeCallbacks(this.esV);
                this.mHandler.postDelayed(this.esV, 1000L);
            }
            this.esS++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.esO != null && this.esP != null && this.esP.getVisibility() == 0) {
            this.esO.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2, int i) {
        if (this.esO != null) {
            this.esO.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
