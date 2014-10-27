package com.baidu.tieba.game.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class GameRatingView extends LinearLayout {
    private Context mContext;

    public GameRatingView(Context context) {
        this(context, null);
    }

    public GameRatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public void setRating(int i) {
        removeAllViews();
        i = (i <= 0 || i > 10) ? 9 : 9;
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = i >> 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ImageView imageView = new ImageView(this.mContext);
            imageView.setBackgroundDrawable(aw.getDrawable(u.icon_game_star_light));
            addView(imageView, layoutParams);
        }
        int i4 = 5 - i2;
        if (i % 2 == 1) {
            ImageView imageView2 = new ImageView(this.mContext);
            imageView2.setBackgroundDrawable(aw.getDrawable(u.icon_game_star_light_half));
            addView(imageView2, layoutParams);
            i4--;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            ImageView imageView3 = new ImageView(this.mContext);
            imageView3.setBackgroundDrawable(aw.getDrawable(u.icon_game_star_cool));
            addView(imageView3, layoutParams);
        }
    }
}
