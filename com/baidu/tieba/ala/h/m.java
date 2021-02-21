package com.baidu.tieba.ala.h;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView;
/* loaded from: classes11.dex */
public class m {
    private MediaMetadataRetriever bem;
    private PkRankTaskBGStartAnimView ihi;
    private ViewGroup mParentView;

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coB();
    }

    public void PU() {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean coZ() {
        int i;
        int i2;
        int i3;
        coB();
        this.ihi.setVisibility(0);
        String coE = o.cpa().coE();
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
                    this.ihi.bX(realScreenWidth, TextUtils.isEmpty(coE) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    return this.ihi.IF(coE);
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
        this.ihi.bX(realScreenWidth2, TextUtils.isEmpty(coE) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        return this.ihi.IF(coE);
    }

    private void coB() {
        if (this.ihi == null) {
            this.ihi = new PkRankTaskBGStartAnimView(getContext());
        }
        if (bkq().indexOfChild(this.ihi) < 0) {
            bkq().addView(this.ihi, new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds220), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds88)));
        }
        this.ihi.setVisibility(8);
        this.ihi.setCallback(new PkRankTaskBGStartAnimView.a() { // from class: com.baidu.tieba.ala.h.m.1
            @Override // com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView.a
            public void coC() {
            }
        });
    }

    public void reset() {
        if (this.ihi != null) {
            this.ihi.stopAnim();
            this.ihi.setVisibility(8);
        }
    }

    public void release() {
        reset();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.ihi != null) {
            this.ihi.setCallback(null);
            this.ihi.release();
        }
        if (this.ihi != null && (this.ihi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ihi.getParent()).removeView(this.ihi);
        }
        this.mParentView = null;
    }
}
