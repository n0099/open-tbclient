package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends r.a {
    public TextView bNf;
    public View bQs;
    public GodHeadImageView dBn;
    public TextView dBo;
    public TextView dcf;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.dBn = (GodHeadImageView) view.findViewById(d.g.item_head);
        this.dBn.setShapeType(0);
        this.dBn.setShowType(1);
        this.dBn.setRadius(14);
        this.bNf = (TextView) view.findViewById(d.g.item_manito_name);
        this.dcf = (TextView) view.findViewById(d.g.item_manito_intro);
        this.dBo = (TextView) view.findViewById(d.g.item_manito_fans);
        this.bQs = view.findViewById(d.g.divider_line);
    }
}
