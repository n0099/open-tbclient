package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View acP;
    public RelativeLayout cIJ;
    public ImageView ccP;
    public int mSkinType;
    public TextView mTitleView;

    public c(View view2) {
        super(view2);
        this.mSkinType = 3;
        this.cIJ = (RelativeLayout) view2.findViewById(d.g.bar_info_complaint_lay);
        this.acP = view2.findViewById(d.g.info_complaint_diver_top);
        this.mTitleView = (TextView) view2.findViewById(d.g.bar_info_complaint_tv);
        this.ccP = (ImageView) view2.findViewById(d.g.bar_info_complaint_img);
    }
}
