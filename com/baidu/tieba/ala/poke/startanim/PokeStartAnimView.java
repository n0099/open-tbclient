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
    private FrameLayout hTC;
    private ImageView hTD;
    private Runnable hTE;
    private a hTF;

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimEnd();
    }

    public PokeStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.hTF = aVar;
    }

    public void ca(int i, int i2) {
        cb(i, i2);
        coB();
        coC();
    }

    public void Je(String str) {
        if (this.bef != null && !TextUtils.isEmpty(str)) {
            this.hTD.setVisibility(8);
            this.bef.getView().setVisibility(0);
            this.bef.play(str);
            return;
        }
        if (this.bef != null) {
            this.bef.getView().setVisibility(8);
        }
        this.hTD.setVisibility(0);
        this.hTE = new Runnable() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PokeStartAnimView.this.hTF != null) {
                    PokeStartAnimView.this.hTF.onAnimEnd();
                }
            }
        };
        postDelayed(this.hTE, IMConnection.RETRY_DELAY_TIMES);
    }

    public void stopAnim() {
        if (this.hTE != null) {
            removeCallbacks(this.hTE);
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
        if (this.hTC == null) {
            this.hTC = new FrameLayout(getContext());
        }
        if (indexOfChild(this.hTC) < 0) {
            addView(this.hTC);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hTC.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.hTC.setLayoutParams(layoutParams);
    }

    private void coB() {
        if (this.bef == null || this.bef.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bef = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bef != null) {
            if (this.hTC.indexOfChild(this.bef.getView()) < 0) {
                this.hTC.addView(this.bef.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bef.a(new c.a() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PokeStartAnimView.this.hTF != null) {
                        PokeStartAnimView.this.hTF.onAnimEnd();
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

    private void coC() {
        if (this.hTD == null) {
            this.hTD = new ImageView(getContext());
            this.hTD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hTD.setImageResource(a.e.ala_poke_gif_bg);
        }
        if (this.hTC.indexOfChild(this.hTD) < 0) {
            this.hTC.addView(this.hTD, new ViewGroup.LayoutParams(-1, -1));
        }
        this.hTD.setVisibility(8);
    }
}
