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
    public int aIf;
    public View dividerLine;
    public GroupImageView eIC;
    public TextView eID;
    public TextView eIE;
    public TextView eIF;
    public TextView eIG;
    public ImageView eIH;
    public ImageView eII;
    public ImageView eIJ;
    public ImageView[] eIK;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aIf = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.eIC = (GroupImageView) view.findViewById(e.g.item_head);
        this.eID = (TextView) view.findViewById(e.g.item_group_name);
        this.eIE = (TextView) view.findViewById(e.g.item_group_meizi);
        this.eIF = (TextView) view.findViewById(e.g.item_group_num);
        this.eIG = (TextView) view.findViewById(e.g.item_introduce);
        this.eIH = (ImageView) view.findViewById(e.g.item_grade1);
        this.eII = (ImageView) view.findViewById(e.g.item_grade2);
        this.eIJ = (ImageView) view.findViewById(e.g.item_grade3);
        this.dividerLine = view.findViewById(e.g.divider_line);
        this.eIK = new ImageView[4];
        this.eIK[1] = this.eIH;
        this.eIK[2] = this.eII;
        this.eIK[3] = this.eIJ;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.eIC.setTag(null);
            this.eIC.setDrawBorder(true);
            this.eIC.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.eIC.setTag(portrait);
                this.eIC.startLoad(portrait, 10, false);
            }
            this.eID.setText(groupInfoData.getName());
            this.eIE.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.eIF.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.eIG.setText(groupInfoData.getIntro().trim());
            a(this.eIK, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.c(this.eID, e.d.common_color_10009, 1);
                al.c(this.eIH, e.f.icon_vip_grade_big_small_s);
                al.c(this.eII, e.f.icon_vip_grade_big_small_s);
                al.c(this.eIJ, e.f.icon_vip_grade_big_small_s);
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
