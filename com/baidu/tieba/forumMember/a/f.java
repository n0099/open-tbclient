package com.baidu.tieba.forumMember.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes22.dex */
public class f extends af.a {
    public TextView dBn;
    public View dividerLine;
    public GodHeadImageView hVO;
    public TextView hVP;
    public TextView hVQ;
    public int mSkinType;

    public f(View view) {
        super(view);
        this.mSkinType = 3;
        this.hVO = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.hVO.setShapeType(0);
        this.hVO.setShowType(1);
        this.hVO.setRadius(14);
        this.dBn = (TextView) view.findViewById(R.id.item_manito_name);
        this.hVP = (TextView) view.findViewById(R.id.item_manito_intro);
        this.hVQ = (TextView) view.findViewById(R.id.item_manito_fans);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }
}
