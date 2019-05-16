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
    public TextView eCS;
    public GodHeadImageView flf;
    public TextView flg;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.flf = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.flf.setShapeType(0);
        this.flf.setShowType(1);
        this.flf.setRadius(14);
        this.bmf = (TextView) view.findViewById(R.id.item_manito_name);
        this.eCS = (TextView) view.findViewById(R.id.item_manito_intro);
        this.flg = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
