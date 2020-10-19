package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b extends af.a {
    public int ajp;
    public TextView jxU;
    public View jxX;
    public View jxY;
    public TextView jyb;
    public TextView jyc;
    public ImageView jyd;
    public LinearLayout jye;
    public TextView jyf;
    public TextView jyg;
    public LinearLayout jyh;
    public LinearLayout jyi;

    public b(View view) {
        super(view);
        this.ajp = 3;
        this.jyb = null;
        this.jxU = null;
        this.jyc = null;
        this.jxX = null;
        this.jxY = null;
        this.jyd = null;
        this.jye = null;
        this.jyf = null;
        this.jyg = null;
        this.jyh = null;
        this.jyi = null;
        this.jyb = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.jxU = (TextView) view.findViewById(R.id.hot_topic_title);
        this.jyc = (TextView) view.findViewById(R.id.hot_topic_num);
        this.jxX = view.findViewById(R.id.devide_line_top);
        this.jxY = view.findViewById(R.id.topic_devide_line_bottom);
        this.jyd = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.jye = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.jyf = (TextView) view.findViewById(R.id.tip_info_title);
        this.jyg = (TextView) view.findViewById(R.id.tip_info_rule);
        this.jyh = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.jyi = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
