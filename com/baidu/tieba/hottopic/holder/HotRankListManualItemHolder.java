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
    public TbImageView kvA;
    public LinearLayout kvB;
    public TextView kvu;
    public TextView kvv;
    public TextView kvw;
    public TextView kvx;
    public View kvy;
    public View kvz;

    public HotRankListManualItemHolder(View view) {
        super(view);
        this.ajU = 3;
        this.kvu = null;
        this.kvv = null;
        this.kvw = null;
        this.kvx = null;
        this.kvy = null;
        this.kvz = null;
        this.kvA = null;
        this.kvB = null;
        this.kvu = (TextView) view.findViewById(R.id.topic_module);
        this.kvw = (TextView) view.findViewById(R.id.topic_desc);
        this.kvv = (TextView) view.findViewById(R.id.topic_title);
        this.kvA = (TbImageView) view.findViewById(R.id.topic_pic);
        this.kvy = view.findViewById(R.id.devide_line_top);
        this.kvz = view.findViewById(R.id.devide_line_bottom);
        this.kvB = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
