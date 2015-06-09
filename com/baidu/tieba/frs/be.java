package com.baidu.tieba.frs;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.tieba.tbadkCore.ChildViewPager;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.widget.ListView.am {
    ChildViewPager aNp;
    TextView aNq;
    IndicatorView aNr;
    TextView aNs;
    View aNt;
    View aNu;
    ImageView aNv;
    RelativeLayout aNw;

    public be(View view) {
        super(view);
        this.aNs = (TextView) view.findViewById(com.baidu.tieba.q.live_title);
        this.aNp = (ChildViewPager) view.findViewById(com.baidu.tieba.q.live_title_child);
        this.aNr = (IndicatorView) view.findViewById(com.baidu.tieba.q.live_tab_indicator);
        this.aNq = (TextView) view.findViewById(com.baidu.tieba.q.live_show_all);
        this.aNt = view.findViewById(com.baidu.tieba.q.live_title_card_line);
        this.aNu = view.findViewById(com.baidu.tieba.q.middle_layout);
        this.aNv = (ImageView) view.findViewById(com.baidu.tieba.q.live_arrow);
        this.aNw = (RelativeLayout) view.findViewById(com.baidu.tieba.q.frs_live_upItem);
    }
}
