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
    IZanResponseCallback bli;
    private com.baidu.live.liveroom.a.a fMU;
    private ViewGroup foI;
    private boolean gda;
    private int giA;
    private int giB;
    private boolean giC;
    private Runnable giD;
    private int giu;
    private final int giv;
    private IAlaBdZan giw;
    private View gix;
    private boolean giy;
    private int giz;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.giu = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.giv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.giy = true;
        this.mIsHost = false;
        this.giz = -1;
        this.giA = 0;
        this.giB = 0;
        this.giC = false;
        this.giD = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.giA > 0) {
                    a.this.o(a.this.mRoomId, a.this.mCastId, a.this.giA);
                    a.this.giB += a.this.giA;
                    a.this.giA = 0;
                }
            }
        };
        this.bli = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.giC && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.au(a.this.mLiveId, "zan_rmb");
                    a.this.giC = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fMU = aVar;
        this.giu = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.giz = -1;
            this.mIsHost = z;
            this.foI = viewGroup;
            this.giw = BdZanViewCreater.getInst().create();
            if (this.giw != null) {
                this.giw.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.gix = view;
                            a.this.gix.setClickable(false);
                            a.this.az(a.this.foI);
                        }
                    }
                });
                this.giw.setZanResponseCallback(this.bli);
                this.giw.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(ViewGroup viewGroup) {
        if (this.gix != null && viewGroup.indexOfChild(this.gix) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aA((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aA((FrameLayout) viewGroup);
            }
        }
    }

    private void aA(ViewGroup viewGroup) {
        if (this.gix != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.giu, this.giv);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.gix, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.giu, this.giv);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.gix, layoutParams2);
            }
            if (this.gix instanceof SurfaceView) {
                ((SurfaceView) this.gix).setZOrderOnTop(true);
                ((SurfaceView) this.gix).getHolder().setFormat(-3);
            }
        }
    }

    public void bHy() {
        az(this.foI);
    }

    public void bHz() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gix != null && this.foI != null && this.foI.indexOfChild(this.gix) > 0) {
            this.foI.removeView(this.gix);
        }
    }

    private boolean bHA() {
        return this.giy;
    }

    public void lt(boolean z) {
        this.giy = z;
    }

    public void lm(boolean z) {
        this.gda = z;
    }

    public void lu(boolean z) {
        if (this.gda && z) {
            z = false;
        }
        if (z) {
            if (this.gix != null) {
                this.gix.setVisibility(0);
            }
        } else if (this.gix != null) {
            this.gix.setVisibility(8);
        }
    }

    public void z(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.gix != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.giz > 0 && optInt > this.giz && bHA() && this.giw != null) {
                        int i = optInt - this.giz;
                        if (this.giB > 0) {
                            if (i > this.giB) {
                                addHeart(i - this.giB);
                                this.giB = 0;
                            } else {
                                this.giB -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.giz = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.giD);
        this.foI = null;
        this.gix = null;
        this.giC = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ag(String str, String str2, String str3) {
        if (this.giw != null) {
            if (bHA()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.giA == 0) {
                this.mHandler.removeCallbacks(this.giD);
                this.mHandler.postDelayed(this.giD, 1000L);
            }
            this.giA++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.giw != null && this.gix != null && this.gix.getVisibility() == 0) {
            this.giw.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, int i) {
        if (this.giw != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.giw.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
