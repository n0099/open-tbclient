package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.widget.ListView.am {
    ChildViewPager aKW;
    TextView aKX;
    IndicatorView aKY;
    TextView aKZ;
    View aLa;
    View aLb;
    ImageView aLc;
    RelativeLayout aLd;

    public be(View view) {
        super(view);
        this.aKZ = (TextView) view.findViewById(com.baidu.tieba.v.live_title);
        this.aKW = (ChildViewPager) view.findViewById(com.baidu.tieba.v.live_title_child);
        this.aKY = (IndicatorView) view.findViewById(com.baidu.tieba.v.live_tab_indicator);
        this.aKX = (TextView) view.findViewById(com.baidu.tieba.v.live_show_all);
        this.aLa = view.findViewById(com.baidu.tieba.v.live_title_card_line);
        this.aLb = view.findViewById(com.baidu.tieba.v.middle_layout);
        this.aLc = (ImageView) view.findViewById(com.baidu.tieba.v.live_arrow);
        this.aLd = (RelativeLayout) view.findViewById(com.baidu.tieba.v.frs_live_upItem);
    }
}
