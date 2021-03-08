package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {
    public int aln;
    public TextView kxK;
    public TextView kxL;
    public TextView kxM;
    public TextView kxN;
    public View kxO;
    public View kxP;
    public TbImageView kxQ;
    public LinearLayout kxR;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.aln = 3;
        this.kxK = null;
        this.kxL = null;
        this.kxM = null;
        this.kxN = null;
        this.kxO = null;
        this.kxP = null;
        this.kxQ = null;
        this.kxR = null;
        this.kxK = (TextView) view.findViewById(R.id.topic_module);
        this.kxM = (TextView) view.findViewById(R.id.topic_desc);
        this.kxL = (TextView) view.findViewById(R.id.topic_title);
        this.kxQ = (TbImageView) view.findViewById(R.id.topic_pic);
        this.kxO = view.findViewById(R.id.devide_line_top);
        this.kxP = view.findViewById(R.id.devide_line_bottom);
        this.kxR = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
