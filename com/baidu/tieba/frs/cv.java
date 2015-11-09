package com.baidu.tieba.frs;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* loaded from: classes.dex */
public class cv extends x.a {
    ChildViewPager aXY;
    IndicatorView aXZ;
    TextView aYa;
    View aYb;
    View aYc;
    RelativeLayout aYd;
    View aYe;
    cr aYf;

    public cv(View view) {
        super(view);
        this.aYa = (TextView) view.findViewById(i.f.live_title);
        this.aXY = (ChildViewPager) view.findViewById(i.f.live_title_child);
        this.aXZ = (IndicatorView) view.findViewById(i.f.live_tab_indicator);
        this.aYb = view.findViewById(i.f.live_title_card_line);
        this.aYc = view.findViewById(i.f.middle_layout);
        this.aYd = (RelativeLayout) view.findViewById(i.f.frs_live_upItem);
        this.aYe = view.findViewById(i.f.all_live_list);
        this.aYf = new cr(this.aXY, this.aXZ);
    }
}
