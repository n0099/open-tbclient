package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.i.a<GroupInfoData, com.baidu.tbadk.mvc.e.c> {
    protected LinearLayout aWG;
    private GroupImageView aWH;
    private TextView aWI;
    private TextView aWJ;
    private TextView aWK;
    private TextView aWL;
    private ImageView aWM;
    private ImageView aWN;
    private ImageView aWO;
    private ImageView[] aWP;

    public c(View view, ViewEventCenter viewEventCenter) {
        super(view, viewEventCenter);
        this.aWG = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_item_content);
        this.aWH = (GroupImageView) view.findViewById(com.baidu.tieba.v.item_head);
        this.aWI = (TextView) view.findViewById(com.baidu.tieba.v.item_group_name);
        this.aWJ = (TextView) view.findViewById(com.baidu.tieba.v.item_group_meizi);
        this.aWK = (TextView) view.findViewById(com.baidu.tieba.v.item_group_num);
        this.aWL = (TextView) view.findViewById(com.baidu.tieba.v.item_introduce);
        this.aWM = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade1);
        this.aWN = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade2);
        this.aWO = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade3);
        this.aWP = new ImageView[4];
        this.aWP[1] = this.aWM;
        this.aWP[2] = this.aWN;
        this.aWP[3] = this.aWO;
        dg(TbadkApplication.m251getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.e.a
    public boolean dg(int i) {
        com.baidu.tbadk.e.b.u(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.i.d
    /* renamed from: a */
    public void r(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.aWG.setVisibility(0);
            this.aWH.setTag(null);
            this.aWH.setDrawBorder(true);
            this.aWH.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.aWH.setTag(portrait);
                this.aWH.c(portrait, 10, false);
            }
            this.aWI.setText(groupInfoData.getName());
            this.aWJ.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.aWK.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            this.aWL.setText(groupInfoData.getIntro().trim());
            a(this.aWP, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                aw.b(this.aWI, com.baidu.tieba.s.im_group_vip_text, 1);
                aw.c(this.aWM, com.baidu.tieba.u.icon_vip_grade_big_small_s);
                aw.c(this.aWN, com.baidu.tieba.u.icon_vip_grade_big_small_s);
                aw.c(this.aWO, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            }
        }
    }

    private void a(ImageView[] imageViewArr, int i) {
        int i2 = i < 0 ? 0 : i;
        int i3 = i2 > 3 ? 3 : i2;
        int i4 = 1;
        if (i3 >= 1) {
            while (i4 <= i3) {
                imageViewArr[i4].setVisibility(0);
                i4++;
            }
            while (i4 <= 3) {
                imageViewArr[i4].setVisibility(8);
                i4++;
            }
        }
    }
}
