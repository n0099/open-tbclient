package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class f extends af.a {
    public int aiX;
    public View gYK;
    public TextView iGU;
    public TextView iGV;
    public TextView jjA;
    public TextView jjB;
    public TextView jjC;
    public TextView jjD;
    public TextView jjE;
    public BarImageView jjz;

    public f(View view) {
        super(view);
        this.aiX = 3;
        this.jjA = (TextView) view.findViewById(R.id.forum_name);
        this.jjz = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.jjC = (TextView) view.findViewById(R.id.member_num_label);
        this.jjB = (TextView) view.findViewById(R.id.post_num_label);
        this.iGV = (TextView) view.findViewById(R.id.member_num);
        this.iGU = (TextView) view.findViewById(R.id.post_num);
        this.jjD = (TextView) view.findViewById(R.id.forum_content);
        this.jjE = (TextView) view.findViewById(R.id.forum_add_love);
        this.gYK = view.findViewById(R.id.forum_item_divider);
    }
}
