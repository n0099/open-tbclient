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
    private boolean hBu;
    private final int hGA;
    private IAlaBdZan hGB;
    private View hGC;
    private boolean hGD;
    private int hGE;
    private int hGF;
    private int hGG;
    private boolean hGH;
    private Runnable hGI;
    private int hGz;
    private com.baidu.live.liveroom.a.a hie;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hGz = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hGA = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hGD = true;
        this.mIsHost = false;
        this.hGE = -1;
        this.hGF = 0;
        this.hGG = 0;
        this.hGH = false;
        this.hGI = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.w.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hGF > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.hGF);
                    a.this.hGG += a.this.hGF;
                    a.this.hGF = 0;
                }
            }
        };
        this.bSB = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hGH && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.q.a.aG(a.this.mLiveId, "zan_rmb");
                    a.this.hGH = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.hie = aVar;
        this.hGz = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hGE = -1;
            this.mIsHost = z;
            this.bNk = viewGroup;
            this.hGB = BdZanViewCreater.getInst().create();
            if (this.hGB != null) {
                this.hGB.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hGC = view;
                            a.this.hGC.setClickable(false);
                            a.this.aE(a.this.bNk);
                        }
                    }
                });
                this.hGB.setZanResponseCallback(this.bSB);
                this.hGB.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ViewGroup viewGroup) {
        if (this.hGC != null && viewGroup.indexOfChild(this.hGC) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aF((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aF((FrameLayout) viewGroup);
            }
        }
    }

    private void aF(ViewGroup viewGroup) {
        if (this.hGC != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hGz, this.hGA);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hGC, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hGz, this.hGA);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hGC, layoutParams2);
            }
            if (this.hGC instanceof SurfaceView) {
                ((SurfaceView) this.hGC).setZOrderOnTop(true);
                ((SurfaceView) this.hGC).getHolder().setFormat(-3);
            }
        }
    }

    public void clK() {
        aE(this.bNk);
    }

    public void clL() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hGC != null && this.bNk != null && this.bNk.indexOfChild(this.hGC) > 0) {
            this.bNk.removeView(this.hGC);
        }
    }

    public boolean clM() {
        return this.hGD;
    }

    public void om(boolean z) {
        this.hGD = z;
    }

    public void of(boolean z) {
        this.hBu = z;
    }

    public void on(boolean z) {
        if (this.hBu && z) {
            z = false;
        }
        if (z) {
            if (this.hGC != null) {
                this.hGC.setVisibility(0);
            }
        } else if (this.hGC != null) {
            this.hGC.setVisibility(8);
        }
    }

    public void K(b bVar) {
        JSONObject jSONObject;
        if (this.hGC != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hGE > 0 && optInt > this.hGE && clM() && this.hGB != null) {
                        int i = optInt - this.hGE;
                        if (this.hGG > 0) {
                            if (i > this.hGG) {
                                addHeart(i - this.hGG);
                                this.hGG = 0;
                            } else {
                                this.hGG -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hGE = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hGI);
        this.bNk = null;
        this.hGC = null;
        this.hGH = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void au(String str, String str2, String str3) {
        if (this.hGB != null) {
            if (clM()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hGF == 0) {
                this.mHandler.removeCallbacks(this.hGI);
                this.mHandler.postDelayed(this.hGI, 1000L);
            }
            this.hGF++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hGB != null && this.hGC != null && this.hGC.getVisibility() == 0) {
            this.hGB.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.hGB != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hGB.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
