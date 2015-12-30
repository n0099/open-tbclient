package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class g extends x.a {
    public int ahf;
    public TextView aoy;
    public BarImageView bIN;
    public TextView bIP;
    public TextView bIU;
    public TextView bIV;
    public TextView bIW;
    public TextView boK;
    public TextView boL;
    public View line;

    public g(View view) {
        super(view);
        this.ahf = 3;
        this.bIP = (TextView) view.findViewById(n.g.forum_name);
        this.bIN = (BarImageView) view.findViewById(n.g.forum_avatar);
        this.bIW = (TextView) view.findViewById(n.g.member_num_label);
        this.bIV = (TextView) view.findViewById(n.g.post_num_label);
        this.boL = (TextView) view.findViewById(n.g.member_num);
        this.boK = (TextView) view.findViewById(n.g.post_num);
        this.aoy = (TextView) view.findViewById(n.g.forum_content);
        this.bIU = (TextView) view.findViewById(n.g.forum_add_love);
        this.line = view.findViewById(n.g.forum_item_divider);
    }
}
