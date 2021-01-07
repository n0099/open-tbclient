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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bRX;
    IZanResponseCallback bYi;
    private boolean hNx;
    private int hSB;
    private final int hSC;
    private IAlaBdZan hSD;
    private View hSE;
    private boolean hSF;
    private int hSG;
    private int hSH;
    private int hSI;
    private boolean hSJ;
    private Runnable hSK;
    private com.baidu.live.liveroom.a.a huc;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hSB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hSC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hSF = true;
        this.mIsHost = false;
        this.hSG = -1;
        this.hSH = 0;
        this.hSI = 0;
        this.hSJ = false;
        this.hSK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.w.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hSH > 0) {
                    a.this.s(a.this.mRoomId, a.this.mCastId, a.this.hSH);
                    a.this.hSI += a.this.hSH;
                    a.this.hSH = 0;
                }
            }
        };
        this.bYi = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hSJ && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.r.a.aE(a.this.mLiveId, "zan_rmb");
                    a.this.hSJ = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.huc = aVar;
        this.hSB = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hSG = -1;
            this.mIsHost = z;
            this.bRX = viewGroup;
            this.hSD = BdZanViewCreater.getInst().create();
            if (this.hSD != null) {
                this.hSD.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hSE = view;
                            a.this.hSE.setClickable(false);
                            a.this.aQ(a.this.bRX);
                        }
                    }
                });
                this.hSD.setZanResponseCallback(this.bYi);
                this.hSD.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(ViewGroup viewGroup) {
        if (this.hSE != null && viewGroup.indexOfChild(this.hSE) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aR((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aR((FrameLayout) viewGroup);
            }
        }
    }

    private void aR(ViewGroup viewGroup) {
        if (this.hSE != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hSB, this.hSC);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hSE, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hSB, this.hSC);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hSE, layoutParams2);
            }
            if (this.hSE instanceof SurfaceView) {
                ((SurfaceView) this.hSE).setZOrderOnTop(true);
                ((SurfaceView) this.hSE).getHolder().setFormat(-3);
            }
        }
    }

    public void coD() {
        aQ(this.bRX);
    }

    public void coE() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hSE != null && this.bRX != null && this.bRX.indexOfChild(this.hSE) > 0) {
            this.bRX.removeView(this.hSE);
        }
    }

    public boolean coF() {
        return this.hSF;
    }

    public void oL(boolean z) {
        this.hSF = z;
    }

    public void oE(boolean z) {
        this.hNx = z;
    }

    public void oM(boolean z) {
        if (this.hNx && z) {
            z = false;
        }
        if (z) {
            if (this.hSE != null) {
                this.hSE.setVisibility(0);
            }
        } else if (this.hSE != null) {
            this.hSE.setVisibility(8);
        }
    }

    public void M(b bVar) {
        JSONObject jSONObject;
        if (this.hSE != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hSG > 0 && optInt > this.hSG && coF() && this.hSD != null) {
                        int i = optInt - this.hSG;
                        if (this.hSI > 0) {
                            if (i > this.hSI) {
                                addHeart(i - this.hSI);
                                this.hSI = 0;
                            } else {
                                this.hSI -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hSG = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hSK);
        this.bRX = null;
        this.hSE = null;
        this.hSJ = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ax(String str, String str2, String str3) {
        if (this.hSD != null) {
            if (coF()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hSH == 0) {
                this.mHandler.removeCallbacks(this.hSK);
                this.mHandler.postDelayed(this.hSK, 1000L);
            }
            this.hSH++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hSD != null && this.hSE != null && this.hSE.getVisibility() == 0) {
            this.hSD.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, int i) {
        if (this.hSD != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hSD.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
