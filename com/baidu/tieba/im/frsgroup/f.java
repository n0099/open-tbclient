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
    public View bQi;
    public int bfC;
    public GroupImageView eDB;
    public TextView eDC;
    public TextView eDD;
    public TextView eDE;
    public TextView eDF;
    public ImageView eDG;
    public ImageView eDH;
    public ImageView eDI;
    public ImageView[] eDJ;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.bfC = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.eDB = (GroupImageView) view.findViewById(d.g.item_head);
        this.eDC = (TextView) view.findViewById(d.g.item_group_name);
        this.eDD = (TextView) view.findViewById(d.g.item_group_meizi);
        this.eDE = (TextView) view.findViewById(d.g.item_group_num);
        this.eDF = (TextView) view.findViewById(d.g.item_introduce);
        this.eDG = (ImageView) view.findViewById(d.g.item_grade1);
        this.eDH = (ImageView) view.findViewById(d.g.item_grade2);
        this.eDI = (ImageView) view.findViewById(d.g.item_grade3);
        this.bQi = view.findViewById(d.g.divider_line);
        this.eDJ = new ImageView[4];
        this.eDJ[1] = this.eDG;
        this.eDJ[2] = this.eDH;
        this.eDJ[3] = this.eDI;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.eDB.setTag(null);
            this.eDB.setDrawBorder(true);
            this.eDB.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.eDB.setTag(portrait);
                this.eDB.startLoad(portrait, 10, false);
            }
            this.eDC.setText(groupInfoData.getName());
            this.eDD.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.eDE.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.eDF.setText(groupInfoData.getIntro().trim());
            a(this.eDJ, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                aj.e(this.eDC, d.C0141d.common_color_10009, 1);
                aj.c(this.eDG, d.f.icon_vip_grade_big_small_s);
                aj.c(this.eDH, d.f.icon_vip_grade_big_small_s);
                aj.c(this.eDI, d.f.icon_vip_grade_big_small_s);
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
