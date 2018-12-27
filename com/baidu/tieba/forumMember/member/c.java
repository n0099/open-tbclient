package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View awG;
    public ImageView cMi;
    public RelativeLayout drh;
    public int mSkinType;
    public TextView mTitleView;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.drh = (RelativeLayout) view.findViewById(e.g.bar_info_complaint_lay);
        this.awG = view.findViewById(e.g.info_complaint_diver_top);
        this.mTitleView = (TextView) view.findViewById(e.g.bar_info_complaint_tv);
        this.cMi = (ImageView) view.findViewById(e.g.bar_info_complaint_img);
    }
}
