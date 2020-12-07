package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends af.a {
    public int aku;
    public View hOR;
    public TextView haW;
    public TextView jCt;
    public TextView jCu;
    public BarImageView kfi;
    public TextView kfj;
    public TextView kfk;
    public TextView kfl;
    public TextView kfm;

    public f(View view) {
        super(view);
        this.aku = 3;
        this.kfj = (TextView) view.findViewById(R.id.forum_name);
        this.kfi = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.kfl = (TextView) view.findViewById(R.id.member_num_label);
        this.kfk = (TextView) view.findViewById(R.id.post_num_label);
        this.jCu = (TextView) view.findViewById(R.id.member_num);
        this.jCt = (TextView) view.findViewById(R.id.post_num);
        this.haW = (TextView) view.findViewById(R.id.forum_content);
        this.kfm = (TextView) view.findViewById(R.id.forum_add_love);
        this.hOR = view.findViewById(R.id.forum_item_divider);
    }
}
