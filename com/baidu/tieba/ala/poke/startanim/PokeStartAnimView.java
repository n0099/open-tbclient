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
    private com.baidu.live.alphavideo.c bbc;
    private FrameLayout ibr;
    private ImageView ibs;
    private Runnable ibt;
    private a ibu;

    /* loaded from: classes10.dex */
    public interface a {
        void cnx();
    }

    public PokeStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.ibu = aVar;
    }

    public void bZ(int i, int i2) {
        ca(i, i2);
        cnD();
        cnE();
    }

    public void HQ(String str) {
        if (this.bbc != null && !TextUtils.isEmpty(str)) {
            this.ibs.setVisibility(8);
            this.bbc.getView().setVisibility(0);
            this.bbc.play(str);
            return;
        }
        if (this.bbc != null) {
            this.bbc.getView().setVisibility(8);
        }
        this.ibs.setVisibility(0);
        this.ibt = new Runnable() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PokeStartAnimView.this.ibu != null) {
                    PokeStartAnimView.this.ibu.cnx();
                }
            }
        };
        postDelayed(this.ibt, IMConnection.RETRY_DELAY_TIMES);
    }

    public void stopAnim() {
        if (this.ibt != null) {
            removeCallbacks(this.ibt);
        }
        if (this.bbc != null) {
            this.bbc.stop();
            this.bbc.reset();
        }
    }

    public void release() {
        stopAnim();
        if (this.bbc != null) {
            this.bbc.release();
        }
        removeAllViews();
    }

    private void ca(int i, int i2) {
        if (this.ibr == null) {
            this.ibr = new FrameLayout(getContext());
        }
        if (indexOfChild(this.ibr) < 0) {
            addView(this.ibr);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ibr.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.ibr.setLayoutParams(layoutParams);
    }

    private void cnD() {
        if (this.bbc == null || this.bbc.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bbc = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bbc != null) {
            if (this.ibr.indexOfChild(this.bbc.getView()) < 0) {
                this.ibr.addView(this.bbc.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bbc.a(new c.a() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PokeStartAnimView.this.ibu != null) {
                        PokeStartAnimView.this.ibu.cnx();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bbc.getView().setVisibility(8);
        }
    }

    private void cnE() {
        if (this.ibs == null) {
            this.ibs = new ImageView(getContext());
            this.ibs.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ibs.setImageResource(a.e.ala_poke_gif_bg);
        }
        if (this.ibr.indexOfChild(this.ibs) < 0) {
            this.ibr.addView(this.ibs, new ViewGroup.LayoutParams(-1, -1));
        }
        this.ibs.setVisibility(8);
    }
}
