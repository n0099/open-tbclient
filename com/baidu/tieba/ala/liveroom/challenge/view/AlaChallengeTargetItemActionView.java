package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaChallengeTargetItemActionView extends TextView {
    private int mStyle;

    public AlaChallengeTargetItemActionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStyle = 0;
        init();
    }

    public void setStyle(int i) {
        if (this.mStyle != i) {
            this.mStyle = i;
            switch (i) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(getResources().getColor(a.c.ala_challenge_latest_primary));
                    gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.d.sdk_ds12));
                    setBackgroundDrawable(gradientDrawable);
                    setText("邀请");
                    setTextColor(-1);
                    return;
                case 2:
                    setBackgroundColor(0);
                    setText("挑战中");
                    setTextColor(getResources().getColor(a.c.ala_challenge_latest_primary));
                    return;
                case 3:
                    setBackgroundColor(0);
                    setText("未直播");
                    setTextColor(-2130706433);
                    return;
                case 4:
                    setBackgroundColor(0);
                    setText("PK中");
                    setTextColor(getResources().getColor(a.c.ala_challenge_latest_primary));
                    return;
                default:
                    setBackgroundColor(0);
                    setText("");
                    return;
            }
        }
    }

    private void init() {
        setGravity(17);
        setIncludeFontPadding(false);
    }
}
