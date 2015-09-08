package com.baidu.tieba.frs;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* loaded from: classes.dex */
public class cl extends x.a {
    ChildViewPager aYk;
    IndicatorView aYl;
    TextView aYm;
    View aYn;
    View aYo;
    RelativeLayout aYp;
    View aYq;
    ch aYr;

    public cl(View view) {
        super(view);
        this.aYm = (TextView) view.findViewById(i.f.live_title);
        this.aYk = (ChildViewPager) view.findViewById(i.f.live_title_child);
        this.aYl = (IndicatorView) view.findViewById(i.f.live_tab_indicator);
        this.aYn = view.findViewById(i.f.live_title_card_line);
        this.aYo = view.findViewById(i.f.middle_layout);
        this.aYp = (RelativeLayout) view.findViewById(i.f.frs_live_upItem);
        this.aYq = view.findViewById(i.f.all_live_list);
        this.aYr = new ch(this.aYk, this.aYl);
    }
}
