package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class f extends q.a {
    public int ayX;
    public View bir;
    public TextView ekA;
    public ImageView ekB;
    public ImageView ekC;
    public ImageView ekD;
    public ImageView[] ekE;
    public GroupImageView ekw;
    public TextView ekx;
    public TextView eky;
    public TextView ekz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ayX = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.ekw = (GroupImageView) view.findViewById(d.g.item_head);
        this.ekx = (TextView) view.findViewById(d.g.item_group_name);
        this.eky = (TextView) view.findViewById(d.g.item_group_meizi);
        this.ekz = (TextView) view.findViewById(d.g.item_group_num);
        this.ekA = (TextView) view.findViewById(d.g.item_introduce);
        this.ekB = (ImageView) view.findViewById(d.g.item_grade1);
        this.ekC = (ImageView) view.findViewById(d.g.item_grade2);
        this.ekD = (ImageView) view.findViewById(d.g.item_grade3);
        this.bir = view.findViewById(d.g.divider_line);
        this.ekE = new ImageView[4];
        this.ekE[1] = this.ekB;
        this.ekE[2] = this.ekC;
        this.ekE[3] = this.ekD;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.ekw.setTag(null);
            this.ekw.setDrawBorder(true);
            this.ekw.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ekw.setTag(portrait);
                this.ekw.startLoad(portrait, 10, false);
            }
            this.ekx.setText(groupInfoData.getName());
            this.eky.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.ekz.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.ekA.setText(groupInfoData.getIntro().trim());
            a(this.ekE, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.c(this.ekx, d.C0141d.common_color_10009, 1);
                al.c(this.ekB, d.f.icon_vip_grade_big_small_s);
                al.c(this.ekC, d.f.icon_vip_grade_big_small_s);
                al.c(this.ekD, d.f.icon_vip_grade_big_small_s);
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
