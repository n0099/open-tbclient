package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends af.a {
    public int ajq;
    public View hzG;
    public BarImageView jKW;
    public TextView jKX;
    public TextView jKY;
    public TextView jKZ;
    public TextView jLa;
    public TextView jLb;
    public TextView jih;
    public TextView jii;

    public f(View view) {
        super(view);
        this.ajq = 3;
        this.jKX = (TextView) view.findViewById(R.id.forum_name);
        this.jKW = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.jKZ = (TextView) view.findViewById(R.id.member_num_label);
        this.jKY = (TextView) view.findViewById(R.id.post_num_label);
        this.jii = (TextView) view.findViewById(R.id.member_num);
        this.jih = (TextView) view.findViewById(R.id.post_num);
        this.jLa = (TextView) view.findViewById(R.id.forum_content);
        this.jLb = (TextView) view.findViewById(R.id.forum_add_love);
        this.hzG = view.findViewById(R.id.forum_item_divider);
    }
}
