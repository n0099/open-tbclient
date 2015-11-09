package com.baidu.tieba.hottopic.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends x.a {
    public TextView alD;
    public int arf;
    public TextView beo;
    public TextView bep;
    public BarImageView bqG;
    public TextView bqH;
    public TextView bqI;
    public TextView bqJ;
    public TextView bqK;
    public View line;

    public i(View view) {
        super(view);
        this.arf = 3;
        this.bqH = (TextView) view.findViewById(i.f.forum_name);
        this.bqG = (BarImageView) view.findViewById(i.f.forum_avatar);
        this.bqJ = (TextView) view.findViewById(i.f.member_num_label);
        this.bqI = (TextView) view.findViewById(i.f.post_num_label);
        this.bep = (TextView) view.findViewById(i.f.member_num);
        this.beo = (TextView) view.findViewById(i.f.post_num);
        this.alD = (TextView) view.findViewById(i.f.forum_content);
        this.bqK = (TextView) view.findViewById(i.f.forum_add_love);
        this.line = view.findViewById(i.f.forum_item_divider);
    }
}
