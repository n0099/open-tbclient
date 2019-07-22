package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView bmT;
    public View dividerLine;
    public TextView eHP;
    public GodHeadImageView fqe;
    public TextView fqf;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.fqe = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.fqe.setShapeType(0);
        this.fqe.setShowType(1);
        this.fqe.setRadius(14);
        this.bmT = (TextView) view.findViewById(R.id.item_manito_name);
        this.eHP = (TextView) view.findViewById(R.id.item_manito_intro);
        this.fqf = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
