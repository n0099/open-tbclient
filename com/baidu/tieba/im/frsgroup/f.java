package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class f extends r.a {
    public View bQs;
    public int bfL;
    public TextView eDA;
    public TextView eDB;
    public ImageView eDC;
    public ImageView eDD;
    public ImageView eDE;
    public ImageView[] eDF;
    public GroupImageView eDx;
    public TextView eDy;
    public TextView eDz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.bfL = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.eDx = (GroupImageView) view.findViewById(d.g.item_head);
        this.eDy = (TextView) view.findViewById(d.g.item_group_name);
        this.eDz = (TextView) view.findViewById(d.g.item_group_meizi);
        this.eDA = (TextView) view.findViewById(d.g.item_group_num);
        this.eDB = (TextView) view.findViewById(d.g.item_introduce);
        this.eDC = (ImageView) view.findViewById(d.g.item_grade1);
        this.eDD = (ImageView) view.findViewById(d.g.item_grade2);
        this.eDE = (ImageView) view.findViewById(d.g.item_grade3);
        this.bQs = view.findViewById(d.g.divider_line);
        this.eDF = new ImageView[4];
        this.eDF[1] = this.eDC;
        this.eDF[2] = this.eDD;
        this.eDF[3] = this.eDE;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.eDx.setTag(null);
            this.eDx.setDrawBorder(true);
            this.eDx.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.eDx.setTag(portrait);
                this.eDx.startLoad(portrait, 10, false);
            }
            this.eDy.setText(groupInfoData.getName());
            this.eDz.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.eDA.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.eDB.setText(groupInfoData.getIntro().trim());
            a(this.eDF, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                aj.e(this.eDy, d.C0140d.common_color_10009, 1);
                aj.c(this.eDC, d.f.icon_vip_grade_big_small_s);
                aj.c(this.eDD, d.f.icon_vip_grade_big_small_s);
                aj.c(this.eDE, d.f.icon_vip_grade_big_small_s);
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
