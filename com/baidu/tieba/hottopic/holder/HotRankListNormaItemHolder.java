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
    public TextView kvJ;
    public View kvM;
    public View kvN;
    public TextView kvQ;
    public TextView kvR;
    public ImageView kvS;
    public LinearLayout kvT;
    public TextView kvU;
    public TextView kvV;
    public LinearLayout kvW;
    public LinearLayout kvX;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kvQ = null;
        this.kvJ = null;
        this.kvR = null;
        this.kvM = null;
        this.kvN = null;
        this.kvS = null;
        this.kvT = null;
        this.kvU = null;
        this.kvV = null;
        this.kvW = null;
        this.kvX = null;
        this.kvQ = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.kvJ = (TextView) view.findViewById(R.id.hot_topic_title);
        this.kvR = (TextView) view.findViewById(R.id.hot_topic_num);
        this.kvM = view.findViewById(R.id.devide_line_top);
        this.kvN = view.findViewById(R.id.topic_devide_line_bottom);
        this.kvS = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.kvT = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.kvU = (TextView) view.findViewById(R.id.tip_info_title);
        this.kvV = (TextView) view.findViewById(R.id.tip_info_rule);
        this.kvW = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.kvX = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
