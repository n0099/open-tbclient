package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a extends af.a {
    public int ajq;
    public TextView jKs;
    public TextView jKt;
    public TextView jKu;
    public TextView jKv;
    public View jKw;
    public View jKx;
    public TbImageView jKy;
    public LinearLayout jKz;

    public a(View view) {
        super(view);
        this.ajq = 3;
        this.jKs = null;
        this.jKt = null;
        this.jKu = null;
        this.jKv = null;
        this.jKw = null;
        this.jKx = null;
        this.jKy = null;
        this.jKz = null;
        this.jKs = (TextView) view.findViewById(R.id.topic_module);
        this.jKu = (TextView) view.findViewById(R.id.topic_desc);
        this.jKt = (TextView) view.findViewById(R.id.topic_title);
        this.jKy = (TbImageView) view.findViewById(R.id.topic_pic);
        this.jKw = view.findViewById(R.id.devide_line_top);
        this.jKx = view.findViewById(R.id.devide_line_bottom);
        this.jKz = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
