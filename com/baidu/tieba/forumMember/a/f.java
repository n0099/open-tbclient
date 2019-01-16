package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bPV;
    public GodHeadImageView dHU;
    public TextView dHV;
    public TextView ddy;
    public View dividerLine;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dHU = (GodHeadImageView) view.findViewById(e.g.item_head);
        this.dHU.setShapeType(0);
        this.dHU.setShowType(1);
        this.dHU.setRadius(14);
        this.bPV = (TextView) view.findViewById(e.g.item_manito_name);
        this.ddy = (TextView) view.findViewById(e.g.item_manito_intro);
        this.dHV = (TextView) view.findViewById(e.g.item_manito_fans);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }
}
