package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView bGd;
    public View dividerLine;
    public TextView eSk;
    public GodHeadImageView frE;
    public TextView frF;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.frE = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.frE.setShapeType(0);
        this.frE.setShowType(1);
        this.frE.setRadius(14);
        this.bGd = (TextView) view.findViewById(R.id.item_manito_name);
        this.eSk = (TextView) view.findViewById(R.id.item_manito_intro);
        this.frF = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
