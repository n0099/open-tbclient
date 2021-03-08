package com.baidu.tieba.ala.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.alphavideo.c;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class PkRankKillAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bfL;
    private FrameLayout ihM;
    private ImageView ihN;
    private Runnable ihO;
    private a inU;
    private boolean inV;

    /* loaded from: classes10.dex */
    public interface a {
        void coI();
    }

    public PkRankKillAnimView(Context context, boolean z) {
        super(context);
        this.inV = z;
    }

    public void setCallback(a aVar) {
        this.inU = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        coO();
        coP();
    }

    public void IE(String str) {
        if (this.bfL != null && !TextUtils.isEmpty(str)) {
            this.ihN.setVisibility(8);
            this.bfL.getView().setVisibility(0);
            this.bfL.play(str);
            return;
        }
        if (this.bfL != null) {
            this.bfL.getView().setVisibility(8);
        }
        this.ihN.setVisibility(0);
        this.ihO = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankKillAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PkRankKillAnimView.this.inU != null) {
                    PkRankKillAnimView.this.inU.coI();
                }
            }
        };
        postDelayed(this.ihO, IMConnection.RETRY_DELAY_TIMES);
    }

    public void stopAnim() {
        if (this.ihO != null) {
            removeCallbacks(this.ihO);
        }
        if (this.bfL != null) {
            this.bfL.stop();
            this.bfL.reset();
        }
    }

    public void release() {
        stopAnim();
        if (this.bfL != null) {
            this.bfL.release();
        }
        removeAllViews();
    }

    private void bY(int i, int i2) {
        if (this.ihM == null) {
            this.ihM = new FrameLayout(getContext());
        }
        if (indexOfChild(this.ihM) < 0) {
            addView(this.ihM);
        }
    }

    private void coO() {
        if (this.bfL == null || this.bfL.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfL = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bfL != null) {
            if (this.ihM.indexOfChild(this.bfL.getView()) < 0) {
                this.ihM.addView(this.bfL.getView(), new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds216), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds304))));
            }
            this.bfL.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankKillAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankKillAnimView.this.inU != null) {
                        PkRankKillAnimView.this.inU.coI();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bfL.getView().setVisibility(8);
        }
    }

    private void coP() {
        if (this.ihN == null) {
            this.ihN = new ImageView(getContext());
            this.ihN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (this.inV) {
                this.ihN.setImageResource(a.e.sdk_kill_success);
            } else {
                this.ihN.setImageResource(a.e.sdk_anti_kill_success);
            }
        }
        if (this.ihM.indexOfChild(this.ihN) < 0) {
            this.ihM.addView(this.ihN, new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds216), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds304)));
        }
        this.ihN.setVisibility(8);
    }
}
