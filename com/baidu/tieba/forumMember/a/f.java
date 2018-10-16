package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public TextView bKH;
    public TextView cSf;
    public View dividerLine;
    public GodHeadImageView dwG;
    public TextView dwH;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dwG = (GodHeadImageView) view.findViewById(e.g.item_head);
        this.dwG.setShapeType(0);
        this.dwG.setShowType(1);
        this.dwG.setRadius(14);
        this.bKH = (TextView) view.findViewById(e.g.item_manito_name);
        this.cSf = (TextView) view.findViewById(e.g.item_manito_intro);
        this.dwH = (TextView) view.findViewById(e.g.item_manito_fans);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }
}
