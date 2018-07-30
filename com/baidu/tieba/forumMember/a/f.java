package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public View bkw;
    public TextView bwj;
    public TextView cDY;
    public GodHeadImageView diN;
    public TextView diO;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.diN = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.diN.setShapeType(0);
        this.diN.setShowType(1);
        this.diN.setRadius(14);
        this.bwj = (TextView) view.findViewById(d.g.item_manito_name);
        this.cDY = (TextView) view.findViewById(d.g.item_manito_intro);
        this.diO = (TextView) view.findViewById(d.g.item_manito_fans);
        this.bkw = view.findViewById(d.g.divider_line);
    }
}
