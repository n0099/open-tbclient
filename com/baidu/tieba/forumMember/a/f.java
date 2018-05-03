package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes3.dex */
public class f extends q.a {
    public View bae;
    public TextView blN;
    public GodHeadImageView cTN;
    public TextView cTO;
    public TextView ctM;
    public int mSkinType;

    public f(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.cTN = (GodHeadImageView) view2.findViewById(d.g.item_head);
        this.cTN.setShapeType(0);
        this.cTN.setShowType(1);
        this.cTN.setRadius(14);
        this.blN = (TextView) view2.findViewById(d.g.item_manito_name);
        this.ctM = (TextView) view2.findViewById(d.g.item_manito_intro);
        this.cTO = (TextView) view2.findViewById(d.g.item_manito_fans);
        this.bae = view2.findViewById(d.g.divider_line);
    }
}
