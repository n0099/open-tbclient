package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView dfk;
    public View dividerLine;
    public GodHeadImageView eVi;
    public TextView eVj;
    public TextView enw;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.eVi = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.eVi.setShapeType(0);
        this.eVi.setShowType(1);
        this.eVi.setRadius(14);
        this.dfk = (TextView) view.findViewById(d.g.item_manito_name);
        this.enw = (TextView) view.findViewById(d.g.item_manito_intro);
        this.eVj = (TextView) view.findViewById(d.g.item_manito_fans);
        this.dividerLine = view.findViewById(d.g.divider_line);
    }
}
