package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public TextView kvC;
    public TextView kvD;
    public ImageView kvE;
    public LinearLayout kvF;
    public TextView kvG;
    public TextView kvH;
    public LinearLayout kvI;
    public LinearLayout kvJ;
    public TextView kvv;
    public View kvy;
    public View kvz;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kvC = null;
        this.kvv = null;
        this.kvD = null;
        this.kvy = null;
        this.kvz = null;
        this.kvE = null;
        this.kvF = null;
        this.kvG = null;
        this.kvH = null;
        this.kvI = null;
        this.kvJ = null;
        this.kvC = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.kvv = (TextView) view.findViewById(R.id.hot_topic_title);
        this.kvD = (TextView) view.findViewById(R.id.hot_topic_num);
        this.kvy = view.findViewById(R.id.devide_line_top);
        this.kvz = view.findViewById(R.id.topic_devide_line_bottom);
        this.kvE = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.kvF = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.kvG = (TextView) view.findViewById(R.id.tip_info_title);
        this.kvH = (TextView) view.findViewById(R.id.tip_info_rule);
        this.kvI = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.kvJ = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
