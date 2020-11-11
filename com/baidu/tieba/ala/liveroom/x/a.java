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
    private ViewGroup bJN;
    IZanResponseCallback bPf;
    private com.baidu.live.liveroom.a.a gYO;
    private boolean hsj;
    private int hxn;
    private final int hxo;
    private IAlaBdZan hxp;
    private View hxq;
    private boolean hxr;
    private int hxs;
    private int hxt;
    private int hxu;
    private boolean hxv;
    private Runnable hxw;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hxn = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hxo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hxr = true;
        this.mIsHost = false;
        this.hxs = -1;
        this.hxt = 0;
        this.hxu = 0;
        this.hxv = false;
        this.hxw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hxt > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.hxt);
                    a.this.hxu += a.this.hxt;
                    a.this.hxt = 0;
                }
            }
        };
        this.bPf = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hxv && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.o.a.aD(a.this.mLiveId, "zan_rmb");
                    a.this.hxv = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gYO = aVar;
        this.hxn = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hxs = -1;
            this.mIsHost = z;
            this.bJN = viewGroup;
            this.hxp = BdZanViewCreater.getInst().create();
            if (this.hxp != null) {
                this.hxp.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hxq = view;
                            a.this.hxq.setClickable(false);
                            a.this.aI(a.this.bJN);
                        }
                    }
                });
                this.hxp.setZanResponseCallback(this.bPf);
                this.hxp.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(ViewGroup viewGroup) {
        if (this.hxq != null && viewGroup.indexOfChild(this.hxq) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aJ((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aJ((FrameLayout) viewGroup);
            }
        }
    }

    private void aJ(ViewGroup viewGroup) {
        if (this.hxq != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hxn, this.hxo);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hxq, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hxn, this.hxo);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hxq, layoutParams2);
            }
            if (this.hxq instanceof SurfaceView) {
                ((SurfaceView) this.hxq).setZOrderOnTop(true);
                ((SurfaceView) this.hxq).getHolder().setFormat(-3);
            }
        }
    }

    public void ciw() {
        aI(this.bJN);
    }

    public void cix() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hxq != null && this.bJN != null && this.bJN.indexOfChild(this.hxq) > 0) {
            this.bJN.removeView(this.hxq);
        }
    }

    public boolean ciy() {
        return this.hxr;
    }

    public void nQ(boolean z) {
        this.hxr = z;
    }

    public void nJ(boolean z) {
        this.hsj = z;
    }

    public void nR(boolean z) {
        if (this.hsj && z) {
            z = false;
        }
        if (z) {
            if (this.hxq != null) {
                this.hxq.setVisibility(0);
            }
        } else if (this.hxq != null) {
            this.hxq.setVisibility(8);
        }
    }

    public void J(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.hxq != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hxs > 0 && optInt > this.hxs && ciy() && this.hxp != null) {
                        int i = optInt - this.hxs;
                        if (this.hxu > 0) {
                            if (i > this.hxu) {
                                addHeart(i - this.hxu);
                                this.hxu = 0;
                            } else {
                                this.hxu -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hxs = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hxw);
        this.bJN = null;
        this.hxq = null;
        this.hxv = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void as(String str, String str2, String str3) {
        if (this.hxp != null) {
            if (ciy()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hxt == 0) {
                this.mHandler.removeCallbacks(this.hxw);
                this.mHandler.postDelayed(this.hxw, 1000L);
            }
            this.hxt++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hxp != null && this.hxq != null && this.hxq.getVisibility() == 0) {
            this.hxp.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.hxp != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hxp.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
