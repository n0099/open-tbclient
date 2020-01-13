package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes8.dex */
public class f extends v.a {
    public int MH;
    public View dividerLine;
    public GroupImageView hxP;
    public TextView hxQ;
    public TextView hxR;
    public TextView hxS;
    public TextView hxT;
    public ImageView hxU;
    public ImageView hxV;
    public ImageView hxW;
    public ImageView[] hxX;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.MH = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.hxP = (GroupImageView) view.findViewById(R.id.item_head);
        this.hxQ = (TextView) view.findViewById(R.id.item_group_name);
        this.hxR = (TextView) view.findViewById(R.id.item_group_meizi);
        this.hxS = (TextView) view.findViewById(R.id.item_group_num);
        this.hxT = (TextView) view.findViewById(R.id.item_introduce);
        this.hxU = (ImageView) view.findViewById(R.id.item_grade1);
        this.hxV = (ImageView) view.findViewById(R.id.item_grade2);
        this.hxW = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.hxX = new ImageView[4];
        this.hxX[1] = this.hxU;
        this.hxX[2] = this.hxV;
        this.hxX[3] = this.hxW;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.hxP.setTag(null);
            this.hxP.setDrawBorder(true);
            this.hxP.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.hxP.setTag(portrait);
                this.hxP.startLoad(portrait, 10, false);
            }
            this.hxQ.setText(groupInfoData.getName());
            this.hxR.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.hxS.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.hxT.setText(groupInfoData.getIntro().trim());
            a(this.hxX, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.hxQ, R.color.common_color_10009, 1);
                am.setImageResource(this.hxU, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hxV, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hxW, R.drawable.icon_vip_grade_big_small_s);
            }
        }
    }

    private void a(ImageView[] imageViewArr, int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 3) {
            i2 = 3;
        }
        int i3 = 1;
        while (i3 <= i2) {
            imageViewArr[i3].setVisibility(0);
            i3++;
        }
        for (int i4 = i3; i4 <= 3; i4++) {
            imageViewArr[i4].setVisibility(8);
        }
    }
}
