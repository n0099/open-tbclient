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
    ChildViewPager aXE;
    IndicatorView aXF;
    TextView aXG;
    View aXH;
    View aXI;
    RelativeLayout aXJ;
    View aXK;
    cr aXL;

    public cv(View view) {
        super(view);
        this.aXG = (TextView) view.findViewById(i.f.live_title);
        this.aXE = (ChildViewPager) view.findViewById(i.f.live_title_child);
        this.aXF = (IndicatorView) view.findViewById(i.f.live_tab_indicator);
        this.aXH = view.findViewById(i.f.live_title_card_line);
        this.aXI = view.findViewById(i.f.middle_layout);
        this.aXJ = (RelativeLayout) view.findViewById(i.f.frs_live_upItem);
        this.aXK = view.findViewById(i.f.all_live_list);
        this.aXL = new cr(this.aXE, this.aXF);
    }
}
