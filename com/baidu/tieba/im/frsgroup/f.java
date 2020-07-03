package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes10.dex */
public class f extends ad.a {
    public int ahx;
    public View dividerLine;
    public GroupImageView iRW;
    public TextView iRX;
    public TextView iRY;
    public TextView iRZ;
    public TextView iSa;
    public ImageView iSb;
    public ImageView iSc;
    public ImageView iSd;
    public ImageView[] iSe;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ahx = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.iRW = (GroupImageView) view.findViewById(R.id.item_head);
        this.iRX = (TextView) view.findViewById(R.id.item_group_name);
        this.iRY = (TextView) view.findViewById(R.id.item_group_meizi);
        this.iRZ = (TextView) view.findViewById(R.id.item_group_num);
        this.iSa = (TextView) view.findViewById(R.id.item_introduce);
        this.iSb = (ImageView) view.findViewById(R.id.item_grade1);
        this.iSc = (ImageView) view.findViewById(R.id.item_grade2);
        this.iSd = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.iSe = new ImageView[4];
        this.iSe[1] = this.iSb;
        this.iSe[2] = this.iSc;
        this.iSe[3] = this.iSd;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.iRW.setTag(null);
            this.iRW.setDrawBorder(true);
            this.iRW.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.iRW.setTag(portrait);
                this.iRW.startLoad(portrait, 10, false);
            }
            this.iRX.setText(groupInfoData.getName());
            this.iRY.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.iRZ.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.iSa.setText(groupInfoData.getIntro().trim());
            a(this.iSe, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                an.setViewTextColor(this.iRX, R.color.common_color_10009, 1);
                an.setImageResource(this.iSb, R.drawable.icon_vip_grade_big_small_s);
                an.setImageResource(this.iSc, R.drawable.icon_vip_grade_big_small_s);
                an.setImageResource(this.iSd, R.drawable.icon_vip_grade_big_small_s);
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
