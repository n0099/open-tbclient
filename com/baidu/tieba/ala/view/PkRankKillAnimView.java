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
/* loaded from: classes11.dex */
public class PkRankKillAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bei;
    private FrameLayout ifP;
    private ImageView ifQ;
    private Runnable ifR;
    private a ilV;
    private boolean ilW;

    /* loaded from: classes11.dex */
    public interface a {
        void cov();
    }

    public PkRankKillAnimView(Context context, boolean z) {
        super(context);
        this.ilW = z;
    }

    public void setCallback(a aVar) {
        this.ilV = aVar;
    }

    public void bW(int i, int i2) {
        bX(i, i2);
        coB();
        coC();
    }

    public void Iu(String str) {
        if (this.bei != null && !TextUtils.isEmpty(str)) {
            this.ifQ.setVisibility(8);
            this.bei.getView().setVisibility(0);
            this.bei.play(str);
            return;
        }
        if (this.bei != null) {
            this.bei.getView().setVisibility(8);
        }
        this.ifQ.setVisibility(0);
        this.ifR = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankKillAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PkRankKillAnimView.this.ilV != null) {
                    PkRankKillAnimView.this.ilV.cov();
                }
            }
        };
        postDelayed(this.ifR, IMConnection.RETRY_DELAY_TIMES);
    }

    public void stopAnim() {
        if (this.ifR != null) {
            removeCallbacks(this.ifR);
        }
        if (this.bei != null) {
            this.bei.stop();
            this.bei.reset();
        }
    }

    public void release() {
        stopAnim();
        if (this.bei != null) {
            this.bei.release();
        }
        removeAllViews();
    }

    private void bX(int i, int i2) {
        if (this.ifP == null) {
            this.ifP = new FrameLayout(getContext());
        }
        if (indexOfChild(this.ifP) < 0) {
            addView(this.ifP);
        }
    }

    private void coB() {
        if (this.bei == null || this.bei.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bei = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bei != null) {
            if (this.ifP.indexOfChild(this.bei.getView()) < 0) {
                this.ifP.addView(this.bei.getView(), new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds216), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds304))));
            }
            this.bei.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankKillAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankKillAnimView.this.ilV != null) {
                        PkRankKillAnimView.this.ilV.cov();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bei.getView().setVisibility(8);
        }
    }

    private void coC() {
        if (this.ifQ == null) {
            this.ifQ = new ImageView(getContext());
            this.ifQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
            if (this.ilW) {
                this.ifQ.setImageResource(a.e.sdk_kill_success);
            } else {
                this.ifQ.setImageResource(a.e.sdk_anti_kill_success);
            }
        }
        if (this.ifP.indexOfChild(this.ifQ) < 0) {
            this.ifP.addView(this.ifQ, new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds216), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds304)));
        }
        this.ifQ.setVisibility(8);
    }
}
