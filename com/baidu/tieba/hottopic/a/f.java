package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class f extends ad.a {
    public int aho;
    public View gIw;
    public BarImageView iLP;
    public TextView iLQ;
    public TextView iLR;
    public TextView iLS;
    public TextView iLT;
    public TextView iLU;
    public TextView ilq;
    public TextView ilr;

    public f(View view) {
        super(view);
        this.aho = 3;
        this.iLQ = (TextView) view.findViewById(R.id.forum_name);
        this.iLP = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.iLS = (TextView) view.findViewById(R.id.member_num_label);
        this.iLR = (TextView) view.findViewById(R.id.post_num_label);
        this.ilr = (TextView) view.findViewById(R.id.member_num);
        this.ilq = (TextView) view.findViewById(R.id.post_num);
        this.iLT = (TextView) view.findViewById(R.id.forum_content);
        this.iLU = (TextView) view.findViewById(R.id.forum_add_love);
        this.gIw = view.findViewById(R.id.forum_item_divider);
    }
}
