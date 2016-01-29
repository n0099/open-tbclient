package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends x.a {
    public int ahU;
    public TextView bLI;
    public View bLL;
    public View bLM;
    public TextView bLP;
    public TextView bLQ;
    public ImageView bLR;
    public LinearLayout bLS;
    public TextView bLT;
    public TextView bLU;
    public LinearLayout bLV;
    public LinearLayout bLW;
    public ImageView bLX;

    public b(View view) {
        super(view);
        this.ahU = 3;
        this.bLP = null;
        this.bLI = null;
        this.bLQ = null;
        this.bLL = null;
        this.bLM = null;
        this.bLR = null;
        this.bLS = null;
        this.bLT = null;
        this.bLU = null;
        this.bLV = null;
        this.bLW = null;
        this.bLP = (TextView) view.findViewById(t.g.hot_topic_rank);
        this.bLI = (TextView) view.findViewById(t.g.hot_topic_title);
        this.bLQ = (TextView) view.findViewById(t.g.hot_topic_num);
        this.bLL = view.findViewById(t.g.devide_line_top);
        this.bLM = view.findViewById(t.g.topic_devide_line_bottom);
        this.bLR = (ImageView) view.findViewById(t.g.hot_topic_pic);
        this.bLS = (LinearLayout) view.findViewById(t.g.tip_info_item);
        this.bLT = (TextView) view.findViewById(t.g.tip_info_title);
        this.bLU = (TextView) view.findViewById(t.g.tip_info_rule);
        this.bLV = (LinearLayout) view.findViewById(t.g.topic_normal_item);
        this.bLW = (LinearLayout) view.findViewById(t.g.tip_rule_container);
        this.bLX = (ImageView) view.findViewById(t.g.tip_info_pic);
    }
}
