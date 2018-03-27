package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends r.a {
    public TextView bMV;
    public View bQi;
    public GodHeadImageView dBe;
    public TextView dBf;
    public TextView dbW;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dBe = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.dBe.setShapeType(0);
        this.dBe.setShowType(1);
        this.dBe.setRadius(14);
        this.bMV = (TextView) view.findViewById(d.g.item_manito_name);
        this.dbW = (TextView) view.findViewById(d.g.item_manito_intro);
        this.dBf = (TextView) view.findViewById(d.g.item_manito_fans);
        this.bQi = view.findViewById(d.g.divider_line);
    }
}
