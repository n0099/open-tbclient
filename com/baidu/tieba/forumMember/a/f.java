package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends v.a {
    public TextView cui;
    public View dividerLine;
    public GodHeadImageView gkI;
    public TextView gkJ;
    public TextView gkK;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.gkI = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.gkI.setShapeType(0);
        this.gkI.setShowType(1);
        this.gkI.setRadius(14);
        this.cui = (TextView) view.findViewById(R.id.item_manito_name);
        this.gkJ = (TextView) view.findViewById(R.id.item_manito_intro);
        this.gkK = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
