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
    public int aHp;
    public View dividerLine;
    public GroupImageView eHj;
    public TextView eHk;
    public TextView eHl;
    public TextView eHm;
    public TextView eHn;
    public ImageView eHo;
    public ImageView eHp;
    public ImageView eHq;
    public ImageView[] eHr;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aHp = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.eHj = (GroupImageView) view.findViewById(e.g.item_head);
        this.eHk = (TextView) view.findViewById(e.g.item_group_name);
        this.eHl = (TextView) view.findViewById(e.g.item_group_meizi);
        this.eHm = (TextView) view.findViewById(e.g.item_group_num);
        this.eHn = (TextView) view.findViewById(e.g.item_introduce);
        this.eHo = (ImageView) view.findViewById(e.g.item_grade1);
        this.eHp = (ImageView) view.findViewById(e.g.item_grade2);
        this.eHq = (ImageView) view.findViewById(e.g.item_grade3);
        this.dividerLine = view.findViewById(e.g.divider_line);
        this.eHr = new ImageView[4];
        this.eHr[1] = this.eHo;
        this.eHr[2] = this.eHp;
        this.eHr[3] = this.eHq;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.eHj.setTag(null);
            this.eHj.setDrawBorder(true);
            this.eHj.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.eHj.setTag(portrait);
                this.eHj.startLoad(portrait, 10, false);
            }
            this.eHk.setText(groupInfoData.getName());
            this.eHl.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.eHm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.eHn.setText(groupInfoData.getIntro().trim());
            a(this.eHr, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.c(this.eHk, e.d.common_color_10009, 1);
                al.c(this.eHo, e.f.icon_vip_grade_big_small_s);
                al.c(this.eHp, e.f.icon_vip_grade_big_small_s);
                al.c(this.eHq, e.f.icon_vip_grade_big_small_s);
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
