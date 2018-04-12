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
    public GroupImageView dYf;
    public TextView dYg;
    public TextView dYh;
    public TextView dYi;
    public TextView dYj;
    public ImageView dYk;
    public ImageView dYl;
    public ImageView dYm;
    public ImageView[] dYn;
    public View rootView;

    public f(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.aqQ = 3;
        this.rootView = view2;
        this.rootView.setOnClickListener(onClickListener);
        this.dYf = (GroupImageView) view2.findViewById(d.g.item_head);
        this.dYg = (TextView) view2.findViewById(d.g.item_group_name);
        this.dYh = (TextView) view2.findViewById(d.g.item_group_meizi);
        this.dYi = (TextView) view2.findViewById(d.g.item_group_num);
        this.dYj = (TextView) view2.findViewById(d.g.item_introduce);
        this.dYk = (ImageView) view2.findViewById(d.g.item_grade1);
        this.dYl = (ImageView) view2.findViewById(d.g.item_grade2);
        this.dYm = (ImageView) view2.findViewById(d.g.item_grade3);
        this.bae = view2.findViewById(d.g.divider_line);
        this.dYn = new ImageView[4];
        this.dYn[1] = this.dYk;
        this.dYn[2] = this.dYl;
        this.dYn[3] = this.dYm;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.dYf.setTag(null);
            this.dYf.setDrawBorder(true);
            this.dYf.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.dYf.setTag(portrait);
                this.dYf.startLoad(portrait, 10, false);
            }
            this.dYg.setText(groupInfoData.getName());
            this.dYh.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.dYi.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.dYj.setText(groupInfoData.getIntro().trim());
            a(this.dYn, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ak.c(this.dYg, d.C0126d.common_color_10009, 1);
                ak.c(this.dYk, d.f.icon_vip_grade_big_small_s);
                ak.c(this.dYl, d.f.icon_vip_grade_big_small_s);
                ak.c(this.dYm, d.f.icon_vip_grade_big_small_s);
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
