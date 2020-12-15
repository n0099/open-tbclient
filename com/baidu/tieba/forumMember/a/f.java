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
    public GodHeadImageView iOQ;
    public TextView iOR;
    public TextView iOS;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.iOQ = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.iOQ.setShapeType(0);
        this.iOQ.setShowType(1);
        this.iOQ.setRadius(14);
        this.egV = (TextView) view.findViewById(R.id.item_manito_name);
        this.iOR = (TextView) view.findViewById(R.id.item_manito_intro);
        this.iOS = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
