package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.widget.ListView.am {
    ChildViewPager aNo;
    TextView aNp;
    IndicatorView aNq;
    TextView aNr;
    View aNs;
    View aNt;
    ImageView aNu;
    RelativeLayout aNv;

    public be(View view) {
        super(view);
        this.aNr = (TextView) view.findViewById(com.baidu.tieba.q.live_title);
        this.aNo = (ChildViewPager) view.findViewById(com.baidu.tieba.q.live_title_child);
        this.aNq = (IndicatorView) view.findViewById(com.baidu.tieba.q.live_tab_indicator);
        this.aNp = (TextView) view.findViewById(com.baidu.tieba.q.live_show_all);
        this.aNs = view.findViewById(com.baidu.tieba.q.live_title_card_line);
        this.aNt = view.findViewById(com.baidu.tieba.q.middle_layout);
        this.aNu = (ImageView) view.findViewById(com.baidu.tieba.q.live_arrow);
        this.aNv = (RelativeLayout) view.findViewById(com.baidu.tieba.q.frs_live_upItem);
    }
}
