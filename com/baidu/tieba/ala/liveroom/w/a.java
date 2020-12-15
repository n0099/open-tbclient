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
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bNk;
    IZanResponseCallback bSB;
    private boolean hBw;
    private int hGB;
    private final int hGC;
    private IAlaBdZan hGD;
    private View hGE;
    private boolean hGF;
    private int hGG;
    private int hGH;
    private int hGI;
    private boolean hGJ;
    private Runnable hGK;
    private com.baidu.live.liveroom.a.a hig;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hGB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hGC = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hGF = true;
        this.mIsHost = false;
        this.hGG = -1;
        this.hGH = 0;
        this.hGI = 0;
        this.hGJ = false;
        this.hGK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.w.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hGH > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.hGH);
                    a.this.hGI += a.this.hGH;
                    a.this.hGH = 0;
                }
            }
        };
        this.bSB = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hGJ && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.q.a.aG(a.this.mLiveId, "zan_rmb");
                    a.this.hGJ = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.hig = aVar;
        this.hGB = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hGG = -1;
            this.mIsHost = z;
            this.bNk = viewGroup;
            this.hGD = BdZanViewCreater.getInst().create();
            if (this.hGD != null) {
                this.hGD.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hGE = view;
                            a.this.hGE.setClickable(false);
                            a.this.aE(a.this.bNk);
                        }
                    }
                });
                this.hGD.setZanResponseCallback(this.bSB);
                this.hGD.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ViewGroup viewGroup) {
        if (this.hGE != null && viewGroup.indexOfChild(this.hGE) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aF((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aF((FrameLayout) viewGroup);
            }
        }
    }

    private void aF(ViewGroup viewGroup) {
        if (this.hGE != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hGB, this.hGC);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hGE, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hGB, this.hGC);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hGE, layoutParams2);
            }
            if (this.hGE instanceof SurfaceView) {
                ((SurfaceView) this.hGE).setZOrderOnTop(true);
                ((SurfaceView) this.hGE).getHolder().setFormat(-3);
            }
        }
    }

    public void clL() {
        aE(this.bNk);
    }

    public void clM() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hGE != null && this.bNk != null && this.bNk.indexOfChild(this.hGE) > 0) {
            this.bNk.removeView(this.hGE);
        }
    }

    public boolean clN() {
        return this.hGF;
    }

    public void om(boolean z) {
        this.hGF = z;
    }

    public void of(boolean z) {
        this.hBw = z;
    }

    public void on(boolean z) {
        if (this.hBw && z) {
            z = false;
        }
        if (z) {
            if (this.hGE != null) {
                this.hGE.setVisibility(0);
            }
        } else if (this.hGE != null) {
            this.hGE.setVisibility(8);
        }
    }

    public void K(b bVar) {
        JSONObject jSONObject;
        if (this.hGE != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hGG > 0 && optInt > this.hGG && clN() && this.hGD != null) {
                        int i = optInt - this.hGG;
                        if (this.hGI > 0) {
                            if (i > this.hGI) {
                                addHeart(i - this.hGI);
                                this.hGI = 0;
                            } else {
                                this.hGI -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hGG = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hGK);
        this.bNk = null;
        this.hGE = null;
        this.hGJ = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void au(String str, String str2, String str3) {
        if (this.hGD != null) {
            if (clN()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hGH == 0) {
                this.mHandler.removeCallbacks(this.hGK);
                this.mHandler.postDelayed(this.hGK, 1000L);
            }
            this.hGH++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hGD != null && this.hGE != null && this.hGE.getVisibility() == 0) {
            this.hGD.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.hGD != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hGD.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
