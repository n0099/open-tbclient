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
    IZanResponseCallback bzV;
    private boolean gLy;
    private int gQA;
    private int gQB;
    private boolean gQC;
    private Runnable gQD;
    private int gQu;
    private final int gQv;
    private IAlaBdZan gQw;
    private View gQx;
    private boolean gQy;
    private int gQz;
    private ViewGroup gcM;
    private com.baidu.live.liveroom.a.a gsz;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gQu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.gQv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.gQy = true;
        this.mIsHost = false;
        this.gQz = -1;
        this.gQA = 0;
        this.gQB = 0;
        this.gQC = false;
        this.gQD = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gQA > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.gQA);
                    a.this.gQB += a.this.gQA;
                    a.this.gQA = 0;
                }
            }
        };
        this.bzV = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.gQC && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.n.a.ay(a.this.mLiveId, "zan_rmb");
                    a.this.gQC = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gsz = aVar;
        this.gQu = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.gQz = -1;
            this.mIsHost = z;
            this.gcM = viewGroup;
            this.gQw = BdZanViewCreater.getInst().create();
            if (this.gQw != null) {
                this.gQw.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.gQx = view;
                            a.this.gQx.setClickable(false);
                            a.this.aE(a.this.gcM);
                        }
                    }
                });
                this.gQw.setZanResponseCallback(this.bzV);
                this.gQw.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ViewGroup viewGroup) {
        if (this.gQx != null && viewGroup.indexOfChild(this.gQx) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aF((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aF((FrameLayout) viewGroup);
            }
        }
    }

    private void aF(ViewGroup viewGroup) {
        if (this.gQx != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gQu, this.gQv);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.gQx, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.gQu, this.gQv);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.gQx, layoutParams2);
            }
            if (this.gQx instanceof SurfaceView) {
                ((SurfaceView) this.gQx).setZOrderOnTop(true);
                ((SurfaceView) this.gQx).getHolder().setFormat(-3);
            }
        }
    }

    public void bZq() {
        aE(this.gcM);
    }

    public void bZr() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gQx != null && this.gcM != null && this.gcM.indexOfChild(this.gQx) > 0) {
            this.gcM.removeView(this.gQx);
        }
    }

    public boolean bZs() {
        return this.gQy;
    }

    public void mN(boolean z) {
        this.gQy = z;
    }

    public void mH(boolean z) {
        this.gLy = z;
    }

    public void mO(boolean z) {
        if (this.gLy && z) {
            z = false;
        }
        if (z) {
            if (this.gQx != null) {
                this.gQx.setVisibility(0);
            }
        } else if (this.gQx != null) {
            this.gQx.setVisibility(8);
        }
    }

    public void C(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.gQx != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.gQz > 0 && optInt > this.gQz && bZs() && this.gQw != null) {
                        int i = optInt - this.gQz;
                        if (this.gQB > 0) {
                            if (i > this.gQB) {
                                addHeart(i - this.gQB);
                                this.gQB = 0;
                            } else {
                                this.gQB -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.gQz = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gQD);
        this.gcM = null;
        this.gQx = null;
        this.gQC = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ai(String str, String str2, String str3) {
        if (this.gQw != null) {
            if (bZs()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.gQA == 0) {
                this.mHandler.removeCallbacks(this.gQD);
                this.mHandler.postDelayed(this.gQD, 1000L);
            }
            this.gQA++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.gQw != null && this.gQx != null && this.gQx.getVisibility() == 0) {
            this.gQw.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.gQw != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.gQw.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
