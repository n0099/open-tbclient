package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends af.a {
    public int ajp;
    public View hnL;
    public TextView iVK;
    public TextView iVL;
    public TextView jyA;
    public TextView jyB;
    public TextView jyC;
    public BarImageView jyx;
    public TextView jyy;
    public TextView jyz;

    public f(View view) {
        super(view);
        this.ajp = 3;
        this.jyy = (TextView) view.findViewById(R.id.forum_name);
        this.jyx = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.jyA = (TextView) view.findViewById(R.id.member_num_label);
        this.jyz = (TextView) view.findViewById(R.id.post_num_label);
        this.iVL = (TextView) view.findViewById(R.id.member_num);
        this.iVK = (TextView) view.findViewById(R.id.post_num);
        this.jyB = (TextView) view.findViewById(R.id.forum_content);
        this.jyC = (TextView) view.findViewById(R.id.forum_add_love);
        this.hnL = view.findViewById(R.id.forum_item_divider);
    }
}
