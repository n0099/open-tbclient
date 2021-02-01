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
    private PkRankTaskBGStartAnimView igU;
    private ViewGroup mParentView;

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
        cou();
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
    public boolean coS() {
        int i;
        int i2;
        int i3;
        cou();
        this.igU.setVisibility(0);
        String cox = o.coT().cox();
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
                    this.igU.bW(realScreenWidth, TextUtils.isEmpty(cox) ? (realScreenWidth * i) / (i2 / 2) : realScreenWidth);
                    return this.igU.IE(cox);
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
        this.igU.bW(realScreenWidth2, TextUtils.isEmpty(cox) ? (realScreenWidth2 * i) / (i2 / 2) : realScreenWidth2);
        return this.igU.IE(cox);
    }

    private void cou() {
        if (this.igU == null) {
            this.igU = new PkRankTaskBGStartAnimView(getContext());
        }
        if (bkq().indexOfChild(this.igU) < 0) {
            bkq().addView(this.igU, new ViewGroup.LayoutParams(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds220), getContext().getResources().getDimensionPixelSize(a.d.sdk_ds88)));
        }
        this.igU.setVisibility(8);
        this.igU.setCallback(new PkRankTaskBGStartAnimView.a() { // from class: com.baidu.tieba.ala.h.m.1
            @Override // com.baidu.tieba.ala.view.PkRankTaskBGStartAnimView.a
            public void cov() {
            }
        });
    }

    public void reset() {
        if (this.igU != null) {
            this.igU.stopAnim();
            this.igU.setVisibility(8);
        }
    }

    public void release() {
        reset();
        if (this.bem != null) {
            this.bem.release();
            this.bem = null;
        }
        if (this.igU != null) {
            this.igU.setCallback(null);
            this.igU.release();
        }
        if (this.igU != null && (this.igU.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.igU.getParent()).removeView(this.igU);
        }
        this.mParentView = null;
    }
}
