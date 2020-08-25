package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class a extends af.a {
    public int aiB;
    public TextView jaj;
    public TextView jak;
    public TextView jal;
    public TextView jam;
    public View jan;
    public View jao;
    public TbImageView jap;
    public LinearLayout jaq;

    public a(View view) {
        super(view);
        this.aiB = 3;
        this.jaj = null;
        this.jak = null;
        this.jal = null;
        this.jam = null;
        this.jan = null;
        this.jao = null;
        this.jap = null;
        this.jaq = null;
        this.jaj = (TextView) view.findViewById(R.id.topic_module);
        this.jal = (TextView) view.findViewById(R.id.topic_desc);
        this.jak = (TextView) view.findViewById(R.id.topic_title);
        this.jap = (TbImageView) view.findViewById(R.id.topic_pic);
        this.jan = view.findViewById(R.id.devide_line_top);
        this.jao = view.findViewById(R.id.devide_line_bottom);
        this.jaq = (LinearLayout) view.findViewById(R.id.topic_manual_item);
    }
}
