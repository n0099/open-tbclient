package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bLs;
    public TextView cTl;
    public View dividerLine;
    public GodHeadImageView dxY;
    public TextView dxZ;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dxY = (GodHeadImageView) view.findViewById(e.g.item_head);
        this.dxY.setShapeType(0);
        this.dxY.setShowType(1);
        this.dxY.setRadius(14);
        this.bLs = (TextView) view.findViewById(e.g.item_manito_name);
        this.cTl = (TextView) view.findViewById(e.g.item_manito_intro);
        this.dxZ = (TextView) view.findViewById(e.g.item_manito_fans);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }
}
