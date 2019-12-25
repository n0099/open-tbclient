package com.baidu.tieba.ala.liveroom.u;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private static int fim = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
    private static final int fin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
    IZanResponseCallback aCy;
    private String aiN;
    private b eNX;
    private ViewGroup eqG;
    private IAlaBdZan fio;
    private View fip;
    private boolean fiq;
    private int fir;
    private int fis;
    private int fiu;
    private boolean fiv;
    private Runnable fiw;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.fiq = true;
        this.mIsHost = false;
        this.fir = -1;
        this.fis = 0;
        this.fiu = 0;
        this.fiv = false;
        this.fiw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.u.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fis > 0) {
                    a.this.q(a.this.aiN, a.this.mCastId, a.this.fis);
                    a.this.fiu += a.this.fis;
                    a.this.fis = 0;
                }
            }
        };
        this.aCy = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.fiv && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.j.a.V(a.this.mLiveId, "zan_rmb");
                    a.this.fiv = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eNX = bVar;
        fim = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.fir = -1;
            this.mIsHost = z;
            this.eqG = viewGroup;
            this.fio = BdZanViewCreater.getInst().create();
            if (this.fio != null) {
                this.fio.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.fip = view;
                            a.this.fip.setClickable(false);
                            a.this.ak(a.this.eqG);
                        }
                    }
                });
                this.fio.setZanResponseCallback(this.aCy);
                this.fio.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(ViewGroup viewGroup) {
        if (this.fip != null && viewGroup.indexOfChild(this.fip) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                al((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                al((FrameLayout) viewGroup);
            }
        }
    }

    private void al(ViewGroup viewGroup) {
        if (this.fip != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fim, fin);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.fip, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(fim, fin);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.fip, layoutParams2);
            }
            if (this.fip instanceof SurfaceView) {
                ((SurfaceView) this.fip).setZOrderOnTop(true);
                ((SurfaceView) this.fip).getHolder().setFormat(-3);
            }
        }
    }

    public void boO() {
        ak(this.eqG);
    }

    public void boP() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fip != null && this.eqG != null && this.eqG.indexOfChild(this.fip) > 0) {
            this.eqG.removeView(this.fip);
        }
    }

    private boolean boQ() {
        return this.fiq;
    }

    public void jD(boolean z) {
        this.fiq = z;
    }

    public void jE(boolean z) {
        if (z) {
            if (this.fip != null) {
                this.fip.setVisibility(0);
            }
        } else if (this.fip != null) {
            this.fip.setVisibility(8);
        }
    }

    public void u(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.fip != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.fir > 0 && optInt > this.fir && boQ() && this.fio != null) {
                        int i = optInt - this.fir;
                        if (this.fiu > 0) {
                            if (i > this.fiu) {
                                addHeart(i - this.fiu);
                                this.fiu = 0;
                            } else {
                                this.fiu -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.fir = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fiw);
        this.eqG = null;
        this.fip = null;
        this.fiv = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ac(String str, String str2, String str3) {
        if (this.fio != null) {
            if (boQ()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.aiN = str2;
            this.mCastId = str3;
            if (this.fis == 0) {
                this.mHandler.removeCallbacks(this.fiw);
                this.mHandler.postDelayed(this.fiw, 1000L);
            }
            this.fis++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.fio != null && this.fip != null && this.fip.getVisibility() == 0) {
            this.fio.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, String str2, int i) {
        if (this.fio != null) {
            this.fio.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
