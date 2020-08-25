package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes17.dex */
public class f extends af.a {
    public View dividerLine;
    public TextView dzi;
    public GodHeadImageView hOI;
    public TextView hOJ;
    public TextView hOK;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.hOI = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.hOI.setShapeType(0);
        this.hOI.setShowType(1);
        this.hOI.setRadius(14);
        this.dzi = (TextView) view.findViewById(R.id.item_manito_name);
        this.hOJ = (TextView) view.findViewById(R.id.item_manito_intro);
        this.hOK = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
