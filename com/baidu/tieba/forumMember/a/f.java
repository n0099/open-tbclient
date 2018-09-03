package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bwl;
    public TextView cDV;
    public GodHeadImageView diL;
    public TextView diM;
    public View dividerLine;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.diL = (GodHeadImageView) view.findViewById(f.g.item_head);
        this.diL.setShapeType(0);
        this.diL.setShowType(1);
        this.diL.setRadius(14);
        this.bwl = (TextView) view.findViewById(f.g.item_manito_name);
        this.cDV = (TextView) view.findViewById(f.g.item_manito_intro);
        this.diM = (TextView) view.findViewById(f.g.item_manito_fans);
        this.dividerLine = view.findViewById(f.g.divider_line);
    }
}
