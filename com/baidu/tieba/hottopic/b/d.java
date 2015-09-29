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
    public IndicatorView aXF;
    public int apR;
    public RelativeLayout bpE;
    public TextView bpF;
    public TextView bpG;
    public View bpH;
    public RelateForumViewPager bpI;
    public e bpJ;

    public d(View view, HotTopicActivity hotTopicActivity) {
        super(view);
        this.apR = 3;
        this.bpF = null;
        this.bpG = null;
        this.aXF = null;
        this.bpH = null;
        this.bpI = null;
        this.bpJ = null;
        this.bpE = (RelativeLayout) view.findViewById(i.f.relate_forum_top_area);
        this.bpF = (TextView) view.findViewById(i.f.reltate_forum_item_theme_title);
        this.bpG = (TextView) view.findViewById(i.f.relate_forum_more_textview);
        this.aXF = (IndicatorView) view.findViewById(i.f.relate_forum_tab_indicator);
        this.bpH = view.findViewById(i.f.relate_forum_item_divider_line);
        this.bpI = (RelateForumViewPager) view.findViewById(i.f.relate_forum_child_container);
        this.bpJ = new e(hotTopicActivity, this.bpI, this.aXF, this.bpG);
    }
}
