package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes7.dex */
public class f extends v.a {
    public TextView cpT;
    public View dividerLine;
    public GodHeadImageView gfi;
    public TextView gfj;
    public TextView gfk;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.gfi = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.gfi.setShapeType(0);
        this.gfi.setShowType(1);
        this.gfi.setRadius(14);
        this.cpT = (TextView) view.findViewById(R.id.item_manito_name);
        this.gfj = (TextView) view.findViewById(R.id.item_manito_intro);
        this.gfk = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
