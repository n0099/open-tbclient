package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class b extends ad.a {
    public int aho;
    public LinearLayout iLA;
    public TextView iLm;
    public View iLp;
    public View iLq;
    public TextView iLt;
    public TextView iLu;
    public ImageView iLv;
    public LinearLayout iLw;
    public TextView iLx;
    public TextView iLy;
    public LinearLayout iLz;

    public b(View view) {
        super(view);
        this.aho = 3;
        this.iLt = null;
        this.iLm = null;
        this.iLu = null;
        this.iLp = null;
        this.iLq = null;
        this.iLv = null;
        this.iLw = null;
        this.iLx = null;
        this.iLy = null;
        this.iLz = null;
        this.iLA = null;
        this.iLt = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.iLm = (TextView) view.findViewById(R.id.hot_topic_title);
        this.iLu = (TextView) view.findViewById(R.id.hot_topic_num);
        this.iLp = view.findViewById(R.id.devide_line_top);
        this.iLq = view.findViewById(R.id.topic_devide_line_bottom);
        this.iLv = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.iLw = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.iLx = (TextView) view.findViewById(R.id.tip_info_title);
        this.iLy = (TextView) view.findViewById(R.id.tip_info_rule);
        this.iLz = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.iLA = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
