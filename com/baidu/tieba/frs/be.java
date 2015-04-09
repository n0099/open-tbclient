package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.widget.ListView.am {
    ChildViewPager aLg;
    TextView aLh;
    IndicatorView aLi;
    TextView aLj;
    View aLk;
    View aLl;
    ImageView aLm;
    RelativeLayout aLn;

    public be(View view) {
        super(view);
        this.aLj = (TextView) view.findViewById(com.baidu.tieba.v.live_title);
        this.aLg = (ChildViewPager) view.findViewById(com.baidu.tieba.v.live_title_child);
        this.aLi = (IndicatorView) view.findViewById(com.baidu.tieba.v.live_tab_indicator);
        this.aLh = (TextView) view.findViewById(com.baidu.tieba.v.live_show_all);
        this.aLk = view.findViewById(com.baidu.tieba.v.live_title_card_line);
        this.aLl = view.findViewById(com.baidu.tieba.v.middle_layout);
        this.aLm = (ImageView) view.findViewById(com.baidu.tieba.v.live_arrow);
        this.aLn = (RelativeLayout) view.findViewById(com.baidu.tieba.v.frs_live_upItem);
    }
}
