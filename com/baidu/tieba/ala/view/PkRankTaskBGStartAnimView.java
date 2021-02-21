package com.baidu.tieba.ala.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.alphavideo.c;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class PkRankTaskBGStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bei;
    private FrameLayout igd;
    private Runnable igf;
    private a inq;

    /* loaded from: classes11.dex */
    public interface a {
        void coC();
    }

    public PkRankTaskBGStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.inq = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        coI();
    }

    public boolean IF(String str) {
        if (this.bei != null && !TextUtils.isEmpty(str)) {
            this.bei.getView().setVisibility(0);
            this.bei.setLooping(true);
            this.bei.play(str);
            return true;
        }
        if (this.bei != null) {
            this.bei.getView().setVisibility(8);
        }
        this.igf = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PkRankTaskBGStartAnimView.this.inq != null) {
                    PkRankTaskBGStartAnimView.this.inq.coC();
                }
            }
        };
        postDelayed(this.igf, IMConnection.RETRY_DELAY_TIMES);
        return false;
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
                this.igd.addView(this.bei.getView(), new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds220), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds88)));
            }
            this.bei.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankTaskBGStartAnimView.this.inq != null) {
                        PkRankTaskBGStartAnimView.this.inq.coC();
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
}
