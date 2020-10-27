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
    private ViewGroup bEg;
    IZanResponseCallback bJz;
    private com.baidu.live.liveroom.a.a gSJ;
    private boolean hml;
    private int hrq;
    private final int hrr;
    private IAlaBdZan hrs;
    private View hrt;
    private boolean hru;
    private int hrv;
    private int hrw;
    private int hrx;
    private boolean hry;
    private Runnable hrz;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hrq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.hrr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.hru = true;
        this.mIsHost = false;
        this.hrv = -1;
        this.hrw = 0;
        this.hrx = 0;
        this.hry = false;
        this.hrz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hrw > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.hrw);
                    a.this.hrx += a.this.hrw;
                    a.this.hrw = 0;
                }
            }
        };
        this.bJz = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hry && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.o.a.aC(a.this.mLiveId, "zan_rmb");
                    a.this.hry = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gSJ = aVar;
        this.hrq = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hrv = -1;
            this.mIsHost = z;
            this.bEg = viewGroup;
            this.hrs = BdZanViewCreater.getInst().create();
            if (this.hrs != null) {
                this.hrs.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hrt = view;
                            a.this.hrt.setClickable(false);
                            a.this.aG(a.this.bEg);
                        }
                    }
                });
                this.hrs.setZanResponseCallback(this.bJz);
                this.hrs.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(ViewGroup viewGroup) {
        if (this.hrt != null && viewGroup.indexOfChild(this.hrt) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aH((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aH((FrameLayout) viewGroup);
            }
        }
    }

    private void aH(ViewGroup viewGroup) {
        if (this.hrt != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hrq, this.hrr);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hrt, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hrq, this.hrr);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hrt, layoutParams2);
            }
            if (this.hrt instanceof SurfaceView) {
                ((SurfaceView) this.hrt).setZOrderOnTop(true);
                ((SurfaceView) this.hrt).getHolder().setFormat(-3);
            }
        }
    }

    public void cfU() {
        aG(this.bEg);
    }

    public void cfV() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hrt != null && this.bEg != null && this.bEg.indexOfChild(this.hrt) > 0) {
            this.bEg.removeView(this.hrt);
        }
    }

    public boolean cfW() {
        return this.hru;
    }

    public void nH(boolean z) {
        this.hru = z;
    }

    public void nA(boolean z) {
        this.hml = z;
    }

    public void nI(boolean z) {
        if (this.hml && z) {
            z = false;
        }
        if (z) {
            if (this.hrt != null) {
                this.hrt.setVisibility(0);
            }
        } else if (this.hrt != null) {
            this.hrt.setVisibility(8);
        }
    }

    public void G(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.hrt != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hrv > 0 && optInt > this.hrv && cfW() && this.hrs != null) {
                        int i = optInt - this.hrv;
                        if (this.hrx > 0) {
                            if (i > this.hrx) {
                                addHeart(i - this.hrx);
                                this.hrx = 0;
                            } else {
                                this.hrx -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hrv = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hrz);
        this.bEg = null;
        this.hrt = null;
        this.hry = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ar(String str, String str2, String str3) {
        if (this.hrs != null) {
            if (cfW()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hrw == 0) {
                this.mHandler.removeCallbacks(this.hrz);
                this.mHandler.postDelayed(this.hrz, 1000L);
            }
            this.hrw++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hrs != null && this.hrt != null && this.hrt.getVisibility() == 0) {
            this.hrs.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.hrs != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hrs.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
