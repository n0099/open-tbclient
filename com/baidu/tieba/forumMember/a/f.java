package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView dfp;
    public View dividerLine;
    public GodHeadImageView eUV;
    public TextView eUW;
    public TextView eni;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.eUV = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.eUV.setShapeType(0);
        this.eUV.setShowType(1);
        this.eUV.setRadius(14);
        this.dfp = (TextView) view.findViewById(d.g.item_manito_name);
        this.eni = (TextView) view.findViewById(d.g.item_manito_intro);
        this.eUW = (TextView) view.findViewById(d.g.item_manito_fans);
        this.dividerLine = view.findViewById(d.g.divider_line);
    }
}
