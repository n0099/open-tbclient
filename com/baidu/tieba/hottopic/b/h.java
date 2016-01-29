package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends x.a {
    public View aHm;
    public int ahU;
    public TextView apr;
    public TextView bMA;
    public BarImageView bMw;
    public TextView bMx;
    public TextView bMy;
    public TextView bMz;
    public TextView brH;
    public TextView brI;

    public h(View view) {
        super(view);
        this.ahU = 3;
        this.bMx = (TextView) view.findViewById(t.g.forum_name);
        this.bMw = (BarImageView) view.findViewById(t.g.forum_avatar);
        this.bMz = (TextView) view.findViewById(t.g.member_num_label);
        this.bMy = (TextView) view.findViewById(t.g.post_num_label);
        this.brI = (TextView) view.findViewById(t.g.member_num);
        this.brH = (TextView) view.findViewById(t.g.post_num);
        this.apr = (TextView) view.findViewById(t.g.forum_content);
        this.bMA = (TextView) view.findViewById(t.g.forum_add_love);
        this.aHm = view.findViewById(t.g.forum_item_divider);
    }
}
