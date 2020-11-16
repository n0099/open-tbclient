package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class a extends af.a {
    public int ajv;
    public TextView jRa;
    public TextView jRb;
    public TextView jRc;
    public TextView jRd;
    public View jRe;
    public View jRf;
    public TbImageView jRg;
    public LinearLayout jRh;

    public a(View view) {
        super(view);
        this.ajv = 3;
        this.jRa = null;
        this.jRb = null;
        this.jRc = null;
        this.jRd = null;
        this.jRe = null;
        this.jRf = null;
        this.jRg = null;
        this.jRh = null;
        this.jRa = (TextView) view.findViewById(R.id.topic_module);
        this.jRc = (TextView) view.findViewById(R.id.topic_desc);
        this.jRb = (TextView) view.findViewById(R.id.topic_title);
        this.jRg = (TbImageView) view.findViewById(R.id.topic_pic);
        this.jRe = view.findViewById(R.id.devide_line_top);
        this.jRf = view.findViewById(R.id.devide_line_bottom);
        this.jRh = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
