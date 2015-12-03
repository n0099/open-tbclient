package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class g extends x.a {
    public int afY;
    public TextView ano;
    public TextView bAL;
    public BarImageView bFh;
    public TextView bFn;
    public TextView bFo;
    public TextView bFp;
    public TextView bkT;
    public TextView bkU;
    public View line;

    public g(View view) {
        super(view);
        this.afY = 3;
        this.bAL = (TextView) view.findViewById(n.f.forum_name);
        this.bFh = (BarImageView) view.findViewById(n.f.forum_avatar);
        this.bFp = (TextView) view.findViewById(n.f.member_num_label);
        this.bFo = (TextView) view.findViewById(n.f.post_num_label);
        this.bkU = (TextView) view.findViewById(n.f.member_num);
        this.bkT = (TextView) view.findViewById(n.f.post_num);
        this.ano = (TextView) view.findViewById(n.f.forum_content);
        this.bFn = (TextView) view.findViewById(n.f.forum_add_love);
        this.line = view.findViewById(n.f.forum_item_divider);
    }
}
