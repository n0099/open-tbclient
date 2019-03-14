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
    public int bUK;
    public View dividerLine;
    public GroupImageView gjd;
    public TextView gje;
    public TextView gjf;
    public TextView gjg;
    public TextView gjh;
    public ImageView gji;
    public ImageView gjj;
    public ImageView gjk;
    public ImageView[] gjl;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.bUK = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gjd = (GroupImageView) view.findViewById(d.g.item_head);
        this.gje = (TextView) view.findViewById(d.g.item_group_name);
        this.gjf = (TextView) view.findViewById(d.g.item_group_meizi);
        this.gjg = (TextView) view.findViewById(d.g.item_group_num);
        this.gjh = (TextView) view.findViewById(d.g.item_introduce);
        this.gji = (ImageView) view.findViewById(d.g.item_grade1);
        this.gjj = (ImageView) view.findViewById(d.g.item_grade2);
        this.gjk = (ImageView) view.findViewById(d.g.item_grade3);
        this.dividerLine = view.findViewById(d.g.divider_line);
        this.gjl = new ImageView[4];
        this.gjl[1] = this.gji;
        this.gjl[2] = this.gjj;
        this.gjl[3] = this.gjk;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gjd.setTag(null);
            this.gjd.setDrawBorder(true);
            this.gjd.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gjd.setTag(portrait);
                this.gjd.startLoad(portrait, 10, false);
            }
            this.gje.setText(groupInfoData.getName());
            this.gjf.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gjg.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gjh.setText(groupInfoData.getIntro().trim());
            a(this.gjl, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.d(this.gje, d.C0277d.common_color_10009, 1);
                al.c(this.gji, d.f.icon_vip_grade_big_small_s);
                al.c(this.gjj, d.f.icon_vip_grade_big_small_s);
                al.c(this.gjk, d.f.icon_vip_grade_big_small_s);
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
