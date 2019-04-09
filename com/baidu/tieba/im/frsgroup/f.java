package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes5.dex */
public class f extends v.a {
    public int bUN;
    public View dividerLine;
    public GroupImageView giR;
    public TextView giS;
    public TextView giT;
    public TextView giU;
    public TextView giV;
    public ImageView giW;
    public ImageView giX;
    public ImageView giY;
    public ImageView[] giZ;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.bUN = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.giR = (GroupImageView) view.findViewById(d.g.item_head);
        this.giS = (TextView) view.findViewById(d.g.item_group_name);
        this.giT = (TextView) view.findViewById(d.g.item_group_meizi);
        this.giU = (TextView) view.findViewById(d.g.item_group_num);
        this.giV = (TextView) view.findViewById(d.g.item_introduce);
        this.giW = (ImageView) view.findViewById(d.g.item_grade1);
        this.giX = (ImageView) view.findViewById(d.g.item_grade2);
        this.giY = (ImageView) view.findViewById(d.g.item_grade3);
        this.dividerLine = view.findViewById(d.g.divider_line);
        this.giZ = new ImageView[4];
        this.giZ[1] = this.giW;
        this.giZ[2] = this.giX;
        this.giZ[3] = this.giY;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.giR.setTag(null);
            this.giR.setDrawBorder(true);
            this.giR.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.giR.setTag(portrait);
                this.giR.startLoad(portrait, 10, false);
            }
            this.giS.setText(groupInfoData.getName());
            this.giT.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.giU.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.giV.setText(groupInfoData.getIntro().trim());
            a(this.giZ, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.d(this.giS, d.C0277d.common_color_10009, 1);
                al.c(this.giW, d.f.icon_vip_grade_big_small_s);
                al.c(this.giX, d.f.icon_vip_grade_big_small_s);
                al.c(this.giY, d.f.icon_vip_grade_big_small_s);
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
