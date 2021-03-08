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
/* loaded from: classes10.dex */
public class a {
    private MediaMetadataRetriever bfP;
    private CustomMessageListener ihv;
    private PkRankKillAnimView iiv;
    private boolean isShowing = false;
    private ViewGroup mParentView;

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coH();
    }

    public void PX() {
        reset();
        coF();
    }

    public void FB() {
        coG();
        reset();
    }

    private Context getContext() {
        if (bks() != null) {
            return bks().getContext();
        }
        return null;
    }

    private ViewGroup bks() {
        return this.mParentView;
    }

    private void coF() {
        if (this.ihv == null) {
            this.ihv = new CustomMessageListener(2913295) { // from class: com.baidu.tieba.ala.h.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if ((customResponsedMessage.getData() instanceof String) && !a.this.isShowing) {
                        a.this.startAnim();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ihv);
    }

    private void coG() {
        if (this.ihv != null) {
            MessageManager.getInstance().unRegisterListener(this.ihv);
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
        coH();
        this.iiv.setVisibility(0);
        String coK = b.coZ().coK();
        if (TextUtils.isEmpty(coK)) {
            i = 0;
            i2 = 0;
        } else {
            if (this.bfP == null) {
                this.bfP = new MediaMetadataRetriever();
            }
            try {
                this.bfP.setDataSource(coK);
                i3 = Integer.valueOf(this.bfP.extractMetadata(18)).intValue();
                try {
                    i = Integer.valueOf(this.bfP.extractMetadata(19)).intValue();
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    i = 0;
                    i2 = i3;
                    coK = null;
                    if (i2 > 0) {
                    }
                    coK = null;
                    int realScreenWidth = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
                    this.iiv.bX(realScreenWidth, TextUtils.isEmpty(coK) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    this.iiv.bringToFront();
                    this.iiv.IE(coK);
                }
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
        }
        if (i2 > 0 || i <= 0) {
            coK = null;
        }
        int realScreenWidth2 = ScreenHelper.getRealScreenWidth(getContext().getApplicationContext());
        this.iiv.bX(realScreenWidth2, TextUtils.isEmpty(coK) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        this.iiv.bringToFront();
        this.iiv.IE(coK);
    }

    private void coH() {
        if (this.iiv == null) {
            this.iiv = new PkRankKillAnimView(getContext(), false);
        }
        if (bks().indexOfChild(this.iiv) < 0) {
            bks().addView(this.iiv, new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds216), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds304))));
        }
        this.iiv.setVisibility(8);
        this.iiv.setCallback(new PkRankKillAnimView.a() { // from class: com.baidu.tieba.ala.h.a.2
            @Override // com.baidu.tieba.ala.view.PkRankKillAnimView.a
            public void coI() {
                a.this.isShowing = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913294, ""));
                if (a.this.iiv != null) {
                    a.this.iiv.setVisibility(8);
                }
            }
        });
    }

    private void reset() {
        this.isShowing = false;
        if (this.iiv != null) {
            this.iiv.stopAnim();
            this.iiv.setVisibility(8);
        }
    }

    public void release() {
        FB();
        if (this.bfP != null) {
            this.bfP.release();
            this.bfP = null;
        }
        if (this.iiv != null) {
            this.iiv.setCallback(null);
            this.iiv.release();
        }
        if (this.iiv != null && (this.iiv.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.iiv.getParent()).removeView(this.iiv);
        }
        this.mParentView = null;
    }
}
