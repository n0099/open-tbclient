package com.baidu.tieba.game;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.List;
/* loaded from: classes.dex */
public class bo extends LinearLayout {
    private CarouselRecommendView<a> aJt;
    private TextView aJu;
    private TextView aJv;
    private TextView aJw;
    private View aJx;
    private View.OnClickListener mOnClickListener;

    public bo(Context context, View.OnClickListener onClickListener) {
        super(context);
        this.mOnClickListener = onClickListener;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.recommend_game_header_view, this);
        nu();
        HN();
    }

    private void nu() {
        this.aJu = (TextView) findViewById(com.baidu.tieba.v.game_new);
        this.aJv = (TextView) findViewById(com.baidu.tieba.v.game_hot);
        this.aJw = (TextView) findViewById(com.baidu.tieba.v.game_category);
        this.aJt = (CarouselRecommendView) findViewById(com.baidu.tieba.v.adv_carousel_view);
        if (this.aJt.getViewPagerBottomLine() != null) {
            this.aJt.getViewPagerBottomLine().setVisibility(0);
        }
        this.aJx = findViewById(com.baidu.tieba.v.horizontal_divider);
    }

    private void HN() {
        this.aJu.setOnClickListener(this.mOnClickListener);
        this.aJv.setOnClickListener(this.mOnClickListener);
        this.aJw.setOnClickListener(this.mOnClickListener);
    }

    public void setCarouselData(List<a> list) {
        this.aJt.setData(list);
    }

    public void setCarouselRefId(String str) {
        this.aJt.setGameRefId(str);
    }

    public CarouselRecommendView getAdvCarouselView() {
        return this.aJt;
    }

    public TextView getGameNewView() {
        return this.aJu;
    }

    public TextView getGameHotView() {
        return this.aJv;
    }

    public TextView getGameCategoryView() {
        return this.aJw;
    }

    public void sD() {
        setBackgroundColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_d));
        this.aJu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_game_tab_newgame_n), (Drawable) null, (Drawable) null);
        this.aJu.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aJv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_game_tab_hot_n), (Drawable) null, (Drawable) null);
        this.aJv.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aJw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_game_tab_class_n), (Drawable) null, (Drawable) null);
        this.aJw.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aJx.setBackgroundColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_b));
    }
}
