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
    public IndicatorView aXQ;
    public int apS;
    public RelativeLayout bpP;
    public TextView bpQ;
    public TextView bpR;
    public View bpS;
    public RelateForumViewPager bpT;
    public e bpU;

    public d(View view, HotTopicActivity hotTopicActivity) {
        super(view);
        this.apS = 3;
        this.bpQ = null;
        this.bpR = null;
        this.aXQ = null;
        this.bpS = null;
        this.bpT = null;
        this.bpU = null;
        this.bpP = (RelativeLayout) view.findViewById(i.f.relate_forum_top_area);
        this.bpQ = (TextView) view.findViewById(i.f.reltate_forum_item_theme_title);
        this.bpR = (TextView) view.findViewById(i.f.relate_forum_more_textview);
        this.aXQ = (IndicatorView) view.findViewById(i.f.relate_forum_tab_indicator);
        this.bpS = view.findViewById(i.f.relate_forum_item_divider_line);
        this.bpT = (RelateForumViewPager) view.findViewById(i.f.relate_forum_child_container);
        this.bpU = new e(hotTopicActivity, this.bpT, this.aXQ, this.bpR);
    }
}
