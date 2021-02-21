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
public class e {
    private MediaMetadataRetriever bem;
    private CustomMessageListener ifM;
    private PkRankKillAnimView igM;
    private boolean isShowing = false;
    private ViewGroup mParentView;

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coB();
    }

    public void PU() {
        reset();
        coz();
    }

    public void Fy() {
        coA();
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

    private void coz() {
        if (this.ifM == null) {
            this.ifM = new CustomMessageListener(2913291) { // from class: com.baidu.tieba.ala.h.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if ((customResponsedMessage.getData() instanceof String) && !e.this.isShowing) {
                        e.this.startAnim();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ifM);
    }

    private void coA() {
        if (this.ifM != null) {
            MessageManager.getInstance().unRegisterListener(this.ifM);
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
        coB();
        this.igM.setVisibility(0);
        String coE = g.coV().coE();
        if (TextUtils.isEmpty(coE)) {
            i = 0;
            i2 = 0;
        } else {
            if (this.bem == null) {
                this.bem = new MediaMetadataRetriever();
            }
            try {
                this.bem.setDataSource(coE);
                i3 = Integer.valueOf(this.bem.extractMetadata(18)).intValue();
                try {
                    i = Integer.valueOf(this.bem.extractMetadata(19)).intValue();
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    i = 0;
                    i2 = i3;
                    coE = null;
                    if (i2 > 0) {
                    }
                    coE = null;
                    int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                    this.igM.bX(realScreenWidth, TextUtils.isEmpty(coE) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.igM.bringToFront();
                    this.igM.Iv(coE);
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
        }
        if (i2 > 0 || i <= 0) {
            coE = null;
        }
        int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
        this.igM.bX(realScreenWidth2, TextUtils.isEmpty(coE) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.igM.bringToFront();
        this.igM.Iv(coE);
    }

    private void coB() {
        if (this.igM == null) {
            this.igM = new PkRankKillAnimView(getContext(), true);
        }
        if (bkq().indexOfChild(this.igM) < 0) {
            bkq().addView(this.igM, new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds216), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds304))));
        }
        this.igM.setVisibility(8);
        this.igM.setCallback(new PkRankKillAnimView.a() { // from class: com.baidu.tieba.ala.h.e.2
            @Override // com.baidu.tieba.ala.view.PkRankKillAnimView.a
            public void coC() {
                e.this.isShowing = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913294, ""));
                if (e.this.igM != null) {
                    e.this.igM.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.igM != null) {
            this.igM.stopAnim();
            this.igM.setVisibility(8);
        }
    }

    public void release() {
        Fy();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.igM != null) {
            this.igM.setCallback(null);
            this.igM.release();
        }
        if (this.igM != null && (this.igM.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.igM.getParent()).removeView(this.igM);
        }
        this.mParentView = null;
    }
}
