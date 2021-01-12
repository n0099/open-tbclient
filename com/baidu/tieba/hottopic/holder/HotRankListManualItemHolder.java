package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {
    public int akf;
    public TextView knn;
    public TextView kno;
    public TextView knp;
    public TextView knq;
    public View knr;
    public View kns;
    public TbImageView knt;
    public LinearLayout knu;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.akf = 3;
        this.knn = null;
        this.kno = null;
        this.knp = null;
        this.knq = null;
        this.knr = null;
        this.kns = null;
        this.knt = null;
        this.knu = null;
        this.knn = (TextView) view.findViewById(R.id.topic_module);
        this.knp = (TextView) view.findViewById(R.id.topic_desc);
        this.kno = (TextView) view.findViewById(R.id.topic_title);
        this.knt = (TbImageView) view.findViewById(R.id.topic_pic);
        this.knr = view.findViewById(R.id.devide_line_top);
        this.kns = view.findViewById(R.id.devide_line_bottom);
        this.knu = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
