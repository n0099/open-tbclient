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
    private static int foc = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);
    private static final int fod = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
    IZanResponseCallback aHx;
    private com.baidu.live.liveroom.a.a eTx;
    private ViewGroup ewd;
    private IAlaBdZan foe;
    private View fof;
    private boolean fog;
    private int foh;
    private int foi;
    private int foj;
    private boolean fok;
    private Runnable fol;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.fog = true;
        this.mIsHost = false;
        this.foh = -1;
        this.foi = 0;
        this.foj = 0;
        this.fok = false;
        this.fol = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.u.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.foi > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.foi);
                    a.this.foj += a.this.foi;
                    a.this.foi = 0;
                }
            }
        };
        this.aHx = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.fok && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.ac(a.this.mLiveId, "zan_rmb");
                    a.this.fok = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eTx = aVar;
        foc = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.foh = -1;
            this.mIsHost = z;
            this.ewd = viewGroup;
            this.foe = BdZanViewCreater.getInst().create();
            if (this.foe != null) {
                this.foe.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.fof = view;
                            a.this.fof.setClickable(false);
                            a.this.ao(a.this.ewd);
                        }
                    }
                });
                this.foe.setZanResponseCallback(this.aHx);
                this.foe.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(ViewGroup viewGroup) {
        if (this.fof != null && viewGroup.indexOfChild(this.fof) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                ap((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                ap((FrameLayout) viewGroup);
            }
        }
    }

    private void ap(ViewGroup viewGroup) {
        if (this.fof != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(foc, fod);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.fof, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(foc, fod);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.fof, layoutParams2);
            }
            if (this.fof instanceof SurfaceView) {
                ((SurfaceView) this.fof).setZOrderOnTop(true);
                ((SurfaceView) this.fof).getHolder().setFormat(-3);
            }
        }
    }

    public void brt() {
        ao(this.ewd);
    }

    public void bru() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fof != null && this.ewd != null && this.ewd.indexOfChild(this.fof) > 0) {
            this.ewd.removeView(this.fof);
        }
    }

    private boolean brv() {
        return this.fog;
    }

    public void jQ(boolean z) {
        this.fog = z;
    }

    public void jR(boolean z) {
        if (z) {
            if (this.fof != null) {
                this.fof.setVisibility(0);
            }
        } else if (this.fof != null) {
            this.fof.setVisibility(8);
        }
    }

    public void v(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.fof != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.foh > 0 && optInt > this.foh && brv() && this.foe != null) {
                        int i = optInt - this.foh;
                        if (this.foj > 0) {
                            if (i > this.foj) {
                                addHeart(i - this.foj);
                                this.foj = 0;
                            } else {
                                this.foj -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.foh = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.fol);
        this.ewd = null;
        this.fof = null;
        this.fok = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ad(String str, String str2, String str3) {
        if (this.foe != null) {
            if (brv()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.foi == 0) {
                this.mHandler.removeCallbacks(this.fol);
                this.mHandler.postDelayed(this.fol, 1000L);
            }
            this.foi++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.foe != null && this.fof != null && this.fof.getVisibility() == 0) {
            this.foe.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.foe != null) {
            this.foe.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
