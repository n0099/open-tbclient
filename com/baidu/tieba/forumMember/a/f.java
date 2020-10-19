package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes23.dex */
public class f extends af.a {
    public TextView dNo;
    public View dividerLine;
    public GodHeadImageView ikN;
    public TextView ikO;
    public TextView ikP;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.ikN = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.ikN.setShapeType(0);
        this.ikN.setShowType(1);
        this.ikN.setRadius(14);
        this.dNo = (TextView) view.findViewById(R.id.item_manito_name);
        this.ikO = (TextView) view.findViewById(R.id.item_manito_intro);
        this.ikP = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
