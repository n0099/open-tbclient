package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.floating.PlayDrawable;
/* loaded from: classes4.dex */
public class PlayDrawableImageView extends ImageView {
    private PlayDrawable gKG;

    public PlayDrawableImageView(Context context) {
        super(context);
        this.gKG = null;
        init();
    }

    public PlayDrawableImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKG = null;
        init();
    }

    public PlayDrawableImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKG = null;
        init();
    }

    private void init() {
        this.gKG = new PlayDrawable();
        setImageDrawable(this.gKG);
        setBackgroundResource(a.e.video_player_playbtn_bg);
        setIconState(PlayDrawable.IconState.PLAY_STATE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(M(42.0f), M(42.0f));
    }

    public void setIconState(PlayDrawable.IconState iconState) {
        if (this.gKG != null) {
            this.gKG.setIconState(iconState);
        }
    }

    public static int M(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }
}
