package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends x.a {
    public TextView alx;
    public int apR;
    public TextView bdy;
    public TextView bdz;
    public BarImageView bpR;
    public TextView bpS;
    public TextView bpT;
    public TextView bpU;
    public TextView bpV;
    public View line;

    public i(View view) {
        super(view);
        this.apR = 3;
        this.bpS = (TextView) view.findViewById(i.f.forum_name);
        this.bpR = (BarImageView) view.findViewById(i.f.forum_avatar);
        this.bpU = (TextView) view.findViewById(i.f.member_num_label);
        this.bpT = (TextView) view.findViewById(i.f.post_num_label);
        this.bdz = (TextView) view.findViewById(i.f.member_num);
        this.bdy = (TextView) view.findViewById(i.f.post_num);
        this.alx = (TextView) view.findViewById(i.f.forum_content);
        this.bpV = (TextView) view.findViewById(i.f.forum_add_love);
        this.line = view.findViewById(i.f.forum_item_divider);
    }
}
