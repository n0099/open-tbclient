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
    private ImageView aWA;
    private ImageView[] aWB;
    protected LinearLayout aWs;
    private GroupImageView aWt;
    private TextView aWu;
    private TextView aWv;
    private TextView aWw;
    private TextView aWx;
    private ImageView aWy;
    private ImageView aWz;

    public c(View view, ViewEventCenter viewEventCenter) {
        super(view, viewEventCenter);
        this.aWs = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_item_content);
        this.aWt = (GroupImageView) view.findViewById(com.baidu.tieba.v.item_head);
        this.aWu = (TextView) view.findViewById(com.baidu.tieba.v.item_group_name);
        this.aWv = (TextView) view.findViewById(com.baidu.tieba.v.item_group_meizi);
        this.aWw = (TextView) view.findViewById(com.baidu.tieba.v.item_group_num);
        this.aWx = (TextView) view.findViewById(com.baidu.tieba.v.item_introduce);
        this.aWy = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade1);
        this.aWz = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade2);
        this.aWA = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade3);
        this.aWB = new ImageView[4];
        this.aWB[1] = this.aWy;
        this.aWB[2] = this.aWz;
        this.aWB[3] = this.aWA;
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
            this.aWs.setVisibility(0);
            this.aWt.setTag(null);
            this.aWt.setDrawBorder(true);
            this.aWt.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.aWt.setTag(portrait);
                this.aWt.c(portrait, 10, false);
            }
            this.aWu.setText(groupInfoData.getName());
            this.aWv.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.aWw.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            this.aWx.setText(groupInfoData.getIntro().trim());
            a(this.aWB, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                aw.b(this.aWu, com.baidu.tieba.s.im_group_vip_text, 1);
                aw.c(this.aWy, com.baidu.tieba.u.icon_vip_grade_big_small_s);
                aw.c(this.aWz, com.baidu.tieba.u.icon_vip_grade_big_small_s);
                aw.c(this.aWA, com.baidu.tieba.u.icon_vip_grade_big_small_s);
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
