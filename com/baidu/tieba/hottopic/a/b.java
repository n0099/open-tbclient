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
    public TextView jKA;
    public TextView jKB;
    public ImageView jKC;
    public LinearLayout jKD;
    public TextView jKE;
    public TextView jKF;
    public LinearLayout jKG;
    public LinearLayout jKH;
    public TextView jKt;
    public View jKw;
    public View jKx;

    public b(View view) {
        super(view);
        this.ajq = 3;
        this.jKA = null;
        this.jKt = null;
        this.jKB = null;
        this.jKw = null;
        this.jKx = null;
        this.jKC = null;
        this.jKD = null;
        this.jKE = null;
        this.jKF = null;
        this.jKG = null;
        this.jKH = null;
        this.jKA = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.jKt = (TextView) view.findViewById(R.id.hot_topic_title);
        this.jKB = (TextView) view.findViewById(R.id.hot_topic_num);
        this.jKw = view.findViewById(R.id.devide_line_top);
        this.jKx = view.findViewById(R.id.topic_devide_line_bottom);
        this.jKC = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.jKD = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.jKE = (TextView) view.findViewById(R.id.tip_info_title);
        this.jKF = (TextView) view.findViewById(R.id.tip_info_rule);
        this.jKG = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.jKH = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
