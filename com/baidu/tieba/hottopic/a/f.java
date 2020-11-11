package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends af.a {
    public int ajq;
    public TextView gSc;
    public View hFD;
    public BarImageView jQU;
    public TextView jQV;
    public TextView jQW;
    public TextView jQX;
    public TextView jQY;
    public TextView jof;
    public TextView jog;

    public f(View view) {
        super(view);
        this.ajq = 3;
        this.jQV = (TextView) view.findViewById(R.id.forum_name);
        this.jQU = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.jQX = (TextView) view.findViewById(R.id.member_num_label);
        this.jQW = (TextView) view.findViewById(R.id.post_num_label);
        this.jog = (TextView) view.findViewById(R.id.member_num);
        this.jof = (TextView) view.findViewById(R.id.post_num);
        this.gSc = (TextView) view.findViewById(R.id.forum_content);
        this.jQY = (TextView) view.findViewById(R.id.forum_add_love);
        this.hFD = view.findViewById(R.id.forum_item_divider);
    }
}
