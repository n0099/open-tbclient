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
    private static int fod = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
    private static final int foe = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
    IZanResponseCallback aHy;
    private com.baidu.live.liveroom.a.a eTy;
    private ViewGroup ewe;
    private IAlaBdZan fof;
    private View fog;
    private boolean foh;
    private int foi;
    private int foj;
    private int fok;
    private boolean fol;
    private Runnable fom;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.foh = true;
        this.mIsHost = false;
        this.foi = -1;
        this.foj = 0;
        this.fok = 0;
        this.fol = false;
        this.fom = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.u.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.foj > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.foj);
                    a.this.fok += a.this.foj;
                    a.this.foj = 0;
                }
            }
        };
        this.aHy = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.fol && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.ac(a.this.mLiveId, "zan_rmb");
                    a.this.fol = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eTy = aVar;
        fod = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.foi = -1;
            this.mIsHost = z;
            this.ewe = viewGroup;
            this.fof = BdZanViewCreater.getInst().create();
            if (this.fof != null) {
                this.fof.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.fog = view;
                            a.this.fog.setClickable(false);
                            a.this.ao(a.this.ewe);
                        }
                    }
                });
                this.fof.setZanResponseCallback(this.aHy);
                this.fof.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(ViewGroup viewGroup) {
        if (this.fog != null && viewGroup.indexOfChild(this.fog) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                ap((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                ap((FrameLayout) viewGroup);
            }
        }
    }

    private void ap(ViewGroup viewGroup) {
        if (this.fog != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fod, foe);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.fog, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(fod, foe);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.fog, layoutParams2);
            }
            if (this.fog instanceof SurfaceView) {
                ((SurfaceView) this.fog).setZOrderOnTop(true);
                ((SurfaceView) this.fog).getHolder().setFormat(-3);
            }
        }
    }

    public void brv() {
        ao(this.ewe);
    }

    public void brw() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fog != null && this.ewe != null && this.ewe.indexOfChild(this.fog) > 0) {
            this.ewe.removeView(this.fog);
        }
    }

    private boolean brx() {
        return this.foh;
    }

    public void jQ(boolean z) {
        this.foh = z;
    }

    public void jR(boolean z) {
        if (z) {
            if (this.fog != null) {
                this.fog.setVisibility(0);
            }
        } else if (this.fog != null) {
            this.fog.setVisibility(8);
        }
    }

    public void v(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.fog != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.foi > 0 && optInt > this.foi && brx() && this.fof != null) {
                        int i = optInt - this.foi;
                        if (this.fok > 0) {
                            if (i > this.fok) {
                                addHeart(i - this.fok);
                                this.fok = 0;
                            } else {
                                this.fok -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.foi = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fom);
        this.ewe = null;
        this.fog = null;
        this.fol = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ad(String str, String str2, String str3) {
        if (this.fof != null) {
            if (brx()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.foj == 0) {
                this.mHandler.removeCallbacks(this.fom);
                this.mHandler.postDelayed(this.fom, 1000L);
            }
            this.foj++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.fof != null && this.fog != null && this.fog.getVisibility() == 0) {
            this.fof.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.fof != null) {
            this.fof.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
