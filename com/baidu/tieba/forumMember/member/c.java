package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View akT;
    public RelativeLayout cRQ;
    public ImageView ckS;
    public int mSkinType;
    public TextView mTitleView;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.cRQ = (RelativeLayout) view.findViewById(d.g.bar_info_complaint_lay);
        this.akT = view.findViewById(d.g.info_complaint_diver_top);
        this.mTitleView = (TextView) view.findViewById(d.g.bar_info_complaint_tv);
        this.ckS = (ImageView) view.findViewById(d.g.bar_info_complaint_img);
    }
}
