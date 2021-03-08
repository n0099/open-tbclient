package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public TextView kxL;
    public View kxO;
    public View kxP;
    public TextView kxS;
    public TextView kxT;
    public ImageView kxU;
    public LinearLayout kxV;
    public TextView kxW;
    public TextView kxX;
    public LinearLayout kxY;
    public LinearLayout kxZ;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.aln = 3;
        this.kxS = null;
        this.kxL = null;
        this.kxT = null;
        this.kxO = null;
        this.kxP = null;
        this.kxU = null;
        this.kxV = null;
        this.kxW = null;
        this.kxX = null;
        this.kxY = null;
        this.kxZ = null;
        this.kxS = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.kxL = (TextView) view.findViewById(R.id.hot_topic_title);
        this.kxT = (TextView) view.findViewById(R.id.hot_topic_num);
        this.kxO = view.findViewById(R.id.devide_line_top);
        this.kxP = view.findViewById(R.id.topic_devide_line_bottom);
        this.kxU = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.kxV = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.kxW = (TextView) view.findViewById(R.id.tip_info_title);
        this.kxX = (TextView) view.findViewById(R.id.tip_info_rule);
        this.kxY = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.kxZ = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
