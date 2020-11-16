package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class b extends af.a {
    public int ajv;
    public TextView jRb;
    public View jRe;
    public View jRf;
    public TextView jRi;
    public TextView jRj;
    public ImageView jRk;
    public LinearLayout jRl;
    public TextView jRm;
    public TextView jRn;
    public LinearLayout jRo;
    public LinearLayout jRp;

    public b(View view) {
        super(view);
        this.ajv = 3;
        this.jRi = null;
        this.jRb = null;
        this.jRj = null;
        this.jRe = null;
        this.jRf = null;
        this.jRk = null;
        this.jRl = null;
        this.jRm = null;
        this.jRn = null;
        this.jRo = null;
        this.jRp = null;
        this.jRi = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.jRb = (TextView) view.findViewById(R.id.hot_topic_title);
        this.jRj = (TextView) view.findViewById(R.id.hot_topic_num);
        this.jRe = view.findViewById(R.id.devide_line_top);
        this.jRf = view.findViewById(R.id.topic_devide_line_bottom);
        this.jRk = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.jRl = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.jRm = (TextView) view.findViewById(R.id.tip_info_title);
        this.jRn = (TextView) view.findViewById(R.id.tip_info_rule);
        this.jRo = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.jRp = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
