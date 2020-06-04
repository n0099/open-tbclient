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
    public TextView hjA;
    public TextView hjB;
    public GodHeadImageView hjz;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.hjz = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.hjz.setShapeType(0);
        this.hjz.setShowType(1);
        this.hjz.setRadius(14);
        this.dez = (TextView) view.findViewById(R.id.item_manito_name);
        this.hjA = (TextView) view.findViewById(R.id.item_manito_intro);
        this.hjB = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
