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
/* loaded from: classes10.dex */
public class f extends v.a {
    public int Ni;
    public View dividerLine;
    public GroupImageView hzQ;
    public TextView hzR;
    public TextView hzS;
    public TextView hzT;
    public TextView hzU;
    public ImageView hzV;
    public ImageView hzW;
    public ImageView hzX;
    public ImageView[] hzY;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.Ni = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.hzQ = (GroupImageView) view.findViewById(R.id.item_head);
        this.hzR = (TextView) view.findViewById(R.id.item_group_name);
        this.hzS = (TextView) view.findViewById(R.id.item_group_meizi);
        this.hzT = (TextView) view.findViewById(R.id.item_group_num);
        this.hzU = (TextView) view.findViewById(R.id.item_introduce);
        this.hzV = (ImageView) view.findViewById(R.id.item_grade1);
        this.hzW = (ImageView) view.findViewById(R.id.item_grade2);
        this.hzX = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.hzY = new ImageView[4];
        this.hzY[1] = this.hzV;
        this.hzY[2] = this.hzW;
        this.hzY[3] = this.hzX;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.hzQ.setTag(null);
            this.hzQ.setDrawBorder(true);
            this.hzQ.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.hzQ.setTag(portrait);
                this.hzQ.startLoad(portrait, 10, false);
            }
            this.hzR.setText(groupInfoData.getName());
            this.hzS.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.hzT.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.hzU.setText(groupInfoData.getIntro().trim());
            a(this.hzY, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.hzR, R.color.common_color_10009, 1);
                am.setImageResource(this.hzV, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hzW, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hzX, R.drawable.icon_vip_grade_big_small_s);
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
