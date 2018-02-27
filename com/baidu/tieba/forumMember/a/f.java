package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends r.a {
    public TextView bMS;
    public View bQf;
    public GodHeadImageView dBb;
    public TextView dBc;
    public TextView dbT;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dBb = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.dBb.setShapeType(0);
        this.dBb.setShowType(1);
        this.dBb.setRadius(14);
        this.bMS = (TextView) view.findViewById(d.g.item_manito_name);
        this.dbT = (TextView) view.findViewById(d.g.item_manito_intro);
        this.dBc = (TextView) view.findViewById(d.g.item_manito_fans);
        this.bQf = view.findViewById(d.g.divider_line);
    }
}
