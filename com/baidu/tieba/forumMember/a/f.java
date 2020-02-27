package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends v.a {
    public TextView cug;
    public View dividerLine;
    public GodHeadImageView gkt;
    public TextView gku;
    public TextView gkv;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.gkt = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.gkt.setShapeType(0);
        this.gkt.setShowType(1);
        this.gkt.setRadius(14);
        this.cug = (TextView) view.findViewById(R.id.item_manito_name);
        this.gku = (TextView) view.findViewById(R.id.item_manito_intro);
        this.gkv = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
