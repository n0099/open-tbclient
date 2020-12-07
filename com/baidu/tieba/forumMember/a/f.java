package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes23.dex */
public class f extends af.a {
    public View dividerLine;
    public TextView egV;
    public GodHeadImageView iOO;
    public TextView iOP;
    public TextView iOQ;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.iOO = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.iOO.setShapeType(0);
        this.iOO.setShowType(1);
        this.iOO.setRadius(14);
        this.egV = (TextView) view.findViewById(R.id.item_manito_name);
        this.iOP = (TextView) view.findViewById(R.id.item_manito_intro);
        this.iOQ = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
