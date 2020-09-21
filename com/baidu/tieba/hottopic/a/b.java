package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class b extends af.a {
    public int aiX;
    public TextView jiW;
    public View jiZ;
    public View jja;
    public TextView jjd;
    public TextView jje;
    public ImageView jjf;
    public LinearLayout jjg;
    public TextView jjh;
    public TextView jji;
    public LinearLayout jjj;
    public LinearLayout jjk;

    public b(View view) {
        super(view);
        this.aiX = 3;
        this.jjd = null;
        this.jiW = null;
        this.jje = null;
        this.jiZ = null;
        this.jja = null;
        this.jjf = null;
        this.jjg = null;
        this.jjh = null;
        this.jji = null;
        this.jjj = null;
        this.jjk = null;
        this.jjd = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.jiW = (TextView) view.findViewById(R.id.hot_topic_title);
        this.jje = (TextView) view.findViewById(R.id.hot_topic_num);
        this.jiZ = view.findViewById(R.id.devide_line_top);
        this.jja = view.findViewById(R.id.topic_devide_line_bottom);
        this.jjf = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.jjg = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.jjh = (TextView) view.findViewById(R.id.tip_info_title);
        this.jji = (TextView) view.findViewById(R.id.tip_info_rule);
        this.jjj = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.jjk = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
