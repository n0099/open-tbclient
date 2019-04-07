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
    public int bUM;
    public View dividerLine;
    public GroupImageView giQ;
    public TextView giR;
    public TextView giS;
    public TextView giT;
    public TextView giU;
    public ImageView giV;
    public ImageView giW;
    public ImageView giX;
    public ImageView[] giY;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.bUM = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.giQ = (GroupImageView) view.findViewById(d.g.item_head);
        this.giR = (TextView) view.findViewById(d.g.item_group_name);
        this.giS = (TextView) view.findViewById(d.g.item_group_meizi);
        this.giT = (TextView) view.findViewById(d.g.item_group_num);
        this.giU = (TextView) view.findViewById(d.g.item_introduce);
        this.giV = (ImageView) view.findViewById(d.g.item_grade1);
        this.giW = (ImageView) view.findViewById(d.g.item_grade2);
        this.giX = (ImageView) view.findViewById(d.g.item_grade3);
        this.dividerLine = view.findViewById(d.g.divider_line);
        this.giY = new ImageView[4];
        this.giY[1] = this.giV;
        this.giY[2] = this.giW;
        this.giY[3] = this.giX;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.giQ.setTag(null);
            this.giQ.setDrawBorder(true);
            this.giQ.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.giQ.setTag(portrait);
                this.giQ.startLoad(portrait, 10, false);
            }
            this.giR.setText(groupInfoData.getName());
            this.giS.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.giT.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.giU.setText(groupInfoData.getIntro().trim());
            a(this.giY, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.d(this.giR, d.C0277d.common_color_10009, 1);
                al.c(this.giV, d.f.icon_vip_grade_big_small_s);
                al.c(this.giW, d.f.icon_vip_grade_big_small_s);
                al.c(this.giX, d.f.icon_vip_grade_big_small_s);
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
