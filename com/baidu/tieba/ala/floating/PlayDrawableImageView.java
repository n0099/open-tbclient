package com.baidu.tieba.ala.floating;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.floating.PlayDrawable;
/* loaded from: classes11.dex */
public class PlayDrawableImageView extends ImageView {
    private PlayDrawable gUw;

    public PlayDrawableImageView(Context context) {
        super(context);
        this.gUw = null;
        init();
    }

    public PlayDrawableImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUw = null;
        init();
    }

    public PlayDrawableImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gUw = null;
        init();
    }

    private void init() {
        this.gUw = new PlayDrawable();
        setImageDrawable(this.gUw);
        setBackgroundResource(a.e.video_player_playbtn_bg);
        setIconState(PlayDrawable.IconState.PLAY_STATE);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(P(42.0f), P(42.0f));
    }

    public void setIconState(PlayDrawable.IconState iconState) {
        if (this.gUw != null) {
            this.gUw.setIconState(iconState);
        }
    }

    public static int P(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }
}
