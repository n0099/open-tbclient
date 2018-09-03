package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View cTH;
    public View dividerLine;
    public int mSkinType;
    public TextView title;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.cTH = view.findViewById(f.g.manito_header_top_divider_line);
        this.title = (TextView) view.findViewById(f.g.manito_header_title);
        this.dividerLine = view.findViewById(f.g.manito_header_divider_line);
    }
}
