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
    ChildViewPager aXP;
    IndicatorView aXQ;
    TextView aXR;
    View aXS;
    View aXT;
    RelativeLayout aXU;
    View aXV;
    cr aXW;

    public cv(View view) {
        super(view);
        this.aXR = (TextView) view.findViewById(i.f.live_title);
        this.aXP = (ChildViewPager) view.findViewById(i.f.live_title_child);
        this.aXQ = (IndicatorView) view.findViewById(i.f.live_tab_indicator);
        this.aXS = view.findViewById(i.f.live_title_card_line);
        this.aXT = view.findViewById(i.f.middle_layout);
        this.aXU = (RelativeLayout) view.findViewById(i.f.frs_live_upItem);
        this.aXV = view.findViewById(i.f.all_live_list);
        this.aXW = new cr(this.aXP, this.aXQ);
    }
}
