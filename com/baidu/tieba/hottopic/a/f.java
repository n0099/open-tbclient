package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class f extends af.a {
    public int aiD;
    public View gVd;
    public TextView izA;
    public TextView izz;
    public BarImageView jaT;
    public TextView jaU;
    public TextView jaV;
    public TextView jaW;
    public TextView jaX;
    public TextView jaY;

    public f(View view) {
        super(view);
        this.aiD = 3;
        this.jaU = (TextView) view.findViewById(R.id.forum_name);
        this.jaT = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.jaW = (TextView) view.findViewById(R.id.member_num_label);
        this.jaV = (TextView) view.findViewById(R.id.post_num_label);
        this.izA = (TextView) view.findViewById(R.id.member_num);
        this.izz = (TextView) view.findViewById(R.id.post_num);
        this.jaX = (TextView) view.findViewById(R.id.forum_content);
        this.jaY = (TextView) view.findViewById(R.id.forum_add_love);
        this.gVd = view.findViewById(R.id.forum_item_divider);
    }
}
