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
/* loaded from: classes10.dex */
public class PkRankTaskBGStartAnimView extends FrameLayout {
    private com.baidu.live.alphavideo.c bfL;
    private FrameLayout ihM;
    private Runnable ihO;
    private a ipa;

    /* loaded from: classes10.dex */
    public interface a {
        void coI();
    }

    public PkRankTaskBGStartAnimView(Context context) {
        super(context);
    }

    public void setCallback(a aVar) {
        this.ipa = aVar;
    }

    public void bX(int i, int i2) {
        bY(i, i2);
        coO();
    }

    public boolean IO(String str) {
        if (this.bfL != null && !TextUtils.isEmpty(str)) {
            this.bfL.getView().setVisibility(0);
            this.bfL.setLooping(true);
            this.bfL.play(str);
            return true;
        }
        if (this.bfL != null) {
            this.bfL.getView().setVisibility(8);
        }
        this.ihO = new Runnable() { // from class: com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                if (PkRankTaskBGStartAnimView.this.ipa != null) {
                    PkRankTaskBGStartAnimView.this.ipa.coI();
                }
            }
        };
        postDelayed(this.ihO, IMConnection.RETRY_DELAY_TIMES);
        return false;
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
                this.ihM.addView(this.bfL.getView(), new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds220), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds88)));
            }
            this.bfL.a(new c.a() { // from class: com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView.2
                @Override // com.baidu.live.alphavideo.c.a
                public void onStart() {
                }

                @Override // com.baidu.live.alphavideo.c.a
                public void onEnd() {
                    if (PkRankTaskBGStartAnimView.this.ipa != null) {
                        PkRankTaskBGStartAnimView.this.ipa.coI();
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
}
