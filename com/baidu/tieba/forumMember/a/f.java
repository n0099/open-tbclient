package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bPW;
    public GodHeadImageView dHV;
    public TextView dHW;
    public TextView ddz;
    public View dividerLine;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dHV = (GodHeadImageView) view.findViewById(e.g.item_head);
        this.dHV.setShapeType(0);
        this.dHV.setShowType(1);
        this.dHV.setRadius(14);
        this.bPW = (TextView) view.findViewById(e.g.item_manito_name);
        this.ddz = (TextView) view.findViewById(e.g.item_manito_intro);
        this.dHW = (TextView) view.findViewById(e.g.item_manito_fans);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }
}
