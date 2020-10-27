package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes23.dex */
public class f extends af.a {
    public TextView dVL;
    public View dividerLine;
    public GodHeadImageView ixl;
    public TextView ixm;
    public TextView ixn;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.ixl = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.ixl.setShapeType(0);
        this.ixl.setShowType(1);
        this.ixl.setRadius(14);
        this.dVL = (TextView) view.findViewById(R.id.item_manito_name);
        this.ixm = (TextView) view.findViewById(R.id.item_manito_intro);
        this.ixn = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
