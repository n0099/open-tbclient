package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends x.a {
    public int ahU;
    public TextView bLH;
    public TextView bLI;
    public TextView bLJ;
    public TextView bLK;
    public View bLL;
    public View bLM;
    public TbImageView bLN;
    public LinearLayout bLO;

    public a(View view) {
        super(view);
        this.ahU = 3;
        this.bLH = null;
        this.bLI = null;
        this.bLJ = null;
        this.bLK = null;
        this.bLL = null;
        this.bLM = null;
        this.bLN = null;
        this.bLO = null;
        this.bLH = (TextView) view.findViewById(t.g.topic_module);
        this.bLJ = (TextView) view.findViewById(t.g.topic_desc);
        this.bLI = (TextView) view.findViewById(t.g.topic_title);
        this.bLN = (TbImageView) view.findViewById(t.g.topic_pic);
        this.bLL = view.findViewById(t.g.devide_line_top);
        this.bLM = view.findViewById(t.g.devide_line_bottom);
        this.bLO = (LinearLayout) view.findViewById(t.g.topic_manual_item);
    }
}
