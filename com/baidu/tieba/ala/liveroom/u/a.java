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
    private static int foP = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
    private static final int foQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
    IZanResponseCallback aHN;
    private com.baidu.live.liveroom.a.a eUj;
    private ViewGroup ewN;
    private IAlaBdZan foR;
    private View foS;
    private boolean foT;
    private int foU;
    private int foV;
    private int foW;
    private boolean foX;
    private Runnable foY;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.foT = true;
        this.mIsHost = false;
        this.foU = -1;
        this.foV = 0;
        this.foW = 0;
        this.foX = false;
        this.foY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.u.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.foV > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.foV);
                    a.this.foW += a.this.foV;
                    a.this.foV = 0;
                }
            }
        };
        this.aHN = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.foX && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.ab(a.this.mLiveId, "zan_rmb");
                    a.this.foX = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eUj = aVar;
        foP = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.foU = -1;
            this.mIsHost = z;
            this.ewN = viewGroup;
            this.foR = BdZanViewCreater.getInst().create();
            if (this.foR != null) {
                this.foR.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.foS = view;
                            a.this.foS.setClickable(false);
                            a.this.ap(a.this.ewN);
                        }
                    }
                });
                this.foR.setZanResponseCallback(this.aHN);
                this.foR.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(ViewGroup viewGroup) {
        if (this.foS != null && viewGroup.indexOfChild(this.foS) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aq((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aq((FrameLayout) viewGroup);
            }
        }
    }

    private void aq(ViewGroup viewGroup) {
        if (this.foS != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(foP, foQ);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.foS, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(foP, foQ);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.foS, layoutParams2);
            }
            if (this.foS instanceof SurfaceView) {
                ((SurfaceView) this.foS).setZOrderOnTop(true);
                ((SurfaceView) this.foS).getHolder().setFormat(-3);
            }
        }
    }

    public void brB() {
        ap(this.ewN);
    }

    public void brC() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.foS != null && this.ewN != null && this.ewN.indexOfChild(this.foS) > 0) {
            this.ewN.removeView(this.foS);
        }
    }

    private boolean brD() {
        return this.foT;
    }

    public void jS(boolean z) {
        this.foT = z;
    }

    public void jT(boolean z) {
        if (z) {
            if (this.foS != null) {
                this.foS.setVisibility(0);
            }
        } else if (this.foS != null) {
            this.foS.setVisibility(8);
        }
    }

    public void v(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.foS != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.foU > 0 && optInt > this.foU && brD() && this.foR != null) {
                        int i = optInt - this.foU;
                        if (this.foW > 0) {
                            if (i > this.foW) {
                                addHeart(i - this.foW);
                                this.foW = 0;
                            } else {
                                this.foW -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.foU = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.foY);
        this.ewN = null;
        this.foS = null;
        this.foX = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ad(String str, String str2, String str3) {
        if (this.foR != null) {
            if (brD()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.foV == 0) {
                this.mHandler.removeCallbacks(this.foY);
                this.mHandler.postDelayed(this.foY, 1000L);
            }
            this.foV++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.foR != null && this.foS != null && this.foS.getVisibility() == 0) {
            this.foR.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.foR != null) {
            this.foR.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
