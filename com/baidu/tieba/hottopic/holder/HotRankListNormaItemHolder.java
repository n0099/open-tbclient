package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotRankListNormaItemHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public TextView knA;
    public LinearLayout knB;
    public LinearLayout knC;
    public TextView kno;
    public View knr;
    public View kns;
    public TextView knv;
    public TextView knw;
    public ImageView knx;
    public LinearLayout kny;
    public TextView knz;

    public HotRankListNormaItemHolder(View view) {
        super(view);
        this.akf = 3;
        this.knv = null;
        this.kno = null;
        this.knw = null;
        this.knr = null;
        this.kns = null;
        this.knx = null;
        this.kny = null;
        this.knz = null;
        this.knA = null;
        this.knB = null;
        this.knC = null;
        this.knv = (TextView) view.findViewById(R.id.hot_topic_rank);
        this.kno = (TextView) view.findViewById(R.id.hot_topic_title);
        this.knw = (TextView) view.findViewById(R.id.hot_topic_num);
        this.knr = view.findViewById(R.id.devide_line_top);
        this.kns = view.findViewById(R.id.topic_devide_line_bottom);
        this.knx = (ImageView) view.findViewById(R.id.hot_topic_pic);
        this.kny = (LinearLayout) view.findViewById(R.id.tip_info_item);
        this.knz = (TextView) view.findViewById(R.id.tip_info_title);
        this.knA = (TextView) view.findViewById(R.id.tip_info_rule);
        this.knB = (LinearLayout) view.findViewById(R.id.topic_normal_item);
        this.knC = (LinearLayout) view.findViewById(R.id.tip_rule_container);
    }
}
