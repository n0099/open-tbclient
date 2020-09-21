package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes22.dex */
public class f extends af.a {
    public int aiX;
    public View dividerLine;
    public GroupImageView jxR;
    public TextView jxS;
    public TextView jxT;
    public TextView jxU;
    public TextView jxV;
    public ImageView jxW;
    public ImageView jxX;
    public ImageView jxY;
    public ImageView[] jxZ;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aiX = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.jxR = (GroupImageView) view.findViewById(R.id.item_head);
        this.jxS = (TextView) view.findViewById(R.id.item_group_name);
        this.jxT = (TextView) view.findViewById(R.id.item_group_meizi);
        this.jxU = (TextView) view.findViewById(R.id.item_group_num);
        this.jxV = (TextView) view.findViewById(R.id.item_introduce);
        this.jxW = (ImageView) view.findViewById(R.id.item_grade1);
        this.jxX = (ImageView) view.findViewById(R.id.item_grade2);
        this.jxY = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.jxZ = new ImageView[4];
        this.jxZ[1] = this.jxW;
        this.jxZ[2] = this.jxX;
        this.jxZ[3] = this.jxY;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.jxR.setTag(null);
            this.jxR.setDrawBorder(true);
            this.jxR.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.jxR.setTag(portrait);
                this.jxR.startLoad(portrait, 10, false);
            }
            this.jxS.setText(groupInfoData.getName());
            this.jxT.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.jxU.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.jxV.setText(groupInfoData.getIntro().trim());
            a(this.jxZ, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.jxS, R.color.common_color_10009, 1);
                ap.setImageResource(this.jxW, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jxX, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jxY, R.drawable.icon_vip_grade_big_small_s);
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
