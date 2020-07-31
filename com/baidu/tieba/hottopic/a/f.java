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
    public BarImageView iLN;
    public TextView iLO;
    public TextView iLP;
    public TextView iLQ;
    public TextView iLR;
    public TextView iLS;
    public TextView ilo;
    public TextView ilp;

    public f(View view) {
        super(view);
        this.aho = 3;
        this.iLO = (TextView) view.findViewById(R.id.forum_name);
        this.iLN = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.iLQ = (TextView) view.findViewById(R.id.member_num_label);
        this.iLP = (TextView) view.findViewById(R.id.post_num_label);
        this.ilp = (TextView) view.findViewById(R.id.member_num);
        this.ilo = (TextView) view.findViewById(R.id.post_num);
        this.iLR = (TextView) view.findViewById(R.id.forum_content);
        this.iLS = (TextView) view.findViewById(R.id.forum_add_love);
        this.gIw = view.findViewById(R.id.forum_item_divider);
    }
}
