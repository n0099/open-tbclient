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
    public TextView iLk;
    public View iLn;
    public View iLo;
    public TextView iLr;
    public TextView iLs;
    public ImageView iLt;
    public LinearLayout iLu;
    public TextView iLv;
    public TextView iLw;
    public LinearLayout iLx;
    public LinearLayout iLy;

    public b(View view) {
        super(view);
        this.aho = 3;
        this.iLr = null;
        this.iLk = null;
        this.iLs = null;
        this.iLn = null;
        this.iLo = null;
        this.iLt = null;
        this.iLu = null;
        this.iLv = null;
        this.iLw = null;
        this.iLx = null;
        this.iLy = null;
        this.iLr = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.iLk = (TextView) view.findViewById(R.id.hot_topic_title);
        this.iLs = (TextView) view.findViewById(R.id.hot_topic_num);
        this.iLn = view.findViewById(R.id.devide_line_top);
        this.iLo = view.findViewById(R.id.topic_devide_line_bottom);
        this.iLt = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.iLu = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.iLv = (TextView) view.findViewById(R.id.tip_info_title);
        this.iLw = (TextView) view.findViewById(R.id.tip_info_rule);
        this.iLx = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.iLy = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
