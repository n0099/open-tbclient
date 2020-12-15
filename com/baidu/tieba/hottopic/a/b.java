package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class b extends af.a {
    public int aku;
    public TextView keH;
    public View keK;
    public View keL;
    public TextView keO;
    public TextView keP;
    public ImageView keQ;
    public LinearLayout keR;
    public TextView keS;
    public TextView keT;
    public LinearLayout keU;
    public LinearLayout keV;

    public b(View view) {
        super(view);
        this.aku = 3;
        this.keO = null;
        this.keH = null;
        this.keP = null;
        this.keK = null;
        this.keL = null;
        this.keQ = null;
        this.keR = null;
        this.keS = null;
        this.keT = null;
        this.keU = null;
        this.keV = null;
        this.keO = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.keH = (TextView) view.findViewById(R.id.hot_topic_title);
        this.keP = (TextView) view.findViewById(R.id.hot_topic_num);
        this.keK = view.findViewById(R.id.devide_line_top);
        this.keL = view.findViewById(R.id.topic_devide_line_bottom);
        this.keQ = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.keR = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.keS = (TextView) view.findViewById(R.id.tip_info_title);
        this.keT = (TextView) view.findViewById(R.id.tip_info_rule);
        this.keU = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.keV = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
