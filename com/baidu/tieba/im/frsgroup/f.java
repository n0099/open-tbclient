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
    public int aCJ;
    public View dividerLine;
    public TextView ezA;
    public TextView ezB;
    public TextView ezC;
    public TextView ezD;
    public ImageView ezE;
    public ImageView ezF;
    public ImageView ezG;
    public ImageView[] ezH;
    public GroupImageView ezz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aCJ = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.ezz = (GroupImageView) view.findViewById(e.g.item_head);
        this.ezA = (TextView) view.findViewById(e.g.item_group_name);
        this.ezB = (TextView) view.findViewById(e.g.item_group_meizi);
        this.ezC = (TextView) view.findViewById(e.g.item_group_num);
        this.ezD = (TextView) view.findViewById(e.g.item_introduce);
        this.ezE = (ImageView) view.findViewById(e.g.item_grade1);
        this.ezF = (ImageView) view.findViewById(e.g.item_grade2);
        this.ezG = (ImageView) view.findViewById(e.g.item_grade3);
        this.dividerLine = view.findViewById(e.g.divider_line);
        this.ezH = new ImageView[4];
        this.ezH[1] = this.ezE;
        this.ezH[2] = this.ezF;
        this.ezH[3] = this.ezG;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.ezz.setTag(null);
            this.ezz.setDrawBorder(true);
            this.ezz.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ezz.setTag(portrait);
                this.ezz.startLoad(portrait, 10, false);
            }
            this.ezA.setText(groupInfoData.getName());
            this.ezB.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.ezC.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.ezD.setText(groupInfoData.getIntro().trim());
            a(this.ezH, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.c(this.ezA, e.d.common_color_10009, 1);
                al.c(this.ezE, e.f.icon_vip_grade_big_small_s);
                al.c(this.ezF, e.f.icon_vip_grade_big_small_s);
                al.c(this.ezG, e.f.icon_vip_grade_big_small_s);
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
