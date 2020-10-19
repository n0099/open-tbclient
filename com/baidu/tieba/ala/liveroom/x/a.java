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
    private ViewGroup bBk;
    IZanResponseCallback bGy;
    private com.baidu.live.liveroom.a.a gGU;
    private boolean hav;
    private Runnable hfA;
    private int hfr;
    private final int hfs;
    private IAlaBdZan hft;
    private View hfu;
    private boolean hfv;
    private int hfw;
    private int hfx;
    private int hfy;
    private boolean hfz;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hfr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.hfs = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.hfv = true;
        this.mIsHost = false;
        this.hfw = -1;
        this.hfx = 0;
        this.hfy = 0;
        this.hfz = false;
        this.hfA = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hfx > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.hfx);
                    a.this.hfy += a.this.hfx;
                    a.this.hfx = 0;
                }
            }
        };
        this.bGy = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hfz && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.n.a.aB(a.this.mLiveId, "zan_rmb");
                    a.this.hfz = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gGU = aVar;
        this.hfr = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hfw = -1;
            this.mIsHost = z;
            this.bBk = viewGroup;
            this.hft = BdZanViewCreater.getInst().create();
            if (this.hft != null) {
                this.hft.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hfu = view;
                            a.this.hfu.setClickable(false);
                            a.this.aG(a.this.bBk);
                        }
                    }
                });
                this.hft.setZanResponseCallback(this.bGy);
                this.hft.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(ViewGroup viewGroup) {
        if (this.hfu != null && viewGroup.indexOfChild(this.hfu) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aH((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aH((FrameLayout) viewGroup);
            }
        }
    }

    private void aH(ViewGroup viewGroup) {
        if (this.hfu != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hfr, this.hfs);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hfu, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hfr, this.hfs);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hfu, layoutParams2);
            }
            if (this.hfu instanceof SurfaceView) {
                ((SurfaceView) this.hfu).setZOrderOnTop(true);
                ((SurfaceView) this.hfu).getHolder().setFormat(-3);
            }
        }
    }

    public void ccO() {
        aG(this.bBk);
    }

    public void ccP() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hfu != null && this.bBk != null && this.bBk.indexOfChild(this.hfu) > 0) {
            this.bBk.removeView(this.hfu);
        }
    }

    public boolean ccQ() {
        return this.hfv;
    }

    public void nq(boolean z) {
        this.hfv = z;
    }

    public void nk(boolean z) {
        this.hav = z;
    }

    public void nr(boolean z) {
        if (this.hav && z) {
            z = false;
        }
        if (z) {
            if (this.hfu != null) {
                this.hfu.setVisibility(0);
            }
        } else if (this.hfu != null) {
            this.hfu.setVisibility(8);
        }
    }

    public void C(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.hfu != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hfw > 0 && optInt > this.hfw && ccQ() && this.hft != null) {
                        int i = optInt - this.hfw;
                        if (this.hfy > 0) {
                            if (i > this.hfy) {
                                addHeart(i - this.hfy);
                                this.hfy = 0;
                            } else {
                                this.hfy -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hfw = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hfA);
        this.bBk = null;
        this.hfu = null;
        this.hfz = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ak(String str, String str2, String str3) {
        if (this.hft != null) {
            if (ccQ()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hfx == 0) {
                this.mHandler.removeCallbacks(this.hfA);
                this.mHandler.postDelayed(this.hfA, 1000L);
            }
            this.hfx++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hft != null && this.hfu != null && this.hfu.getVisibility() == 0) {
            this.hft.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.hft != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hft.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
