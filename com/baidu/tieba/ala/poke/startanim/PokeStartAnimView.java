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
/* loaded from: classes11.dex */
public class PokeStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bei;
    private FrameLayout igd;
    private ImageView ige;
    private Runnable igf;
    private a igg;

    /* loaded from: classes11.dex */
    public interface a {
        void coC();
    }

    public PokeStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.igg = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        coI();
        coJ();
    }

    public void Iv(String str) {
        if (this.bei != null && !TextUtils.isEmpty(str)) {
            this.ige.setVisibility(8);
            this.bei.getView().setVisibility(0);
            this.bei.play(str);
            return;
        }
        if (this.bei != null) {
            this.bei.getView().setVisibility(8);
        }
        this.ige.setVisibility(0);
        this.igf = new Runnable() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PokeStartAnimView.this.igg != null) {
                    PokeStartAnimView.this.igg.coC();
                }
            }
        };
        postDelayed(this.igf, IMConnection.RETRY_DELAY_TIMES);
    }

    public void stopAnim() {
        if (this.igf != null) {
            removeCallbacks(this.igf);
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

    private void bY(int i, int i2) {
        if (this.igd == null) {
            this.igd = new FrameLayout(getContext());
        }
        if (indexOfChild(this.igd) < 0) {
            addView(this.igd);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igd.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.igd.setLayoutParams(layoutParams);
    }

    private void coI() {
        if (this.bei == null || this.bei.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bei = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bei != null) {
            if (this.igd.indexOfChild(this.bei.getView()) < 0) {
                this.igd.addView(this.bei.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bei.a(new c.a() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PokeStartAnimView.this.igg != null) {
                        PokeStartAnimView.this.igg.coC();
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

    private void coJ() {
        if (this.ige == null) {
            this.ige = new ImageView(getContext());
            this.ige.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ige.setImageResource(a.e.ala_poke_gif_bg);
        }
        if (this.igd.indexOfChild(this.ige) < 0) {
            this.igd.addView(this.ige, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ige.setVisibility(8);
    }
}
