package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public TextView krT;
    public View krW;
    public View krX;
    public TextView ksa;
    public TextView ksb;
    public ImageView ksc;
    public LinearLayout ksd;
    public TextView kse;
    public TextView ksf;
    public LinearLayout ksg;
    public LinearLayout ksh;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.akW = 3;
        this.ksa = null;
        this.krT = null;
        this.ksb = null;
        this.krW = null;
        this.krX = null;
        this.ksc = null;
        this.ksd = null;
        this.kse = null;
        this.ksf = null;
        this.ksg = null;
        this.ksh = null;
        this.ksa = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.krT = (TextView) view.findViewById(R.id.hot_topic_title);
        this.ksb = (TextView) view.findViewById(R.id.hot_topic_num);
        this.krW = view.findViewById(R.id.devide_line_top);
        this.krX = view.findViewById(R.id.topic_devide_line_bottom);
        this.ksc = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.ksd = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.kse = (TextView) view.findViewById(R.id.tip_info_title);
        this.ksf = (TextView) view.findViewById(R.id.tip_info_rule);
        this.ksg = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.ksh = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
