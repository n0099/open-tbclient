package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes10.dex */
public class f extends aa.a {
    public int agt;
    public View dividerLine;
    public GroupImageView iAR;
    public TextView iAS;
    public TextView iAT;
    public TextView iAU;
    public TextView iAV;
    public ImageView iAW;
    public ImageView iAX;
    public ImageView iAY;
    public ImageView[] iAZ;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.agt = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.iAR = (GroupImageView) view.findViewById(R.id.item_head);
        this.iAS = (TextView) view.findViewById(R.id.item_group_name);
        this.iAT = (TextView) view.findViewById(R.id.item_group_meizi);
        this.iAU = (TextView) view.findViewById(R.id.item_group_num);
        this.iAV = (TextView) view.findViewById(R.id.item_introduce);
        this.iAW = (ImageView) view.findViewById(R.id.item_grade1);
        this.iAX = (ImageView) view.findViewById(R.id.item_grade2);
        this.iAY = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.iAZ = new ImageView[4];
        this.iAZ[1] = this.iAW;
        this.iAZ[2] = this.iAX;
        this.iAZ[3] = this.iAY;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.iAR.setTag(null);
            this.iAR.setDrawBorder(true);
            this.iAR.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.iAR.setTag(portrait);
                this.iAR.startLoad(portrait, 10, false);
            }
            this.iAS.setText(groupInfoData.getName());
            this.iAT.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.iAU.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.iAV.setText(groupInfoData.getIntro().trim());
            a(this.iAZ, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.iAS, R.color.common_color_10009, 1);
                am.setImageResource(this.iAW, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.iAX, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.iAY, R.drawable.icon_vip_grade_big_small_s);
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
