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
    public TextView jQq;
    public TextView jQr;
    public TextView jQs;
    public TextView jQt;
    public View jQu;
    public View jQv;
    public TbImageView jQw;
    public LinearLayout jQx;

    public a(View view) {
        super(view);
        this.ajq = 3;
        this.jQq = null;
        this.jQr = null;
        this.jQs = null;
        this.jQt = null;
        this.jQu = null;
        this.jQv = null;
        this.jQw = null;
        this.jQx = null;
        this.jQq = (TextView) view.findViewById(R.id.topic_module);
        this.jQs = (TextView) view.findViewById(R.id.topic_desc);
        this.jQr = (TextView) view.findViewById(R.id.topic_title);
        this.jQw = (TbImageView) view.findViewById(R.id.topic_pic);
        this.jQu = view.findViewById(R.id.devide_line_top);
        this.jQv = view.findViewById(R.id.devide_line_bottom);
        this.jQx = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
