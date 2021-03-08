package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ComplaintBarlordViewHolder extends TypeAdapter.ViewHolder {
    public RelativeLayout bND;
    public ImageView ifk;
    public View mLineView;
    public int mSkinType;
    public TextView mTitleView;

    public ComplaintBarlordViewHolder(View view) {
        super(view);
        this.mSkinType = 3;
        this.bND = (RelativeLayout) view.findViewById(R.id.bar_info_complaint_lay);
        this.mLineView = view.findViewById(R.id.info_complaint_diver_top);
        this.mTitleView = (TextView) view.findViewById(R.id.bar_info_complaint_tv);
        this.ifk = (ImageView) view.findViewById(R.id.bar_info_complaint_img);
    }
}
