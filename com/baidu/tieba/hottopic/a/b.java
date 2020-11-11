package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b extends af.a {
    public int ajq;
    public ImageView jQA;
    public LinearLayout jQB;
    public TextView jQC;
    public TextView jQD;
    public LinearLayout jQE;
    public LinearLayout jQF;
    public TextView jQr;
    public View jQu;
    public View jQv;
    public TextView jQy;
    public TextView jQz;

    public b(View view) {
        super(view);
        this.ajq = 3;
        this.jQy = null;
        this.jQr = null;
        this.jQz = null;
        this.jQu = null;
        this.jQv = null;
        this.jQA = null;
        this.jQB = null;
        this.jQC = null;
        this.jQD = null;
        this.jQE = null;
        this.jQF = null;
        this.jQy = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.jQr = (TextView) view.findViewById(R.id.hot_topic_title);
        this.jQz = (TextView) view.findViewById(R.id.hot_topic_num);
        this.jQu = view.findViewById(R.id.devide_line_top);
        this.jQv = view.findViewById(R.id.topic_devide_line_bottom);
        this.jQA = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.jQB = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.jQC = (TextView) view.findViewById(R.id.tip_info_title);
        this.jQD = (TextView) view.findViewById(R.id.tip_info_rule);
        this.jQE = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.jQF = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
