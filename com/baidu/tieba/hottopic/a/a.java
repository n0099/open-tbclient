package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a extends af.a {
    public int aiD;
    public TextView jap;
    public TextView jaq;
    public TextView jar;
    public TextView jas;
    public View jat;
    public View jau;
    public TbImageView jav;
    public LinearLayout jaw;

    public a(View view) {
        super(view);
        this.aiD = 3;
        this.jap = null;
        this.jaq = null;
        this.jar = null;
        this.jas = null;
        this.jat = null;
        this.jau = null;
        this.jav = null;
        this.jaw = null;
        this.jap = (TextView) view.findViewById(R.id.topic_module);
        this.jar = (TextView) view.findViewById(R.id.topic_desc);
        this.jaq = (TextView) view.findViewById(R.id.topic_title);
        this.jav = (TbImageView) view.findViewById(R.id.topic_pic);
        this.jat = view.findViewById(R.id.devide_line_top);
        this.jau = view.findViewById(R.id.devide_line_bottom);
        this.jaw = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
