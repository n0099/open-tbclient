package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public View bjR;
    public TextView bvD;
    public TextView cBt;
    public GodHeadImageView dfX;
    public TextView dfY;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dfX = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.dfX.setShapeType(0);
        this.dfX.setShowType(1);
        this.dfX.setRadius(14);
        this.bvD = (TextView) view.findViewById(d.g.item_manito_name);
        this.cBt = (TextView) view.findViewById(d.g.item_manito_intro);
        this.dfY = (TextView) view.findViewById(d.g.item_manito_fans);
        this.bjR = view.findViewById(d.g.divider_line);
    }
}
