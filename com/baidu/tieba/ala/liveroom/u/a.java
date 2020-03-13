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
    private static int foq = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds240);

    /* renamed from: for  reason: not valid java name */
    private static final int f2for = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds420);
    IZanResponseCallback aHz;
    private com.baidu.live.liveroom.a.a eTL;
    private ViewGroup ewr;
    private IAlaBdZan fos;
    private View fot;
    private boolean fou;
    private int fov;
    private int fow;
    private int fox;
    private boolean foy;
    private Runnable foz;
    private String mCastId;
    protected Handler mHandler;
    private boolean mIsHost;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, com.baidu.live.liveroom.a.a aVar) {
        super(tbPageContext);
        this.mHandler = new Handler();
        this.fou = true;
        this.mIsHost = false;
        this.fov = -1;
        this.fow = 0;
        this.fox = 0;
        this.foy = false;
        this.foz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.u.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.fow > 0) {
                    a.this.p(a.this.mRoomId, a.this.mCastId, a.this.fow);
                    a.this.fox += a.this.fow;
                    a.this.fow = 0;
                }
            }
        };
        this.aHz = new IZanResponseCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.3
            @Override // com.baidu.live.tbadk.ala.zan.IZanResponseCallback
            public void onResult(int i, long j, long j2) {
                Log.i("IZanResponseCallback", "@@ responseListener i =" + i + ", l=" + j + ", l1=" + j2);
                if (!a.this.mIsHost && !a.this.foy && i >= 0 && TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(a.this.mLiveId)) {
                    com.baidu.live.l.a.ac(a.this.mLiveId, "zan_rmb");
                    a.this.foy = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.eTL = aVar;
        foq = (TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds60) / 2) + TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds42) + BdUtilHelper.dip2px(tbPageContext.getPageActivity(), 90.0f);
    }

    public void d(ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            this.fov = -1;
            this.mIsHost = z;
            this.ewr = viewGroup;
            this.fos = BdZanViewCreater.getInst().create();
            if (this.fos != null) {
                this.fos.setGetZanViewCallback(new IGetZanViewCallback() { // from class: com.baidu.tieba.ala.liveroom.u.a.1
                    @Override // com.baidu.live.tbadk.ala.zan.IGetZanViewCallback
                    public void onGetZanView(View view) {
                        if (view != null) {
                            a.this.fot = view;
                            a.this.fot.setClickable(false);
                            a.this.ao(a.this.ewr);
                        }
                    }
                });
                this.fos.setZanResponseCallback(this.aHz);
                this.fos.prepareZanView(this.mTbPageContext.getPageActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(ViewGroup viewGroup) {
        if (this.fot != null && viewGroup.indexOfChild(this.fot) < 0) {
            if (viewGroup instanceof RelativeLayout) {
                ap((RelativeLayout) viewGroup);
            } else if (viewGroup instanceof FrameLayout) {
                ap((FrameLayout) viewGroup);
            }
        }
    }

    private void ap(ViewGroup viewGroup) {
        if (this.fot != null && viewGroup != null) {
            if (viewGroup instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(foq, f2for);
                layoutParams.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds104);
                layoutParams.gravity = 85;
                viewGroup.addView(this.fot, layoutParams);
            } else if (viewGroup instanceof RelativeLayout) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(foq, f2for);
                layoutParams2.bottomMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds80);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                viewGroup.addView(this.fot, layoutParams2);
            }
            if (this.fot instanceof SurfaceView) {
                ((SurfaceView) this.fot).setZOrderOnTop(true);
                ((SurfaceView) this.fot).getHolder().setFormat(-3);
            }
        }
    }

    public void brw() {
        ao(this.ewr);
    }

    public void brx() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fot != null && this.ewr != null && this.ewr.indexOfChild(this.fot) > 0) {
            this.ewr.removeView(this.fot);
        }
    }

    private boolean bry() {
        return this.fou;
    }

    public void jQ(boolean z) {
        this.fou = z;
    }

    public void jR(boolean z) {
        if (z) {
            if (this.fot != null) {
                this.fot.setVisibility(0);
            }
        } else if (this.fot != null) {
            this.fot.setVisibility(8);
        }
    }

    public void v(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (this.fot != null) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                int optInt = jSONObject.optInt("zan_count", 0);
                if (optInt > 0) {
                    if (this.fov > 0 && optInt > this.fov && bry() && this.fos != null) {
                        int i = optInt - this.fov;
                        if (this.fox > 0) {
                            if (i > this.fox) {
                                addHeart(i - this.fox);
                                this.fox = 0;
                            } else {
                                this.fox -= i;
                            }
                        } else {
                            addHeart(i);
                        }
                    }
                    this.fov = optInt;
                }
            } catch (JSONException e) {
            }
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.foz);
        this.ewr = null;
        this.fot = null;
        this.foy = false;
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
    }

    public void ad(String str, String str2, String str3) {
        if (this.fos != null) {
            if (bry()) {
                addHeart(1);
            }
            this.mLiveId = str;
            this.mRoomId = str2;
            this.mCastId = str3;
            if (this.fow == 0) {
                this.mHandler.removeCallbacks(this.foz);
                this.mHandler.postDelayed(this.foz, 1000L);
            }
            this.fow++;
        }
    }

    private void addHeart(int i) {
        if (i > 0 && this.fos != null && this.fot != null && this.fot.getVisibility() == 0) {
            this.fos.addHeart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, int i) {
        if (this.fos != null) {
            this.fos.postZan(this.mTbPageContext.getContext(), str, str2, i);
        }
    }
}
