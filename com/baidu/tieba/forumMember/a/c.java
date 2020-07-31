package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class c extends ad.a {
    public int mSkinType;
    public TextView title;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.title = (TextView) view.findViewById(R.id.manito_header_title);
    }
}
