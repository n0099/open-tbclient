package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView bFm;
    public View dividerLine;
    public TextView eRt;
    public GodHeadImageView fqM;
    public TextView fqN;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.fqM = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.fqM.setShapeType(0);
        this.fqM.setShowType(1);
        this.fqM.setRadius(14);
        this.bFm = (TextView) view.findViewById(R.id.item_manito_name);
        this.eRt = (TextView) view.findViewById(R.id.item_manito_intro);
        this.fqN = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
