package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes10.dex */
public class f extends y.a {
    public int afW;
    public View dividerLine;
    public TextView ilA;
    public ImageView ilB;
    public ImageView ilC;
    public ImageView ilD;
    public ImageView[] ilE;
    public GroupImageView ilw;
    public TextView ilx;
    public TextView ily;
    public TextView ilz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.afW = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.ilw = (GroupImageView) view.findViewById(R.id.item_head);
        this.ilx = (TextView) view.findViewById(R.id.item_group_name);
        this.ily = (TextView) view.findViewById(R.id.item_group_meizi);
        this.ilz = (TextView) view.findViewById(R.id.item_group_num);
        this.ilA = (TextView) view.findViewById(R.id.item_introduce);
        this.ilB = (ImageView) view.findViewById(R.id.item_grade1);
        this.ilC = (ImageView) view.findViewById(R.id.item_grade2);
        this.ilD = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.ilE = new ImageView[4];
        this.ilE[1] = this.ilB;
        this.ilE[2] = this.ilC;
        this.ilE[3] = this.ilD;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.ilw.setTag(null);
            this.ilw.setDrawBorder(true);
            this.ilw.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ilw.setTag(portrait);
                this.ilw.startLoad(portrait, 10, false);
            }
            this.ilx.setText(groupInfoData.getName());
            this.ily.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.ilz.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.ilA.setText(groupInfoData.getIntro().trim());
            a(this.ilE, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.ilx, R.color.common_color_10009, 1);
                am.setImageResource(this.ilB, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.ilC, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.ilD, R.drawable.icon_vip_grade_big_small_s);
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
