package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* loaded from: classes.dex */
public class bk extends x.a {
    ChildViewPager aWJ;
    TextView aWK;
    IndicatorView aWL;
    TextView aWM;
    View aWN;
    View aWO;
    ImageView aWP;
    RelativeLayout aWQ;

    public bk(View view) {
        super(view);
        this.aWM = (TextView) view.findViewById(i.f.live_title);
        this.aWJ = (ChildViewPager) view.findViewById(i.f.live_title_child);
        this.aWL = (IndicatorView) view.findViewById(i.f.live_tab_indicator);
        this.aWK = (TextView) view.findViewById(i.f.live_show_all);
        this.aWN = view.findViewById(i.f.live_title_card_line);
        this.aWO = view.findViewById(i.f.middle_layout);
        this.aWP = (ImageView) view.findViewById(i.f.live_arrow);
        this.aWQ = (RelativeLayout) view.findViewById(i.f.frs_live_upItem);
    }
}
