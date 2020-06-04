package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c extends aa.a {
    public RelativeLayout bej;
    public ImageView gst;
    public View mLineView;
    public int mSkinType;
    public TextView mTitleView;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.bej = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.mLineView = view.findViewById(R.id.info_complaint_diver_top);
        this.mTitleView = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.gst = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
