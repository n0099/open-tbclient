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
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bIc;
    IZanResponseCallback bNv;
    private com.baidu.live.liveroom.a.a gYv;
    private boolean hrQ;
    private int hwU;
    private final int hwV;
    private IAlaBdZan hwW;
    private View hwX;
    private boolean hwY;
    private int hwZ;
    private int hxa;
    private int hxb;
    private boolean hxc;
    private Runnable hxd;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hwU = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hwV = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hwY = true;
        this.mIsHost = false;
        this.hwZ = -1;
        this.hxa = 0;
        this.hxb = 0;
        this.hxc = false;
        this.hxd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hxa > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.hxa);
                    a.this.hxb += a.this.hxa;
                    a.this.hxa = 0;
                }
            }
        };
        this.bNv = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hxc && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.o.a.aC(a.this.mLiveId, "zan_rmb");
                    a.this.hxc = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gYv = aVar;
        this.hwU = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hwZ = -1;
            this.mIsHost = z;
            this.bIc = viewGroup;
            this.hwW = BdZanViewCreater.getInst().create();
            if (this.hwW != null) {
                this.hwW.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hwX = view;
                            a.this.hwX.setClickable(false);
                            a.this.aE(a.this.bIc);
                        }
                    }
                });
                this.hwW.setZanResponseCallback(this.bNv);
                this.hwW.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ViewGroup viewGroup) {
        if (this.hwX != null && viewGroup.indexOfChild(this.hwX) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aF((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aF((FrameLayout) viewGroup);
            }
        }
    }

    private void aF(ViewGroup viewGroup) {
        if (this.hwX != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hwU, this.hwV);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hwX, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hwU, this.hwV);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hwX, layoutParams2);
            }
            if (this.hwX instanceof SurfaceView) {
                ((SurfaceView) this.hwX).setZOrderOnTop(true);
                ((SurfaceView) this.hwX).getHolder().setFormat(-3);
            }
        }
    }

    public void chP() {
        aE(this.bIc);
    }

    public void chQ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hwX != null && this.bIc != null && this.bIc.indexOfChild(this.hwX) > 0) {
            this.bIc.removeView(this.hwX);
        }
    }

    public boolean chR() {
        return this.hwY;
    }

    public void nR(boolean z) {
        this.hwY = z;
    }

    public void nK(boolean z) {
        this.hrQ = z;
    }

    public void nS(boolean z) {
        if (this.hrQ && z) {
            z = false;
        }
        if (z) {
            if (this.hwX != null) {
                this.hwX.setVisibility(0);
            }
        } else if (this.hwX != null) {
            this.hwX.setVisibility(8);
        }
    }

    public void J(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.hwX != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hwZ > 0 && optInt > this.hwZ && chR() && this.hwW != null) {
                        int i = optInt - this.hwZ;
                        if (this.hxb > 0) {
                            if (i > this.hxb) {
                                addHeart(i - this.hxb);
                                this.hxb = 0;
                            } else {
                                this.hxb -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hwZ = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hxd);
        this.bIc = null;
        this.hwX = null;
        this.hxc = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void as(String str, String str2, String str3) {
        if (this.hwW != null) {
            if (chR()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hxa == 0) {
                this.mHandler.removeCallbacks(this.hxd);
                this.mHandler.postDelayed(this.hxd, 1000L);
            }
            this.hxa++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hwW != null && this.hwX != null && this.hwX.getVisibility() == 0) {
            this.hwW.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.hwW != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hwW.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
