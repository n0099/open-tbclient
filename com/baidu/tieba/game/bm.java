package com.baidu.tieba.game;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.List;
/* loaded from: classes.dex */
public class bm extends LinearLayout {
    private CarouselRecommendView<a> aJg;
    private TextView aJh;
    private TextView aJi;
    private TextView aJj;
    private View aJk;
    private View.OnClickListener mOnClickListener;

    public bm(Context context, View.OnClickListener onClickListener) {
        super(context);
        this.mOnClickListener = onClickListener;
        com.baidu.adp.lib.g.b.ek().inflate(context, com.baidu.tieba.w.recommend_game_header_view, this);
        nu();
        HJ();
    }

    private void nu() {
        this.aJh = (TextView) findViewById(com.baidu.tieba.v.game_new);
        this.aJi = (TextView) findViewById(com.baidu.tieba.v.game_hot);
        this.aJj = (TextView) findViewById(com.baidu.tieba.v.game_category);
        this.aJg = (CarouselRecommendView) findViewById(com.baidu.tieba.v.adv_carousel_view);
        if (this.aJg.getViewPagerBottomLine() != null) {
            this.aJg.getViewPagerBottomLine().setVisibility(0);
        }
        this.aJk = findViewById(com.baidu.tieba.v.horizontal_divider);
    }

    private void HJ() {
        this.aJh.setOnClickListener(this.mOnClickListener);
        this.aJi.setOnClickListener(this.mOnClickListener);
        this.aJj.setOnClickListener(this.mOnClickListener);
    }

    public void setCarouselData(List<a> list) {
        this.aJg.setData(list);
    }

    public void setCarouselRefId(String str) {
        this.aJg.setGameRefId(str);
    }

    public CarouselRecommendView getAdvCarouselView() {
        return this.aJg;
    }

    public TextView getGameNewView() {
        return this.aJh;
    }

    public TextView getGameHotView() {
        return this.aJi;
    }

    public TextView getGameCategoryView() {
        return this.aJj;
    }

    public void sB() {
        setBackgroundColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_d));
        this.aJh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_game_tab_newgame_n), (Drawable) null, (Drawable) null);
        this.aJh.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aJi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_game_tab_hot_n), (Drawable) null, (Drawable) null);
        this.aJi.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aJj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_game_tab_class_n), (Drawable) null, (Drawable) null);
        this.aJj.setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aJk.setBackgroundColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_bg_line_b));
    }
}
