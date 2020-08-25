package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class f extends af.a {
    public int aiB;
    public View gUZ;
    public TextView izt;
    public TextView izu;
    public BarImageView jaN;
    public TextView jaO;
    public TextView jaP;
    public TextView jaQ;
    public TextView jaR;
    public TextView jaS;

    public f(View view) {
        super(view);
        this.aiB = 3;
        this.jaO = (TextView) view.findViewById(R.id.forum_name);
        this.jaN = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.jaQ = (TextView) view.findViewById(R.id.member_num_label);
        this.jaP = (TextView) view.findViewById(R.id.post_num_label);
        this.izu = (TextView) view.findViewById(R.id.member_num);
        this.izt = (TextView) view.findViewById(R.id.post_num);
        this.jaR = (TextView) view.findViewById(R.id.forum_content);
        this.jaS = (TextView) view.findViewById(R.id.forum_add_love);
        this.gUZ = view.findViewById(R.id.forum_item_divider);
    }
}
