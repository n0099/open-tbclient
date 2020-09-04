package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes17.dex */
public class f extends af.a {
    public View dividerLine;
    public TextView dzm;
    public GodHeadImageView hOO;
    public TextView hOP;
    public TextView hOQ;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.hOO = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.hOO.setShapeType(0);
        this.hOO.setShowType(1);
        this.hOO.setRadius(14);
        this.dzm = (TextView) view.findViewById(R.id.item_manito_name);
        this.hOP = (TextView) view.findViewById(R.id.item_manito_intro);
        this.hOQ = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
