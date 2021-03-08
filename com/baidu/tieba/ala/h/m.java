package com.baidu.tieba.ala.h;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView;
/* loaded from: classes10.dex */
public class m {
    private MediaMetadataRetriever bfP;
    private PkRankTaskBGStartAnimView iiR;
    private ViewGroup mParentView;

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        coH();
    }

    public void PX() {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cpf() {
        int i;
        int i2;
        int i3;
        coH();
        this.iiR.setVisibility(0);
        String coK = o.cpg().coK();
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
                    this.iiR.bX(realScreenWidth, TextUtils.isEmpty(coK) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    return this.iiR.IO(coK);
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
        this.iiR.bX(realScreenWidth2, TextUtils.isEmpty(coK) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        return this.iiR.IO(coK);
    }

    private void coH() {
        if (this.iiR == null) {
            this.iiR = new PkRankTaskBGStartAnimView(getContext());
        }
        if (bks().indexOfChild(this.iiR) < 0) {
            bks().addView(this.iiR, new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds220), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds88)));
        }
        this.iiR.setVisibility(8);
        this.iiR.setCallback(new PkRankTaskBGStartAnimView.a() { // from class: com.baidu.tieba.ala.h.m.1
            @Override // com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView.a
            public void coI() {
            }
        });
    }

    public void reset() {
        if (this.iiR != null) {
            this.iiR.stopAnim();
            this.iiR.setVisibility(8);
        }
    }

    public void release() {
        reset();
        if (this.bfP != null) {
            this.bfP.release();
            this.bfP = null;
        }
        if (this.iiR != null) {
            this.iiR.setCallback(null);
            this.iiR.release();
        }
        if (this.iiR != null && (this.iiR.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.iiR.getParent()).removeView(this.iiR);
        }
        this.mParentView = null;
    }
}
