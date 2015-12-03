package com.baidu.tieba.frs;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.NewChildViewPager;
/* loaded from: classes.dex */
public class dl extends x.a {
    public int afY;
    NewChildViewPager bdV;
    IndicatorView bdW;
    TextView bdX;
    View bdY;
    View bdZ;
    RelativeLayout bea;
    View beb;
    dh bec;

    public dl(View view, ex exVar) {
        super(view);
        this.afY = 3;
        this.bdX = (TextView) view.findViewById(n.f.live_title);
        this.bdV = (NewChildViewPager) view.findViewById(n.f.live_title_child);
        this.bdW = (IndicatorView) view.findViewById(n.f.live_tab_indicator);
        this.bdY = view.findViewById(n.f.live_title_card_line);
        this.bdZ = view.findViewById(n.f.middle_layout);
        this.bea = (RelativeLayout) view.findViewById(n.f.frs_live_upItem);
        this.beb = view.findViewById(n.f.all_live_list);
        this.bec = new dh(this.bdV, this.bdW, exVar);
    }
}
