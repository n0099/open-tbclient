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
    public int aLH;
    public View dividerLine;
    public GroupImageView eSi;
    public TextView eSj;
    public TextView eSk;
    public TextView eSl;
    public TextView eSm;
    public ImageView eSn;
    public ImageView eSo;
    public ImageView eSp;
    public ImageView[] eSq;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aLH = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.eSi = (GroupImageView) view.findViewById(e.g.item_head);
        this.eSj = (TextView) view.findViewById(e.g.item_group_name);
        this.eSk = (TextView) view.findViewById(e.g.item_group_meizi);
        this.eSl = (TextView) view.findViewById(e.g.item_group_num);
        this.eSm = (TextView) view.findViewById(e.g.item_introduce);
        this.eSn = (ImageView) view.findViewById(e.g.item_grade1);
        this.eSo = (ImageView) view.findViewById(e.g.item_grade2);
        this.eSp = (ImageView) view.findViewById(e.g.item_grade3);
        this.dividerLine = view.findViewById(e.g.divider_line);
        this.eSq = new ImageView[4];
        this.eSq[1] = this.eSn;
        this.eSq[2] = this.eSo;
        this.eSq[3] = this.eSp;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.eSi.setTag(null);
            this.eSi.setDrawBorder(true);
            this.eSi.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.eSi.setTag(portrait);
                this.eSi.startLoad(portrait, 10, false);
            }
            this.eSj.setText(groupInfoData.getName());
            this.eSk.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.eSl.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.eSm.setText(groupInfoData.getIntro().trim());
            a(this.eSq, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.c(this.eSj, e.d.common_color_10009, 1);
                al.c(this.eSn, e.f.icon_vip_grade_big_small_s);
                al.c(this.eSo, e.f.icon_vip_grade_big_small_s);
                al.c(this.eSp, e.f.icon_vip_grade_big_small_s);
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
