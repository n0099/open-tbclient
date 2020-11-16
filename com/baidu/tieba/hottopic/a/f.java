package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class f extends af.a {
    public int ajv;
    public TextView gRJ;
    public View hFk;
    public BarImageView jRE;
    public TextView jRF;
    public TextView jRG;
    public TextView jRH;
    public TextView jRI;
    public TextView joR;
    public TextView joS;

    public f(View view) {
        super(view);
        this.ajv = 3;
        this.jRF = (TextView) view.findViewById(R.id.forum_name);
        this.jRE = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.jRH = (TextView) view.findViewById(R.id.member_num_label);
        this.jRG = (TextView) view.findViewById(R.id.post_num_label);
        this.joS = (TextView) view.findViewById(R.id.member_num);
        this.joR = (TextView) view.findViewById(R.id.post_num);
        this.gRJ = (TextView) view.findViewById(R.id.forum_content);
        this.jRI = (TextView) view.findViewById(R.id.forum_add_love);
        this.hFk = view.findViewById(R.id.forum_item_divider);
    }
}
