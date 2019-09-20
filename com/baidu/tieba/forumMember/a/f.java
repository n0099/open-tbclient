package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView bnr;
    public View dividerLine;
    public TextView eJF;
    public GodHeadImageView fsr;
    public TextView fss;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.fsr = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.fsr.setShapeType(0);
        this.fsr.setShowType(1);
        this.fsr.setRadius(14);
        this.bnr = (TextView) view.findViewById(R.id.item_manito_name);
        this.eJF = (TextView) view.findViewById(R.id.item_manito_intro);
        this.fss = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
