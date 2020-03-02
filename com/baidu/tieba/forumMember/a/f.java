package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends v.a {
    public TextView cuh;
    public View dividerLine;
    public GodHeadImageView gkv;
    public TextView gkw;
    public TextView gkx;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.gkv = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.gkv.setShapeType(0);
        this.gkv.setShowType(1);
        this.gkv.setRadius(14);
        this.cuh = (TextView) view.findViewById(R.id.item_manito_name);
        this.gkw = (TextView) view.findViewById(R.id.item_manito_intro);
        this.gkx = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
