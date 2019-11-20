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
    private static int erV = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
    private static final int erW = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
    private String aaK;
    IZanResponseCallback auF;
    private b dXZ;
    private ViewGroup dYe;
    private IAlaBdZan erX;
    private View erY;
    private boolean erZ;
    private int esa;
    private int esb;
    private int esc;
    private boolean esd;
    private Runnable ese;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.erZ = true;
        this.mIsHost = false;
        this.esa = -1;
        this.esb = 0;
        this.esc = 0;
        this.esd = false;
        this.ese = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.esb > 0) {
                    a.this.m(a.this.aaK, a.this.mCastId, a.this.esb);
                    a.this.esc += a.this.esb;
                    a.this.esb = 0;
                }
            }
        };
        this.auF = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.s.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.esd && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.f.a.N(a.this.mLiveId, "zan_rmb");
                    a.this.esd = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.dXZ = bVar;
        erV = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.esa = -1;
            this.mIsHost = z;
            this.dYe = viewGroup;
            this.erX = BdZanViewCreater.getInst().create();
            if (this.erX != null) {
                this.erX.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.erY = view;
                            a.this.erY.setClickable(false);
                            a.this.al(a.this.dYe);
                        }
                    }
                });
                this.erX.setZanResponseCallback(this.auF);
                this.erX.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(ViewGroup viewGroup) {
        if (this.erY != null && viewGroup.indexOfChild(this.erY) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                am((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                am((FrameLayout) viewGroup);
            }
        }
    }

    private void am(ViewGroup viewGroup) {
        if (this.erY != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(erV, erW);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.erY, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(erV, erW);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.erY, layoutParams2);
            }
            if (this.erY instanceof SurfaceView) {
                ((SurfaceView) this.erY).setZOrderOnTop(true);
                ((SurfaceView) this.erY).getHolder().setFormat(-3);
            }
        }
    }

    public void aXa() {
        al(this.dYe);
    }

    public void aXb() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.erY != null && this.dYe != null && this.dYe.indexOfChild(this.erY) > 0) {
            this.dYe.removeView(this.erY);
        }
    }

    private boolean aXc() {
        return this.erZ;
    }

    public void im(boolean z) {
        this.erZ = z;
    }

    public void in(boolean z) {
        if (z) {
            if (this.erY != null) {
                this.erY.setVisibility(0);
            }
        } else if (this.erY != null) {
            this.erY.setVisibility(8);
        }
    }

    public void u(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.erY != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.esa > 0 && optInt > this.esa && aXc() && this.erX != null) {
                        int i = optInt - this.esa;
                        if (this.esc > 0) {
                            if (i > this.esc) {
                                addHeart(i - this.esc);
                                this.esc = 0;
                            } else {
                                this.esc -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.esa = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.ese);
        this.dYe = null;
        this.erY = null;
        this.esd = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void R(String str, String str2, String str3) {
        if (this.erX != null) {
            if (aXc()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.aaK = str2;
            this.mCastId = str3;
            if (this.esb == 0) {
                this.mHandler.removeCallbacks(this.ese);
                this.mHandler.postDelayed(this.ese, 1000L);
            }
            this.esb++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.erX != null && this.erY != null && this.erY.getVisibility() == 0) {
            this.erX.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2, int i) {
        if (this.erX != null) {
            this.erX.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
