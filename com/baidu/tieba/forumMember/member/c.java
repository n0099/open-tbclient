package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends q.a {
    public View akS;
    public RelativeLayout cSx;
    public ImageView coY;
    public int mSkinType;
    public TextView mTitleView;

    public c(View view) {
        super(view);
        this.mSkinType = 3;
        this.cSx = (RelativeLayout) view.findViewById(f.g.bar_info_complaint_lay);
        this.akS = view.findViewById(f.g.info_complaint_diver_top);
        this.mTitleView = (TextView) view.findViewById(f.g.bar_info_complaint_tv);
        this.coY = (ImageView) view.findViewById(f.g.bar_info_complaint_img);
    }
}
