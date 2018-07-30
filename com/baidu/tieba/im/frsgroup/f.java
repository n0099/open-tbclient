package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class f extends q.a {
    public int azI;
    public View bkw;
    public GroupImageView esj;
    public TextView esk;
    public TextView esl;
    public TextView esm;
    public TextView esn;
    public ImageView eso;
    public ImageView esp;
    public ImageView esq;
    public ImageView[] esr;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.azI = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.esj = (GroupImageView) view.findViewById(d.g.item_head);
        this.esk = (TextView) view.findViewById(d.g.item_group_name);
        this.esl = (TextView) view.findViewById(d.g.item_group_meizi);
        this.esm = (TextView) view.findViewById(d.g.item_group_num);
        this.esn = (TextView) view.findViewById(d.g.item_introduce);
        this.eso = (ImageView) view.findViewById(d.g.item_grade1);
        this.esp = (ImageView) view.findViewById(d.g.item_grade2);
        this.esq = (ImageView) view.findViewById(d.g.item_grade3);
        this.bkw = view.findViewById(d.g.divider_line);
        this.esr = new ImageView[4];
        this.esr[1] = this.eso;
        this.esr[2] = this.esp;
        this.esr[3] = this.esq;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.esj.setTag(null);
            this.esj.setDrawBorder(true);
            this.esj.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.esj.setTag(portrait);
                this.esj.startLoad(portrait, 10, false);
            }
            this.esk.setText(groupInfoData.getName());
            this.esl.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.esm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.esn.setText(groupInfoData.getIntro().trim());
            a(this.esr, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.c(this.esk, d.C0140d.common_color_10009, 1);
                am.c(this.eso, d.f.icon_vip_grade_big_small_s);
                am.c(this.esp, d.f.icon_vip_grade_big_small_s);
                am.c(this.esq, d.f.icon_vip_grade_big_small_s);
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
