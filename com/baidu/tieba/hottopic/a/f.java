package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends af.a {
    public int aku;
    public View hOT;
    public TextView haY;
    public TextView jCv;
    public TextView jCw;
    public BarImageView kfk;
    public TextView kfl;
    public TextView kfm;
    public TextView kfn;
    public TextView kfo;

    public f(View view) {
        super(view);
        this.aku = 3;
        this.kfl = (TextView) view.findViewById(R.id.forum_name);
        this.kfk = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.kfn = (TextView) view.findViewById(R.id.member_num_label);
        this.kfm = (TextView) view.findViewById(R.id.post_num_label);
        this.jCw = (TextView) view.findViewById(R.id.member_num);
        this.jCv = (TextView) view.findViewById(R.id.post_num);
        this.haY = (TextView) view.findViewById(R.id.forum_content);
        this.kfo = (TextView) view.findViewById(R.id.forum_add_love);
        this.hOT = view.findViewById(R.id.forum_item_divider);
    }
}
