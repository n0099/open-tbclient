package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {
    public int ajU;
    public TextView kvI;
    public TextView kvJ;
    public TextView kvK;
    public TextView kvL;
    public View kvM;
    public View kvN;
    public TbImageView kvO;
    public LinearLayout kvP;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kvI = null;
        this.kvJ = null;
        this.kvK = null;
        this.kvL = null;
        this.kvM = null;
        this.kvN = null;
        this.kvO = null;
        this.kvP = null;
        this.kvI = (TextView) view.findViewById(R.id.topic_module);
        this.kvK = (TextView) view.findViewById(R.id.topic_desc);
        this.kvJ = (TextView) view.findViewById(R.id.topic_title);
        this.kvO = (TbImageView) view.findViewById(R.id.topic_pic);
        this.kvM = view.findViewById(R.id.devide_line_top);
        this.kvN = view.findViewById(R.id.devide_line_bottom);
        this.kvP = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
