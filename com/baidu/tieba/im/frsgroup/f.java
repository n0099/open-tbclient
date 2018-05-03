package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class f extends q.a {
    public int aqQ;
    public View bae;
    public GroupImageView dYc;
    public TextView dYd;
    public TextView dYe;
    public TextView dYf;
    public TextView dYg;
    public ImageView dYh;
    public ImageView dYi;
    public ImageView dYj;
    public ImageView[] dYk;
    public View rootView;

    public f(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.aqQ = 3;
        this.rootView = view2;
        this.rootView.setOnClickListener(onClickListener);
        this.dYc = (GroupImageView) view2.findViewById(d.g.item_head);
        this.dYd = (TextView) view2.findViewById(d.g.item_group_name);
        this.dYe = (TextView) view2.findViewById(d.g.item_group_meizi);
        this.dYf = (TextView) view2.findViewById(d.g.item_group_num);
        this.dYg = (TextView) view2.findViewById(d.g.item_introduce);
        this.dYh = (ImageView) view2.findViewById(d.g.item_grade1);
        this.dYi = (ImageView) view2.findViewById(d.g.item_grade2);
        this.dYj = (ImageView) view2.findViewById(d.g.item_grade3);
        this.bae = view2.findViewById(d.g.divider_line);
        this.dYk = new ImageView[4];
        this.dYk[1] = this.dYh;
        this.dYk[2] = this.dYi;
        this.dYk[3] = this.dYj;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.dYc.setTag(null);
            this.dYc.setDrawBorder(true);
            this.dYc.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.dYc.setTag(portrait);
                this.dYc.startLoad(portrait, 10, false);
            }
            this.dYd.setText(groupInfoData.getName());
            this.dYe.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.dYf.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.dYg.setText(groupInfoData.getIntro().trim());
            a(this.dYk, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ak.c(this.dYd, d.C0126d.common_color_10009, 1);
                ak.c(this.dYh, d.f.icon_vip_grade_big_small_s);
                ak.c(this.dYi, d.f.icon_vip_grade_big_small_s);
                ak.c(this.dYj, d.f.icon_vip_grade_big_small_s);
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
