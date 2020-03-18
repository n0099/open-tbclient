package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends v.a {
    public TextView cuv;
    public View dividerLine;
    public GodHeadImageView glq;
    public TextView glr;
    public TextView gls;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.glq = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.glq.setShapeType(0);
        this.glq.setShowType(1);
        this.glq.setRadius(14);
        this.cuv = (TextView) view.findViewById(R.id.item_manito_name);
        this.glr = (TextView) view.findViewById(R.id.item_manito_intro);
        this.gls = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
