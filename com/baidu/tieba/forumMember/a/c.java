package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View dividerLine;
    public View dpv;
    public int mSkinType;
    public TextView title;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.dpv = view.findViewById(e.g.manito_header_top_divider_line);
        this.title = (TextView) view.findViewById(e.g.manito_header_title);
        this.dividerLine = view.findViewById(e.g.manito_header_divider_line);
    }
}
