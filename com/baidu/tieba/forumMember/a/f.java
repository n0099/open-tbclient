package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bPk;
    public GodHeadImageView dHl;
    public TextView dHm;
    public TextView dcL;
    public View dividerLine;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dHl = (GodHeadImageView) view.findViewById(e.g.item_head);
        this.dHl.setShapeType(0);
        this.dHl.setShowType(1);
        this.dHl.setRadius(14);
        this.bPk = (TextView) view.findViewById(e.g.item_manito_name);
        this.dcL = (TextView) view.findViewById(e.g.item_manito_intro);
        this.dHm = (TextView) view.findViewById(e.g.item_manito_fans);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }
}
