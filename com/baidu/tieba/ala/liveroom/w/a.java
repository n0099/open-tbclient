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
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    IZanResponseCallback bqj;
    private ViewGroup fIb;
    private com.baidu.live.liveroom.a.a fXS;
    private boolean gpU;
    private int gvg;
    private final int gvh;
    private IAlaBdZan gvi;
    private View gvj;
    private boolean gvk;
    private int gvl;
    private int gvm;
    private int gvn;
    private boolean gvo;
    private Runnable gvp;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gvg = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.gvh = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.gvk = true;
        this.mIsHost = false;
        this.gvl = -1;
        this.gvm = 0;
        this.gvn = 0;
        this.gvo = false;
        this.gvp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.w.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gvm > 0) {
                    a.this.o(a.this.mRoomId, a.this.mCastId, a.this.gvm);
                    a.this.gvn += a.this.gvm;
                    a.this.gvm = 0;
                }
            }
        };
        this.bqj = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.gvo && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.m.a.av(a.this.mLiveId, "zan_rmb");
                    a.this.gvo = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fXS = aVar;
        this.gvg = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.gvl = -1;
            this.mIsHost = z;
            this.fIb = viewGroup;
            this.gvi = BdZanViewCreater.getInst().create();
            if (this.gvi != null) {
                this.gvi.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.w.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.gvj = view;
                            a.this.gvj.setClickable(false);
                            a.this.aD(a.this.fIb);
                        }
                    }
                });
                this.gvi.setZanResponseCallback(this.bqj);
                this.gvi.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(ViewGroup viewGroup) {
        if (this.gvj != null && viewGroup.indexOfChild(this.gvj) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aE((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aE((FrameLayout) viewGroup);
            }
        }
    }

    private void aE(ViewGroup viewGroup) {
        if (this.gvj != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gvg, this.gvh);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.gvj, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.gvg, this.gvh);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.gvj, layoutParams2);
            }
            if (this.gvj instanceof SurfaceView) {
                ((SurfaceView) this.gvj).setZOrderOnTop(true);
                ((SurfaceView) this.gvj).getHolder().setFormat(-3);
            }
        }
    }

    public void bKD() {
        aD(this.fIb);
    }

    public void bKE() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gvj != null && this.fIb != null && this.fIb.indexOfChild(this.gvj) > 0) {
            this.fIb.removeView(this.gvj);
        }
    }

    private boolean bKF() {
        return this.gvk;
    }

    public void lB(boolean z) {
        this.gvk = z;
    }

    public void lu(boolean z) {
        this.gpU = z;
    }

    public void lC(boolean z) {
        if (this.gpU && z) {
            z = false;
        }
        if (z) {
            if (this.gvj != null) {
                this.gvj.setVisibility(0);
            }
        } else if (this.gvj != null) {
            this.gvj.setVisibility(8);
        }
    }

    public void A(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.gvj != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.gvl > 0 && optInt > this.gvl && bKF() && this.gvi != null) {
                        int i = optInt - this.gvl;
                        if (this.gvn > 0) {
                            if (i > this.gvn) {
                                addHeart(i - this.gvn);
                                this.gvn = 0;
                            } else {
                                this.gvn -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.gvl = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gvp);
        this.fIb = null;
        this.gvj = null;
        this.gvo = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ah(String str, String str2, String str3) {
        if (this.gvi != null) {
            if (bKF()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.gvm == 0) {
                this.mHandler.removeCallbacks(this.gvp);
                this.mHandler.postDelayed(this.gvp, 1000L);
            }
            this.gvm++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.gvi != null && this.gvj != null && this.gvj.getVisibility() == 0) {
            this.gvi.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, int i) {
        if (this.gvi != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.gvi.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
