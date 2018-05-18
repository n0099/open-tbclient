package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View baf;
    public View cJU;
    public int mSkinType;
    public TextView title;

    public c(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.cJU = view2.findViewById(d.g.manito_header_top_divider_line);
        this.title = (TextView) view2.findViewById(d.g.manito_header_title);
        this.baf = view2.findViewById(d.g.manito_header_divider_line);
    }
}
