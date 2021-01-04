package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotRankListManualItemHolder extends TypeAdapter.ViewHolder {
    public int akW;
    public TextView krS;
    public TextView krT;
    public TextView krU;
    public TextView krV;
    public View krW;
    public View krX;
    public TbImageView krY;
    public LinearLayout krZ;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.akW = 3;
        this.krS = null;
        this.krT = null;
        this.krU = null;
        this.krV = null;
        this.krW = null;
        this.krX = null;
        this.krY = null;
        this.krZ = null;
        this.krS = (TextView) view.findViewById(R.id.topic_module);
        this.krU = (TextView) view.findViewById(R.id.topic_desc);
        this.krT = (TextView) view.findViewById(R.id.topic_title);
        this.krY = (TbImageView) view.findViewById(R.id.topic_pic);
        this.krW = view.findViewById(R.id.devide_line_top);
        this.krX = view.findViewById(R.id.devide_line_bottom);
        this.krZ = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
