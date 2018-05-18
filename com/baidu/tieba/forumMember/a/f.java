package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public View baf;
    public TextView bmc;
    public GodHeadImageView cUU;
    public TextView cUV;
    public TextView cuW;
    public int mSkinType;

    public f(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.cUU = (GodHeadImageView) view2.findViewById(d.g.item_head);
        this.cUU.setShapeType(0);
        this.cUU.setShowType(1);
        this.cUU.setRadius(14);
        this.bmc = (TextView) view2.findViewById(d.g.item_manito_name);
        this.cuW = (TextView) view2.findViewById(d.g.item_manito_intro);
        this.cUV = (TextView) view2.findViewById(d.g.item_manito_fans);
        this.baf = view2.findViewById(d.g.divider_line);
    }
}
