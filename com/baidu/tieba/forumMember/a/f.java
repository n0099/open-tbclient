package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes22.dex */
public class f extends af.a {
    public TextView dZV;
    public View dividerLine;
    public GodHeadImageView iDW;
    public TextView iDX;
    public TextView iDY;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.iDW = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.iDW.setShapeType(0);
        this.iDW.setShowType(1);
        this.iDW.setRadius(14);
        this.dZV = (TextView) view.findViewById(R.id.item_manito_name);
        this.iDX = (TextView) view.findViewById(R.id.item_manito_intro);
        this.iDY = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
