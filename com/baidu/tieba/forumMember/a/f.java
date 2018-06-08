package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public View bir;
    public TextView bui;
    public TextView cDz;
    public GodHeadImageView def;
    public TextView deg;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.def = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.def.setShapeType(0);
        this.def.setShowType(1);
        this.def.setRadius(14);
        this.bui = (TextView) view.findViewById(d.g.item_manito_name);
        this.cDz = (TextView) view.findViewById(d.g.item_manito_intro);
        this.deg = (TextView) view.findViewById(d.g.item_manito_fans);
        this.bir = view.findViewById(d.g.divider_line);
    }
}
