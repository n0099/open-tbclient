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
    private PlayDrawable gmh;

    public PlayDrawableImageView(Context context) {
        super(context);
        this.gmh = null;
        init();
    }

    public PlayDrawableImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gmh = null;
        init();
    }

    public PlayDrawableImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gmh = null;
        init();
    }

    private void init() {
        this.gmh = new PlayDrawable();
        setImageDrawable(this.gmh);
        setBackgroundResource(a.f.video_player_playbtn_bg);
        setIconState(PlayDrawable.IconState.PLAY_STATE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(J(42.0f), J(42.0f));
    }

    public void setIconState(PlayDrawable.IconState iconState) {
        if (this.gmh != null) {
            this.gmh.setIconState(iconState);
        }
    }

    public static int J(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }
}
