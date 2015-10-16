package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends x.a {
    public TextView aly;
    public int apS;
    public TextView bdJ;
    public TextView bdK;
    public BarImageView bqc;
    public TextView bqd;
    public TextView bqe;
    public TextView bqf;
    public TextView bqg;
    public View line;

    public i(View view) {
        super(view);
        this.apS = 3;
        this.bqd = (TextView) view.findViewById(i.f.forum_name);
        this.bqc = (BarImageView) view.findViewById(i.f.forum_avatar);
        this.bqf = (TextView) view.findViewById(i.f.member_num_label);
        this.bqe = (TextView) view.findViewById(i.f.post_num_label);
        this.bdK = (TextView) view.findViewById(i.f.member_num);
        this.bdJ = (TextView) view.findViewById(i.f.post_num);
        this.aly = (TextView) view.findViewById(i.f.forum_content);
        this.bqg = (TextView) view.findViewById(i.f.forum_add_love);
        this.line = view.findViewById(i.f.forum_item_divider);
    }
}
