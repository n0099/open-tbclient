package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends ad.a {
    public View dividerLine;
    public TextView djl;
    public GodHeadImageView hvH;
    public TextView hvI;
    public TextView hvJ;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.hvH = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.hvH.setShapeType(0);
        this.hvH.setShowType(1);
        this.hvH.setRadius(14);
        this.djl = (TextView) view.findViewById(R.id.item_manito_name);
        this.hvI = (TextView) view.findViewById(R.id.item_manito_intro);
        this.hvJ = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
