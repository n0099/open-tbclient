package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes17.dex */
public class f extends ad.a {
    public View dividerLine;
    public TextView dpg;
    public GodHeadImageView hBt;
    public TextView hBu;
    public TextView hBv;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.hBt = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.hBt.setShapeType(0);
        this.hBt.setShowType(1);
        this.hBt.setRadius(14);
        this.dpg = (TextView) view.findViewById(R.id.item_manito_name);
        this.hBu = (TextView) view.findViewById(R.id.item_manito_intro);
        this.hBv = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
