package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView dfo;
    public View dividerLine;
    public GodHeadImageView eUU;
    public TextView eUV;
    public TextView enh;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.eUU = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.eUU.setShapeType(0);
        this.eUU.setShowType(1);
        this.eUU.setRadius(14);
        this.dfo = (TextView) view.findViewById(d.g.item_manito_name);
        this.enh = (TextView) view.findViewById(d.g.item_manito_intro);
        this.eUV = (TextView) view.findViewById(d.g.item_manito_fans);
        this.dividerLine = view.findViewById(d.g.divider_line);
    }
}
