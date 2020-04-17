package com.baidu.tieba.ala.liveroom.v;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    IZanResponseCallback bdB;
    private int fTl;
    private final int fTm;
    private IAlaBdZan fTn;
    private View fTo;
    private boolean fTp;
    private int fTq;
    private int fTr;
    private int fTs;
    private boolean fTt;
    private Runnable fTu;
    private ViewGroup faQ;
    private com.baidu.live.liveroom.a.a fyD;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fTl = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.fTm = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.fTp = true;
        this.mIsHost = false;
        this.fTq = -1;
        this.fTr = 0;
        this.fTs = 0;
        this.fTt = false;
        this.fTu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fTr > 0) {
                    a.this.o(a.this.mRoomId, a.this.mCastId, a.this.fTr);
                    a.this.fTs += a.this.fTr;
                    a.this.fTr = 0;
                }
            }
        };
        this.bdB = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.fTt && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.af(a.this.mLiveId, "zan_rmb");
                    a.this.fTt = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fyD = aVar;
        this.fTl = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.fTq = -1;
            this.mIsHost = z;
            this.faQ = viewGroup;
            this.fTn = BdZanViewCreater.getInst().create();
            if (this.fTn != null) {
                this.fTn.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.fTo = view;
                            a.this.fTo.setClickable(false);
                            a.this.aq(a.this.faQ);
                        }
                    }
                });
                this.fTn.setZanResponseCallback(this.bdB);
                this.fTn.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(ViewGroup viewGroup) {
        if (this.fTo != null && viewGroup.indexOfChild(this.fTo) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                ar((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                ar((FrameLayout) viewGroup);
            }
        }
    }

    private void ar(ViewGroup viewGroup) {
        if (this.fTo != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fTl, this.fTm);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.fTo, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fTl, this.fTm);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.fTo, layoutParams2);
            }
            if (this.fTo instanceof SurfaceView) {
                ((SurfaceView) this.fTo).setZOrderOnTop(true);
                ((SurfaceView) this.fTo).getHolder().setFormat(-3);
            }
        }
    }

    public void bBe() {
        aq(this.faQ);
    }

    public void bBf() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fTo != null && this.faQ != null && this.faQ.indexOfChild(this.fTo) > 0) {
            this.faQ.removeView(this.fTo);
        }
    }

    private boolean bBg() {
        return this.fTp;
    }

    public void kW(boolean z) {
        this.fTp = z;
    }

    public void kX(boolean z) {
        if (z) {
            if (this.fTo != null) {
                this.fTo.setVisibility(0);
            }
        } else if (this.fTo != null) {
            this.fTo.setVisibility(8);
        }
    }

    public void z(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.fTo != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.fTq > 0 && optInt > this.fTq && bBg() && this.fTn != null) {
                        int i = optInt - this.fTq;
                        if (this.fTs > 0) {
                            if (i > this.fTs) {
                                addHeart(i - this.fTs);
                                this.fTs = 0;
                            } else {
                                this.fTs -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.fTq = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fTu);
        this.faQ = null;
        this.fTo = null;
        this.fTt = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ac(String str, String str2, String str3) {
        if (this.fTn != null) {
            if (bBg()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.fTr == 0) {
                this.mHandler.removeCallbacks(this.fTu);
                this.mHandler.postDelayed(this.fTu, 1000L);
            }
            this.fTr++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.fTn != null && this.fTo != null && this.fTo.getVisibility() == 0) {
            this.fTn.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, int i) {
        if (this.fTn != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.fTn.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
