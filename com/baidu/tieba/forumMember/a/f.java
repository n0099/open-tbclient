package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes10.dex */
public class f extends y.a {
    public TextView cTw;
    public View dividerLine;
    public GodHeadImageView gUC;
    public TextView gUD;
    public TextView gUE;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.gUC = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.gUC.setShapeType(0);
        this.gUC.setShowType(1);
        this.gUC.setRadius(14);
        this.cTw = (TextView) view.findViewById(R.id.item_manito_name);
        this.gUD = (TextView) view.findViewById(R.id.item_manito_intro);
        this.gUE = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
