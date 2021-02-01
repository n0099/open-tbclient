package com.baidu.tieba.ala.h;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.view.PkRankKillAnimView;
/* loaded from: classes11.dex */
public class a {
    private MediaMetadataRetriever bem;
    private CustomMessageListener ify;
    private PkRankKillAnimView igy;
    private boolean isShowing = false;
    private ViewGroup mParentView;

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cou();
    }

    public void PU() {
        reset();
        cos();
    }

    public void Fy() {
        cot();
        reset();
    }

    private Context getContext() {
        if (bkq() != null) {
            return bkq().getContext();
        }
        return null;
    }

    private ViewGroup bkq() {
        return this.mParentView;
    }

    private void cos() {
        if (this.ify == null) {
            this.ify = new CustomMessageListener(2913295) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if ((customResponsedMessage.getData() instanceof String) && !a.this.isShowing) {
                        a.this.startAnim();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ify);
    }

    private void cot() {
        if (this.ify != null) {
            MessageManager.getInstance().unRegisterListener(this.ify);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startAnim() {
        int i;
        int i2;
        int i3;
        this.isShowing = true;
        cou();
        this.igy.setVisibility(0);
        String cox = b.coM().cox();
        if (TextUtils.isEmpty(cox)) {
            i = 0;
            i2 = 0;
        } else {
            if (this.bem == null) {
                this.bem = new MediaMetadataRetriever();
            }
            try {
                this.bem.setDataSource(cox);
                i3 = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
                try {
                    i = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    i = 0;
                    i2 = i3;
                    cox = null;
                    if (i2 > 0) {
                    }
                    cox = null;
                    int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                    this.igy.bW(realScreenWidth, TextUtils.isEmpty(cox) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.igy.bringToFront();
                    this.igy.Iu(cox);
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
        }
        if (i2 > 0 || i <= 0) {
            cox = null;
        }
        int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
        this.igy.bW(realScreenWidth2, TextUtils.isEmpty(cox) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.igy.bringToFront();
        this.igy.Iu(cox);
    }

    private void cou() {
        if (this.igy == null) {
            this.igy = new PkRankKillAnimView(getContext(), false);
        }
        if (bkq().indexOfChild(this.igy) < 0) {
            bkq().addView(this.igy, new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds216), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds304))));
        }
        this.igy.setVisibility(8);
        this.igy.setCallback(new PkRankKillAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankKillAnimView.a
            public void cov() {
                a.this.isShowing = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913294, ""));
                if (a.this.igy != null) {
                    a.this.igy.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.igy != null) {
            this.igy.stopAnim();
            this.igy.setVisibility(8);
        }
    }

    public void release() {
        Fy();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.igy != null) {
            this.igy.setCallback(null);
            this.igy.release();
        }
        if (this.igy != null && (this.igy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.igy.getParent()).removeView(this.igy);
        }
        this.mParentView = null;
    }
}
