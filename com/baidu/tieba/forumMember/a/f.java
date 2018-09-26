package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bCa;
    public TextView cJM;
    public View dividerLine;
    public GodHeadImageView doE;
    public TextView doF;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.doE = (GodHeadImageView) view.findViewById(e.g.item_head);
        this.doE.setShapeType(0);
        this.doE.setShowType(1);
        this.doE.setRadius(14);
        this.bCa = (TextView) view.findViewById(e.g.item_manito_name);
        this.cJM = (TextView) view.findViewById(e.g.item_manito_intro);
        this.doF = (TextView) view.findViewById(e.g.item_manito_fans);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }
}
