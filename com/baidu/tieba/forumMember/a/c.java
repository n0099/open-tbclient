package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View bir;
    public View cTa;
    public int mSkinType;
    public TextView title;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.cTa = view.findViewById(d.g.manito_header_top_divider_line);
        this.title = (TextView) view.findViewById(d.g.manito_header_title);
        this.bir = view.findViewById(d.g.manito_header_divider_line);
    }
}
