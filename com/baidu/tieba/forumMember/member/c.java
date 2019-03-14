package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c extends v.a {
    public View bER;
    public RelativeLayout eCv;
    public ImageView ear;
    public int mSkinType;
    public TextView mTitleView;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.eCv = (RelativeLayout) view.findViewById(d.g.bar_info_complaint_lay);
        this.bER = view.findViewById(d.g.info_complaint_diver_top);
        this.mTitleView = (TextView) view.findViewById(d.g.bar_info_complaint_tv);
        this.ear = (ImageView) view.findViewById(d.g.bar_info_complaint_img);
    }
}
