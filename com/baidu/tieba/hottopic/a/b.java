package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class b extends af.a {
    public int aiD;
    public LinearLayout jaA;
    public TextView jaB;
    public TextView jaC;
    public LinearLayout jaD;
    public LinearLayout jaE;
    public TextView jaq;
    public View jat;
    public View jau;
    public TextView jax;
    public TextView jay;
    public ImageView jaz;

    public b(View view) {
        super(view);
        this.aiD = 3;
        this.jax = null;
        this.jaq = null;
        this.jay = null;
        this.jat = null;
        this.jau = null;
        this.jaz = null;
        this.jaA = null;
        this.jaB = null;
        this.jaC = null;
        this.jaD = null;
        this.jaE = null;
        this.jax = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.jaq = (TextView) view.findViewById(R.id.hot_topic_title);
        this.jay = (TextView) view.findViewById(R.id.hot_topic_num);
        this.jat = view.findViewById(R.id.devide_line_top);
        this.jau = view.findViewById(R.id.topic_devide_line_bottom);
        this.jaz = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.jaA = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.jaB = (TextView) view.findViewById(R.id.tip_info_title);
        this.jaC = (TextView) view.findViewById(R.id.tip_info_rule);
        this.jaD = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.jaE = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
