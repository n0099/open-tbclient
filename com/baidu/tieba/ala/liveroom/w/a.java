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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    IZanResponseCallback bqE;
    private ViewGroup fNw;
    private int gAD;
    private final int gAE;
    private IAlaBdZan gAF;
    private View gAG;
    private boolean gAH;
    private int gAI;
    private int gAJ;
    private int gAK;
    private boolean gAL;
    private Runnable gAM;
    private com.baidu.live.liveroom.a.a gcZ;
    private boolean guV;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gAD = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.gAE = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.gAH = true;
        this.mIsHost = false;
        this.gAI = -1;
        this.gAJ = 0;
        this.gAK = 0;
        this.gAL = false;
        this.gAM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.w.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gAJ > 0) {
                    a.this.o(a.this.mRoomId, a.this.mCastId, a.this.gAJ);
                    a.this.gAK += a.this.gAJ;
                    a.this.gAJ = 0;
                }
            }
        };
        this.bqE = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.gAL && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.m.a.au(a.this.mLiveId, "zan_rmb");
                    a.this.gAL = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gcZ = aVar;
        this.gAD = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.gAI = -1;
            this.mIsHost = z;
            this.fNw = viewGroup;
            this.gAF = BdZanViewCreater.getInst().create();
            if (this.gAF != null) {
                this.gAF.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.gAG = view;
                            a.this.gAG.setClickable(false);
                            a.this.aE(a.this.fNw);
                        }
                    }
                });
                this.gAF.setZanResponseCallback(this.bqE);
                this.gAF.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ViewGroup viewGroup) {
        if (this.gAG != null && viewGroup.indexOfChild(this.gAG) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aF((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aF((FrameLayout) viewGroup);
            }
        }
    }

    private void aF(ViewGroup viewGroup) {
        if (this.gAG != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gAD, this.gAE);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.gAG, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.gAD, this.gAE);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.gAG, layoutParams2);
            }
            if (this.gAG instanceof SurfaceView) {
                ((SurfaceView) this.gAG).setZOrderOnTop(true);
                ((SurfaceView) this.gAG).getHolder().setFormat(-3);
            }
        }
    }

    public void bNI() {
        aE(this.fNw);
    }

    public void bNJ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gAG != null && this.fNw != null && this.fNw.indexOfChild(this.gAG) > 0) {
            this.fNw.removeView(this.gAG);
        }
    }

    private boolean bNK() {
        return this.gAH;
    }

    public void mf(boolean z) {
        this.gAH = z;
    }

    public void lX(boolean z) {
        this.guV = z;
    }

    public void mg(boolean z) {
        if (this.guV && z) {
            z = false;
        }
        if (z) {
            if (this.gAG != null) {
                this.gAG.setVisibility(0);
            }
        } else if (this.gAG != null) {
            this.gAG.setVisibility(8);
        }
    }

    public void A(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.gAG != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.gAI > 0 && optInt > this.gAI && bNK() && this.gAF != null) {
                        int i = optInt - this.gAI;
                        if (this.gAK > 0) {
                            if (i > this.gAK) {
                                addHeart(i - this.gAK);
                                this.gAK = 0;
                            } else {
                                this.gAK -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.gAI = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gAM);
        this.fNw = null;
        this.gAG = null;
        this.gAL = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ai(String str, String str2, String str3) {
        if (this.gAF != null) {
            if (bNK()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.gAJ == 0) {
                this.mHandler.removeCallbacks(this.gAM);
                this.mHandler.postDelayed(this.gAM, 1000L);
            }
            this.gAJ++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.gAF != null && this.gAG != null && this.gAG.getVisibility() == 0) {
            this.gAF.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, int i) {
        if (this.gAF != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.gAF.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
