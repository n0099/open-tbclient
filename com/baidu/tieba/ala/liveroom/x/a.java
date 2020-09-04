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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    IZanResponseCallback bwx;
    private ViewGroup fZy;
    private boolean gHX;
    private int gNe;
    private final int gNf;
    private IAlaBdZan gNg;
    private View gNh;
    private boolean gNi;
    private int gNj;
    private int gNk;
    private int gNl;
    private boolean gNm;
    private Runnable gNn;
    private com.baidu.live.liveroom.a.a gpl;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gNe = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.gNf = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.gNi = true;
        this.mIsHost = false;
        this.gNj = -1;
        this.gNk = 0;
        this.gNl = 0;
        this.gNm = false;
        this.gNn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.x.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gNk > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.gNk);
                    a.this.gNl += a.this.gNk;
                    a.this.gNk = 0;
                }
            }
        };
        this.bwx = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.gNm && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.m.a.ay(a.this.mLiveId, "zan_rmb");
                    a.this.gNm = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.gpl = aVar;
        this.gNe = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.gNj = -1;
            this.mIsHost = z;
            this.fZy = viewGroup;
            this.gNg = BdZanViewCreater.getInst().create();
            if (this.gNg != null) {
                this.gNg.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.x.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.gNh = view;
                            a.this.gNh.setClickable(false);
                            a.this.aD(a.this.fZy);
                        }
                    }
                });
                this.gNg.setZanResponseCallback(this.bwx);
                this.gNg.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(ViewGroup viewGroup) {
        if (this.gNh != null && viewGroup.indexOfChild(this.gNh) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aE((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aE((FrameLayout) viewGroup);
            }
        }
    }

    private void aE(ViewGroup viewGroup) {
        if (this.gNh != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gNe, this.gNf);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.gNh, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.gNe, this.gNf);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.gNh, layoutParams2);
            }
            if (this.gNh instanceof SurfaceView) {
                ((SurfaceView) this.gNh).setZOrderOnTop(true);
                ((SurfaceView) this.gNh).getHolder().setFormat(-3);
            }
        }
    }

    public void bXJ() {
        aD(this.fZy);
    }

    public void bXK() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gNh != null && this.fZy != null && this.fZy.indexOfChild(this.gNh) > 0) {
            this.fZy.removeView(this.gNh);
        }
    }

    public boolean bXL() {
        return this.gNi;
    }

    public void mJ(boolean z) {
        this.gNi = z;
    }

    public void mD(boolean z) {
        this.gHX = z;
    }

    public void mK(boolean z) {
        if (this.gHX && z) {
            z = false;
        }
        if (z) {
            if (this.gNh != null) {
                this.gNh.setVisibility(0);
            }
        } else if (this.gNh != null) {
            this.gNh.setVisibility(8);
        }
    }

    public void C(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.gNh != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.gNj > 0 && optInt > this.gNj && bXL() && this.gNg != null) {
                        int i = optInt - this.gNj;
                        if (this.gNl > 0) {
                            if (i > this.gNl) {
                                addHeart(i - this.gNl);
                                this.gNl = 0;
                            } else {
                                this.gNl -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.gNj = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gNn);
        this.fZy = null;
        this.gNh = null;
        this.gNm = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ai(String str, String str2, String str3) {
        if (this.gNg != null) {
            if (bXL()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.gNk == 0) {
                this.mHandler.removeCallbacks(this.gNn);
                this.mHandler.postDelayed(this.gNn, 1000L);
            }
            this.gNk++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.gNg != null && this.gNh != null && this.gNh.getVisibility() == 0) {
            this.gNg.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.gNg != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.gNg.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
