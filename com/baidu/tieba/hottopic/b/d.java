package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.view.RelateForumViewPager;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d extends x.a {
    public IndicatorView aXZ;
    public int arf;
    public RelativeLayout bqt;
    public TextView bqu;
    public TextView bqv;
    public View bqw;
    public RelateForumViewPager bqx;
    public e bqy;

    public d(View view, HotTopicActivity hotTopicActivity) {
        super(view);
        this.arf = 3;
        this.bqu = null;
        this.bqv = null;
        this.aXZ = null;
        this.bqw = null;
        this.bqx = null;
        this.bqy = null;
        this.bqt = (RelativeLayout) view.findViewById(i.f.relate_forum_top_area);
        this.bqu = (TextView) view.findViewById(i.f.reltate_forum_item_theme_title);
        this.bqv = (TextView) view.findViewById(i.f.relate_forum_more_textview);
        this.aXZ = (IndicatorView) view.findViewById(i.f.relate_forum_tab_indicator);
        this.bqw = view.findViewById(i.f.relate_forum_item_divider_line);
        this.bqx = (RelateForumViewPager) view.findViewById(i.f.relate_forum_child_container);
        this.bqy = new e(hotTopicActivity, this.bqx, this.aXZ, this.bqv);
    }
}
