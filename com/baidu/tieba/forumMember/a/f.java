package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes5.dex */
public class f extends v.a {
    public TextView bmf;
    public View dividerLine;
    public TextView eCT;
    public GodHeadImageView flg;
    public TextView flh;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.flg = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.flg.setShapeType(0);
        this.flg.setShowType(1);
        this.flg.setRadius(14);
        this.bmf = (TextView) view.findViewById(R.id.item_manito_name);
        this.eCT = (TextView) view.findViewById(R.id.item_manito_intro);
        this.flh = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
