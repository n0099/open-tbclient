package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bPh;
    public TextView cZS;
    public GodHeadImageView dEx;
    public TextView dEy;
    public View dividerLine;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dEx = (GodHeadImageView) view.findViewById(e.g.item_head);
        this.dEx.setShapeType(0);
        this.dEx.setShowType(1);
        this.dEx.setRadius(14);
        this.bPh = (TextView) view.findViewById(e.g.item_manito_name);
        this.cZS = (TextView) view.findViewById(e.g.item_manito_intro);
        this.dEy = (TextView) view.findViewById(e.g.item_manito_fans);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }
}
