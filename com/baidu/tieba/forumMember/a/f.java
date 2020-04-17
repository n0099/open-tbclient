package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends y.a {
    public TextView cTr;
    public View dividerLine;
    public GodHeadImageView gUw;
    public TextView gUx;
    public TextView gUy;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.gUw = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.gUw.setShapeType(0);
        this.gUw.setShowType(1);
        this.gUw.setRadius(14);
        this.cTr = (TextView) view.findViewById(R.id.item_manito_name);
        this.gUx = (TextView) view.findViewById(R.id.item_manito_intro);
        this.gUy = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
