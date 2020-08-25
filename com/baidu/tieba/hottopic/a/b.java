package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class b extends af.a {
    public int aiB;
    public TextView jak;
    public View jan;
    public View jao;
    public TextView jar;
    public TextView jas;
    public ImageView jat;
    public LinearLayout jau;
    public TextView jav;
    public TextView jaw;
    public LinearLayout jax;
    public LinearLayout jay;

    public b(View view) {
        super(view);
        this.aiB = 3;
        this.jar = null;
        this.jak = null;
        this.jas = null;
        this.jan = null;
        this.jao = null;
        this.jat = null;
        this.jau = null;
        this.jav = null;
        this.jaw = null;
        this.jax = null;
        this.jay = null;
        this.jar = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.jak = (TextView) view.findViewById(R.id.hot_topic_title);
        this.jas = (TextView) view.findViewById(R.id.hot_topic_num);
        this.jan = view.findViewById(R.id.devide_line_top);
        this.jao = view.findViewById(R.id.topic_devide_line_bottom);
        this.jat = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.jau = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.jav = (TextView) view.findViewById(R.id.tip_info_title);
        this.jaw = (TextView) view.findViewById(R.id.tip_info_rule);
        this.jax = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.jay = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
