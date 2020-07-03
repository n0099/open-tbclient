package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends ad.a {
    public int ahx;
    public TextView iFg;
    public View iFj;
    public View iFk;
    public TextView iFn;
    public TextView iFo;
    public ImageView iFp;
    public LinearLayout iFq;
    public TextView iFr;
    public TextView iFs;
    public LinearLayout iFt;
    public LinearLayout iFu;

    public b(View view) {
        super(view);
        this.ahx = 3;
        this.iFn = null;
        this.iFg = null;
        this.iFo = null;
        this.iFj = null;
        this.iFk = null;
        this.iFp = null;
        this.iFq = null;
        this.iFr = null;
        this.iFs = null;
        this.iFt = null;
        this.iFu = null;
        this.iFn = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.iFg = (TextView) view.findViewById(R.id.hot_topic_title);
        this.iFo = (TextView) view.findViewById(R.id.hot_topic_num);
        this.iFj = view.findViewById(R.id.devide_line_top);
        this.iFk = view.findViewById(R.id.topic_devide_line_bottom);
        this.iFp = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.iFq = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.iFr = (TextView) view.findViewById(R.id.tip_info_title);
        this.iFs = (TextView) view.findViewById(R.id.tip_info_rule);
        this.iFt = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.iFu = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
