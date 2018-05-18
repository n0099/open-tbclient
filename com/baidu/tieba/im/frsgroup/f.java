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
    public View baf;
    public GroupImageView dZj;
    public TextView dZk;
    public TextView dZl;
    public TextView dZm;
    public TextView dZn;
    public ImageView dZo;
    public ImageView dZp;
    public ImageView dZq;
    public ImageView[] dZr;
    public View rootView;

    public f(View view2, View.OnClickListener onClickListener) {
        super(view2);
        this.aqQ = 3;
        this.rootView = view2;
        this.rootView.setOnClickListener(onClickListener);
        this.dZj = (GroupImageView) view2.findViewById(d.g.item_head);
        this.dZk = (TextView) view2.findViewById(d.g.item_group_name);
        this.dZl = (TextView) view2.findViewById(d.g.item_group_meizi);
        this.dZm = (TextView) view2.findViewById(d.g.item_group_num);
        this.dZn = (TextView) view2.findViewById(d.g.item_introduce);
        this.dZo = (ImageView) view2.findViewById(d.g.item_grade1);
        this.dZp = (ImageView) view2.findViewById(d.g.item_grade2);
        this.dZq = (ImageView) view2.findViewById(d.g.item_grade3);
        this.baf = view2.findViewById(d.g.divider_line);
        this.dZr = new ImageView[4];
        this.dZr[1] = this.dZo;
        this.dZr[2] = this.dZp;
        this.dZr[3] = this.dZq;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.dZj.setTag(null);
            this.dZj.setDrawBorder(true);
            this.dZj.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.dZj.setTag(portrait);
                this.dZj.startLoad(portrait, 10, false);
            }
            this.dZk.setText(groupInfoData.getName());
            this.dZl.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.dZm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.dZn.setText(groupInfoData.getIntro().trim());
            a(this.dZr, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ak.c(this.dZk, d.C0126d.common_color_10009, 1);
                ak.c(this.dZo, d.f.icon_vip_grade_big_small_s);
                ak.c(this.dZp, d.f.icon_vip_grade_big_small_s);
                ak.c(this.dZq, d.f.icon_vip_grade_big_small_s);
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
