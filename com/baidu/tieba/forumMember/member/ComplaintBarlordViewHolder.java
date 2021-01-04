package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ComplaintBarlordViewHolder extends TypeAdapter.ViewHolder {
    public RelativeLayout bNf;
    public ImageView idA;
    public View mLineView;
    public int mSkinType;
    public TextView mTitleView;

    public ComplaintBarlordViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.bNf = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.mLineView = view.findViewById(R.id.info_complaint_diver_top);
        this.mTitleView = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.idA = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
