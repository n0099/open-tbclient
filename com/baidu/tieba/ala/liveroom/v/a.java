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
import com.baidu.live.im.data.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.zan.BdZanViewCreater;
import com.baidu.live.tbadk.ala.zan.IAlaBdZan;
import com.baidu.live.tbadk.ala.zan.IGetZanViewCallback;
import com.baidu.live.tbadk.ala.zan.IZanResponseCallback;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private ViewGroup bRb;
    IZanResponseCallback bXv;
    private boolean hND;
    private int hSF;
    private final int hSG;
    private IAlaBdZan hSH;
    private View hSI;
    private boolean hSJ;
    private int hSK;
    private int hSL;
    private int hSM;
    private boolean hSN;
    private Runnable hSO;
    private com.baidu.live.liveroom.a.a htV;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.hSF = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds240);
        this.hSG = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds420);
        this.mHandler = new Handler();
        this.hSJ = true;
        this.mIsHost = false;
        this.hSK = -1;
        this.hSL = 0;
        this.hSM = 0;
        this.hSN = false;
        this.hSO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.hSL > 0) {
                    a.this.s(a.this.mRoomId, a.this.mCastId, a.this.hSL);
                    a.this.hSM += a.this.hSL;
                    a.this.hSL = 0;
                }
            }
        };
        this.bXv = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.hSN && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.q.a.aD(a.this.mLiveId, "zan_rmb");
                    a.this.hSN = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.htV = aVar;
        this.hSF = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void c(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.hSK = -1;
            this.mIsHost = z;
            this.bRb = viewGroup;
            this.hSH = BdZanViewCreater.getInst().create();
            if (this.hSH != null) {
                this.hSH.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.hSI = view;
                            a.this.hSI.setClickable(false);
                            a.this.aQ(a.this.bRb);
                        }
                    }
                });
                this.hSH.setZanResponseCallback(this.bXv);
                this.hSH.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(ViewGroup viewGroup) {
        if (this.hSI != null && viewGroup.indexOfChild(this.hSI) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aR((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aR((FrameLayout) viewGroup);
            }
        }
    }

    private void aR(ViewGroup viewGroup) {
        if (this.hSI != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.hSF, this.hSG);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.hSI, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.hSF, this.hSG);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds96);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.hSI, layoutParams2);
            }
            if (this.hSI instanceof SurfaceView) {
                ((SurfaceView) this.hSI).setZOrderOnTop(true);
                ((SurfaceView) this.hSI).getHolder().setFormat(-3);
            }
        }
    }

    public void clQ() {
        aQ(this.bRb);
    }

    public void clR() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hSI != null && this.bRb != null && this.bRb.indexOfChild(this.hSI) > 0) {
            this.bRb.removeView(this.hSI);
        }
    }

    public boolean clS() {
        return this.hSJ;
    }

    public void oR(boolean z) {
        this.hSJ = z;
    }

    public void oK(boolean z) {
        this.hND = z;
    }

    public void oS(boolean z) {
        if (this.hND && z) {
            z = false;
        }
        if (z) {
            if (this.hSI != null) {
                this.hSI.setVisibility(0);
            }
        } else if (this.hSI != null) {
            this.hSI.setVisibility(8);
        }
    }

    public void R(b bVar) {
        JSONObject jSONObject;
        if (this.hSI != null) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.hSK > 0 && optInt > this.hSK && clS() && this.hSH != null) {
                        int i = optInt - this.hSK;
                        if (this.hSM > 0) {
                            if (i > this.hSM) {
                                addHeart(i - this.hSM);
                                this.hSM = 0;
                            } else {
                                this.hSM -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.hSK = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.hSO);
        this.bRb = null;
        this.hSI = null;
        this.hSN = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ax(String str, String str2, String str3) {
        if (this.hSH != null) {
            if (clS()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.hSL == 0) {
                this.mHandler.removeCallbacks(this.hSO);
                this.mHandler.postDelayed(this.hSO, 1000L);
            }
            this.hSL++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.hSH != null && this.hSI != null && this.hSI.getVisibility() == 0) {
            this.hSH.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2, int i) {
        if (this.hSH != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.hSH.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
