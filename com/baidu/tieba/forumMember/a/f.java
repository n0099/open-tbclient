package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes23.dex */
public class f extends af.a {
    public View dividerLine;
    public TextView ebD;
    public GodHeadImageView iDi;
    public TextView iDj;
    public TextView iDk;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.iDi = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.iDi.setShapeType(0);
        this.iDi.setShowType(1);
        this.iDi.setRadius(14);
        this.ebD = (TextView) view.findViewById(R.id.item_manito_name);
        this.iDj = (TextView) view.findViewById(R.id.item_manito_intro);
        this.iDk = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
