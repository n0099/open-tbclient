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
    IZanResponseCallback bdG;
    private int fTq;
    private final int fTr;
    private IAlaBdZan fTs;
    private View fTt;
    private boolean fTu;
    private int fTv;
    private int fTw;
    private int fTx;
    private boolean fTy;
    private Runnable fTz;
    private ViewGroup faV;
    private com.baidu.live.liveroom.a.a fyI;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.fTq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.fTr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.fTu = true;
        this.mIsHost = false;
        this.fTv = -1;
        this.fTw = 0;
        this.fTx = 0;
        this.fTy = false;
        this.fTz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fTw > 0) {
                    a.this.o(a.this.mRoomId, a.this.mCastId, a.this.fTw);
                    a.this.fTx += a.this.fTw;
                    a.this.fTw = 0;
                }
            }
        };
        this.bdG = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.fTy && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.af(a.this.mLiveId, "zan_rmb");
                    a.this.fTy = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fyI = aVar;
        this.fTq = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.fTv = -1;
            this.mIsHost = z;
            this.faV = viewGroup;
            this.fTs = BdZanViewCreater.getInst().create();
            if (this.fTs != null) {
                this.fTs.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.fTt = view;
                            a.this.fTt.setClickable(false);
                            a.this.aq(a.this.faV);
                        }
                    }
                });
                this.fTs.setZanResponseCallback(this.bdG);
                this.fTs.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(ViewGroup viewGroup) {
        if (this.fTt != null && viewGroup.indexOfChild(this.fTt) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                ar((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                ar((FrameLayout) viewGroup);
            }
        }
    }

    private void ar(ViewGroup viewGroup) {
        if (this.fTt != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fTq, this.fTr);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.fTt, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fTq, this.fTr);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.fTt, layoutParams2);
            }
            if (this.fTt instanceof SurfaceView) {
                ((SurfaceView) this.fTt).setZOrderOnTop(true);
                ((SurfaceView) this.fTt).getHolder().setFormat(-3);
            }
        }
    }

    public void bBc() {
        aq(this.faV);
    }

    public void bBd() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fTt != null && this.faV != null && this.faV.indexOfChild(this.fTt) > 0) {
            this.faV.removeView(this.fTt);
        }
    }

    private boolean bBe() {
        return this.fTu;
    }

    public void kW(boolean z) {
        this.fTu = z;
    }

    public void kX(boolean z) {
        if (z) {
            if (this.fTt != null) {
                this.fTt.setVisibility(0);
            }
        } else if (this.fTt != null) {
            this.fTt.setVisibility(8);
        }
    }

    public void z(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.fTt != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.fTv > 0 && optInt > this.fTv && bBe() && this.fTs != null) {
                        int i = optInt - this.fTv;
                        if (this.fTx > 0) {
                            if (i > this.fTx) {
                                addHeart(i - this.fTx);
                                this.fTx = 0;
                            } else {
                                this.fTx -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.fTv = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fTz);
        this.faV = null;
        this.fTt = null;
        this.fTy = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ac(String str, String str2, String str3) {
        if (this.fTs != null) {
            if (bBe()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.fTw == 0) {
                this.mHandler.removeCallbacks(this.fTz);
                this.mHandler.postDelayed(this.fTz, 1000L);
            }
            this.fTw++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.fTs != null && this.fTt != null && this.fTt.getVisibility() == 0) {
            this.fTs.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, int i) {
        if (this.fTs != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.fTs.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
