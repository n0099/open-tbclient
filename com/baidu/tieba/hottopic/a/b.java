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
    public TextView keF;
    public View keI;
    public View keJ;
    public TextView keM;
    public TextView keN;
    public ImageView keO;
    public LinearLayout keP;
    public TextView keQ;
    public TextView keR;
    public LinearLayout keS;
    public LinearLayout keT;

    public b(View view) {
        super(view);
        this.aku = 3;
        this.keM = null;
        this.keF = null;
        this.keN = null;
        this.keI = null;
        this.keJ = null;
        this.keO = null;
        this.keP = null;
        this.keQ = null;
        this.keR = null;
        this.keS = null;
        this.keT = null;
        this.keM = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.keF = (TextView) view.findViewById(R.id.hot_topic_title);
        this.keN = (TextView) view.findViewById(R.id.hot_topic_num);
        this.keI = view.findViewById(R.id.devide_line_top);
        this.keJ = view.findViewById(R.id.topic_devide_line_bottom);
        this.keO = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.keP = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.keQ = (TextView) view.findViewById(R.id.tip_info_title);
        this.keR = (TextView) view.findViewById(R.id.tip_info_rule);
        this.keS = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.keT = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
