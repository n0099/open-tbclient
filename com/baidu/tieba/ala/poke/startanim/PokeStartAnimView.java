package com.baidu.tieba.ala.poke.startanim;

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
public class PokeStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bfL;
    private FrameLayout ihM;
    private ImageView ihN;
    private Runnable ihO;
    private a ihP;

    /* loaded from: classes10.dex */
    public interface a {
        void coI();
    }

    public PokeStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.ihP = aVar;
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
        this.ihO = new Runnable() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PokeStartAnimView.this.ihP != null) {
                    PokeStartAnimView.this.ihP.coI();
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
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ihM.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.ihM.setLayoutParams(layoutParams);
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
                this.ihM.addView(this.bfL.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bfL.a(new c.a() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PokeStartAnimView.this.ihP != null) {
                        PokeStartAnimView.this.ihP.coI();
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
            this.ihN.setImageResource(a.e.ala_poke_gif_bg);
        }
        if (this.ihM.indexOfChild(this.ihN) < 0) {
            this.ihM.addView(this.ihN, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ihN.setVisibility(8);
    }
}
