package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes8.dex */
public class f extends v.a {
    public TextView cqf;
    public View dividerLine;
    public GodHeadImageView gis;
    public TextView git;
    public TextView giu;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.gis = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.gis.setShapeType(0);
        this.gis.setShowType(1);
        this.gis.setRadius(14);
        this.cqf = (TextView) view.findViewById(R.id.item_manito_name);
        this.git = (TextView) view.findViewById(R.id.item_manito_intro);
        this.giu = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
