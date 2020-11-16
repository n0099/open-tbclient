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
    public int ajv;
    public View dividerLine;
    public GroupImageView kfU;
    public TextView kfV;
    public TextView kfW;
    public TextView kfX;
    public TextView kfY;
    public ImageView kfZ;
    public ImageView kga;
    public ImageView kgb;
    public ImageView[] kgc;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ajv = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.kfU = (GroupImageView) view.findViewById(R.id.item_head);
        this.kfV = (TextView) view.findViewById(R.id.item_group_name);
        this.kfW = (TextView) view.findViewById(R.id.item_group_meizi);
        this.kfX = (TextView) view.findViewById(R.id.item_group_num);
        this.kfY = (TextView) view.findViewById(R.id.item_introduce);
        this.kfZ = (ImageView) view.findViewById(R.id.item_grade1);
        this.kga = (ImageView) view.findViewById(R.id.item_grade2);
        this.kgb = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.kgc = new ImageView[4];
        this.kgc[1] = this.kfZ;
        this.kgc[2] = this.kga;
        this.kgc[3] = this.kgb;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.kfU.setTag(null);
            this.kfU.setDrawBorder(true);
            this.kfU.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.kfU.setTag(portrait);
                this.kfU.startLoad(portrait, 10, false);
            }
            this.kfV.setText(groupInfoData.getName());
            this.kfW.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.kfX.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.kfY.setText(groupInfoData.getIntro().trim());
            a(this.kgc, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.kfV, R.color.common_color_10009, 1);
                ap.setImageResource(this.kfZ, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.kga, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.kgb, R.drawable.icon_vip_grade_big_small_s);
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
