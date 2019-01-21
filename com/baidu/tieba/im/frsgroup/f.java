package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class f extends q.a {
    public int aMk;
    public View dividerLine;
    public GroupImageView eSW;
    public TextView eSX;
    public TextView eSY;
    public TextView eSZ;
    public TextView eTa;
    public ImageView eTb;
    public ImageView eTc;
    public ImageView eTd;
    public ImageView[] eTe;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aMk = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.eSW = (GroupImageView) view.findViewById(e.g.item_head);
        this.eSX = (TextView) view.findViewById(e.g.item_group_name);
        this.eSY = (TextView) view.findViewById(e.g.item_group_meizi);
        this.eSZ = (TextView) view.findViewById(e.g.item_group_num);
        this.eTa = (TextView) view.findViewById(e.g.item_introduce);
        this.eTb = (ImageView) view.findViewById(e.g.item_grade1);
        this.eTc = (ImageView) view.findViewById(e.g.item_grade2);
        this.eTd = (ImageView) view.findViewById(e.g.item_grade3);
        this.dividerLine = view.findViewById(e.g.divider_line);
        this.eTe = new ImageView[4];
        this.eTe[1] = this.eTb;
        this.eTe[2] = this.eTc;
        this.eTe[3] = this.eTd;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.eSW.setTag(null);
            this.eSW.setDrawBorder(true);
            this.eSW.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.eSW.setTag(portrait);
                this.eSW.startLoad(portrait, 10, false);
            }
            this.eSX.setText(groupInfoData.getName());
            this.eSY.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.eSZ.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.eTa.setText(groupInfoData.getIntro().trim());
            a(this.eTe, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.c(this.eSX, e.d.common_color_10009, 1);
                al.c(this.eTb, e.f.icon_vip_grade_big_small_s);
                al.c(this.eTc, e.f.icon_vip_grade_big_small_s);
                al.c(this.eTd, e.f.icon_vip_grade_big_small_s);
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
