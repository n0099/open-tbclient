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
import com.baidu.live.r.a;
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
    IZanResponseCallback aDq;
    private b ePv;
    private ViewGroup erT;
    private IAlaBdZan flB;
    private View flC;
    private boolean flD;
    private int flE;
    private int flF;
    private int flG;
    private boolean flH;
    private Runnable flI;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private static int flz = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
    private static final int flA = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);

    public a(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.flD = true;
        this.mIsHost = false;
        this.flE = -1;
        this.flF = 0;
        this.flG = 0;
        this.flH = false;
        this.flI = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.flF > 0) {
                    a.this.q(a.this.mRoomId, a.this.mCastId, a.this.flF);
                    a.this.flG += a.this.flF;
                    a.this.flF = 0;
                }
            }
        };
        this.aDq = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.flH && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.k.a.U(a.this.mLiveId, "zan_rmb");
                    a.this.flH = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.ePv = bVar;
        flz = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.flE = -1;
            this.mIsHost = z;
            this.erT = viewGroup;
            this.flB = BdZanViewCreater.getInst().create();
            if (this.flB != null) {
                this.flB.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.flC = view;
                            a.this.flC.setClickable(false);
                            a.this.ao(a.this.erT);
                        }
                    }
                });
                this.flB.setZanResponseCallback(this.aDq);
                this.flB.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(ViewGroup viewGroup) {
        if (this.flC != null && viewGroup.indexOfChild(this.flC) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                ap((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                ap((FrameLayout) viewGroup);
            }
        }
    }

    private void ap(ViewGroup viewGroup) {
        if (this.flC != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(flz, flA);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.flC, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(flz, flA);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.flC, layoutParams2);
            }
            if (this.flC instanceof SurfaceView) {
                ((SurfaceView) this.flC).setZOrderOnTop(true);
                ((SurfaceView) this.flC).getHolder().setFormat(-3);
            }
        }
    }

    public void bpP() {
        ao(this.erT);
    }

    public void bpQ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.flC != null && this.erT != null && this.erT.indexOfChild(this.flC) > 0) {
            this.erT.removeView(this.flC);
        }
    }

    private boolean bpR() {
        return this.flD;
    }

    public void jO(boolean z) {
        this.flD = z;
    }

    public void jP(boolean z) {
        if (z) {
            if (this.flC != null) {
                this.flC.setVisibility(0);
            }
        } else if (this.flC != null) {
            this.flC.setVisibility(8);
        }
    }

    public void u(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.flC != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.flE > 0 && optInt > this.flE && bpR() && this.flB != null) {
                        int i = optInt - this.flE;
                        if (this.flG > 0) {
                            if (i > this.flG) {
                                addHeart(i - this.flG);
                                this.flG = 0;
                            } else {
                                this.flG -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.flE = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.flI);
        this.erT = null;
        this.flC = null;
        this.flH = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ad(String str, String str2, String str3) {
        if (this.flB != null) {
            if (bpR()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.flF == 0) {
                this.mHandler.removeCallbacks(this.flI);
                this.mHandler.postDelayed(this.flI, 1000L);
            }
            this.flF++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.flB != null && this.flC != null && this.flC.getVisibility() == 0) {
            this.flB.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, String str2, int i) {
        if (this.flB != null) {
            this.flB.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
