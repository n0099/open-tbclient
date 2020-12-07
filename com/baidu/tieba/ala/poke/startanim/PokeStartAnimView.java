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
/* loaded from: classes4.dex */
public class PokeStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bef;
    private FrameLayout hTA;
    private ImageView hTB;
    private Runnable hTC;
    private a hTD;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PokeStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.hTD = aVar;
    }

    public void ca(int i, int i2) {
        cb(i, i2);
        coA();
        coB();
    }

    public void Je(String str) {
        if (this.bef != null && !TextUtils.isEmpty(str)) {
            this.hTB.setVisibility(8);
            this.bef.getView().setVisibility(0);
            this.bef.play(str);
            return;
        }
        if (this.bef != null) {
            this.bef.getView().setVisibility(8);
        }
        this.hTB.setVisibility(0);
        this.hTC = new Runnable() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PokeStartAnimView.this.hTD != null) {
                    PokeStartAnimView.this.hTD.onAnimEnd();
                }
            }
        };
        postDelayed(this.hTC, IMConnection.RETRY_DELAY_TIMES);
    }

    public void stopAnim() {
        if (this.hTC != null) {
            removeCallbacks(this.hTC);
        }
        if (this.bef != null) {
            this.bef.stop();
            this.bef.reset();
        }
    }

    public void release() {
        stopAnim();
        if (this.bef != null) {
            this.bef.release();
        }
        removeAllViews();
    }

    private void cb(int i, int i2) {
        if (this.hTA == null) {
            this.hTA = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hTA) < 0) {
            addView(this.hTA);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hTA.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hTA.setLayoutParams(layoutParams);
    }

    private void coA() {
        if (this.bef == null || this.bef.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bef = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bef != null) {
            if (this.hTA.indexOfChild(this.bef.getView()) < 0) {
                this.hTA.addView(this.bef.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bef.a(new c.a() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PokeStartAnimView.this.hTD != null) {
                        PokeStartAnimView.this.hTD.onAnimEnd();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bef.getView().setVisibility(8);
        }
    }

    private void coB() {
        if (this.hTB == null) {
            this.hTB = new ImageView(getContext());
            this.hTB.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hTB.setImageResource(a.e.ala_poke_gif_bg);
        }
        if (this.hTA.indexOfChild(this.hTB) < 0) {
            this.hTA.addView(this.hTB, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hTB.setVisibility(8);
    }
}
