package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c extends v.a {
    public int mSkinType;
    public TextView title;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.title = (TextView) view.findViewById(d.g.manito_header_title);
    }
}
