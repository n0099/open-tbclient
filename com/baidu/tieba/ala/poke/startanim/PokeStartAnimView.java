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
    private com.baidu.live.alphavideo.c bfS;
    private FrameLayout igc;
    private ImageView igd;
    private Runnable ige;
    private a igf;

    /* loaded from: classes11.dex */
    public interface a {
        void cro();
    }

    public PokeStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.igf = aVar;
    }

    public void bZ(int i, int i2) {
        ca(i, i2);
        cru();
        crv();
    }

    public void Jc(String str) {
        if (this.bfS != null && !TextUtils.isEmpty(str)) {
            this.igd.setVisibility(8);
            this.bfS.getView().setVisibility(0);
            this.bfS.play(str);
            return;
        }
        if (this.bfS != null) {
            this.bfS.getView().setVisibility(8);
        }
        this.igd.setVisibility(0);
        this.ige = new Runnable() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PokeStartAnimView.this.igf != null) {
                    PokeStartAnimView.this.igf.cro();
                }
            }
        };
        postDelayed(this.ige, IMConnection.RETRY_DELAY_TIMES);
    }

    public void stopAnim() {
        if (this.ige != null) {
            removeCallbacks(this.ige);
        }
        if (this.bfS != null) {
            this.bfS.stop();
            this.bfS.reset();
        }
    }

    public void release() {
        stopAnim();
        if (this.bfS != null) {
            this.bfS.release();
        }
        removeAllViews();
    }

    private void ca(int i, int i2) {
        if (this.igc == null) {
            this.igc = new FrameLayout(getContext());
        }
        if (indexOfChild(this.igc) < 0) {
            addView(this.igc);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igc.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 16;
        this.igc.setLayoutParams(layoutParams);
    }

    private void cru() {
        if (this.bfS == null || this.bfS.isDestroyed()) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913181, com.baidu.live.alphavideo.c.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                this.bfS = (com.baidu.live.alphavideo.c) runTask.getData();
            } else {
                return;
            }
        }
        if (this.bfS != null) {
            if (this.igc.indexOfChild(this.bfS.getView()) < 0) {
                this.igc.addView(this.bfS.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.bfS.a(new c.a() { // from class: com.baidu.tieba.ala.poke.startanim.PokeStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PokeStartAnimView.this.igf != null) {
                        PokeStartAnimView.this.igf.cro();
                    }
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onError(int i, String str) {
                    onEnd();
                }
            });
            this.bfS.getView().setVisibility(8);
        }
    }

    private void crv() {
        if (this.igd == null) {
            this.igd = new ImageView(getContext());
            this.igd.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.igd.setImageResource(a.e.ala_poke_gif_bg);
        }
        if (this.igc.indexOfChild(this.igd) < 0) {
            this.igc.addView(this.igd, new ViewGroup.LayoutParams(-1, -1));
        }
        this.igd.setVisibility(8);
    }
}
