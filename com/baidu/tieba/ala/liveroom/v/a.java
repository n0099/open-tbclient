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
    private com.baidu.live.liveroom.a.a fMJ;
    private ViewGroup fox;
    private boolean gcP;
    private int gij;
    private final int gik;
    private IAlaBdZan gil;
    private View gim;
    private boolean gin;
    private int gio;
    private int gip;
    private int giq;
    private boolean gir;
    private Runnable gis;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.gij = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
        this.gik = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
        this.mHandler = new Handler();
        this.gin = true;
        this.mIsHost = false;
        this.gio = -1;
        this.gip = 0;
        this.giq = 0;
        this.gir = false;
        this.gis = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.gip > 0) {
                    a.this.o(a.this.mRoomId, a.this.mCastId, a.this.gip);
                    a.this.giq += a.this.gip;
                    a.this.gip = 0;
                }
            }
        };
        this.bli = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.gir && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.au(a.this.mLiveId, "zan_rmb");
                    a.this.gir = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.fMJ = aVar;
        this.gij = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.gio = -1;
            this.mIsHost = z;
            this.fox = viewGroup;
            this.gil = BdZanViewCreater.getInst().create();
            if (this.gil != null) {
                this.gil.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.v.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.gim = view;
                            a.this.gim.setClickable(false);
                            a.this.az(a.this.fox);
                        }
                    }
                });
                this.gil.setZanResponseCallback(this.bli);
                this.gil.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(ViewGroup viewGroup) {
        if (this.gim != null && viewGroup.indexOfChild(this.gim) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                aA((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                aA((FrameLayout) viewGroup);
            }
        }
    }

    private void aA(ViewGroup viewGroup) {
        if (this.gim != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.gij, this.gik);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.gim, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.gij, this.gik);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.gim, layoutParams2);
            }
            if (this.gim instanceof SurfaceView) {
                ((SurfaceView) this.gim).setZOrderOnTop(true);
                ((SurfaceView) this.gim).getHolder().setFormat(-3);
            }
        }
    }

    public void bHw() {
        az(this.fox);
    }

    public void bHx() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gim != null && this.fox != null && this.fox.indexOfChild(this.gim) > 0) {
            this.fox.removeView(this.gim);
        }
    }

    private boolean bHy() {
        return this.gin;
    }

    public void lt(boolean z) {
        this.gin = z;
    }

    public void lm(boolean z) {
        this.gcP = z;
    }

    public void lu(boolean z) {
        if (this.gcP && z) {
            z = false;
        }
        if (z) {
            if (this.gim != null) {
                this.gim.setVisibility(0);
            }
        } else if (this.gim != null) {
            this.gim.setVisibility(8);
        }
    }

    public void z(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.gim != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.gio > 0 && optInt > this.gio && bHy() && this.gil != null) {
                        int i = optInt - this.gio;
                        if (this.giq > 0) {
                            if (i > this.giq) {
                                addHeart(i - this.giq);
                                this.giq = 0;
                            } else {
                                this.giq -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.gio = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.gis);
        this.fox = null;
        this.gim = null;
        this.gir = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ag(String str, String str2, String str3) {
        if (this.gil != null) {
            if (bHy()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.gip == 0) {
                this.mHandler.removeCallbacks(this.gis);
                this.mHandler.postDelayed(this.gis, 1000L);
            }
            this.gip++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.gil != null && this.gim != null && this.gim.getVisibility() == 0) {
            this.gil.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, int i) {
        if (this.gil != null && this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.gil.postZan(this.mTbPageContext.getPageActivity(), str, str2, i);
        }
    }
}
