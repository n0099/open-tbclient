package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends aa.a {
    public TextView dez;
    public View dividerLine;
    public GodHeadImageView hjo;
    public TextView hjp;
    public TextView hjq;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.hjo = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.hjo.setShapeType(0);
        this.hjo.setShowType(1);
        this.hjo.setRadius(14);
        this.dez = (TextView) view.findViewById(R.id.item_manito_name);
        this.hjp = (TextView) view.findViewById(R.id.item_manito_intro);
        this.hjq = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
