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
    public int azP;
    public View bjR;
    public GroupImageView eor;
    public TextView eos;
    public TextView eot;
    public TextView eou;
    public TextView eov;
    public ImageView eow;
    public ImageView eox;
    public ImageView eoy;
    public ImageView[] eoz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.azP = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.eor = (GroupImageView) view.findViewById(d.g.item_head);
        this.eos = (TextView) view.findViewById(d.g.item_group_name);
        this.eot = (TextView) view.findViewById(d.g.item_group_meizi);
        this.eou = (TextView) view.findViewById(d.g.item_group_num);
        this.eov = (TextView) view.findViewById(d.g.item_introduce);
        this.eow = (ImageView) view.findViewById(d.g.item_grade1);
        this.eox = (ImageView) view.findViewById(d.g.item_grade2);
        this.eoy = (ImageView) view.findViewById(d.g.item_grade3);
        this.bjR = view.findViewById(d.g.divider_line);
        this.eoz = new ImageView[4];
        this.eoz[1] = this.eow;
        this.eoz[2] = this.eox;
        this.eoz[3] = this.eoy;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.eor.setTag(null);
            this.eor.setDrawBorder(true);
            this.eor.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.eor.setTag(portrait);
                this.eor.startLoad(portrait, 10, false);
            }
            this.eos.setText(groupInfoData.getName());
            this.eot.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.eou.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.eov.setText(groupInfoData.getIntro().trim());
            a(this.eoz, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.c(this.eos, d.C0142d.common_color_10009, 1);
                am.c(this.eow, d.f.icon_vip_grade_big_small_s);
                am.c(this.eox, d.f.icon_vip_grade_big_small_s);
                am.c(this.eoy, d.f.icon_vip_grade_big_small_s);
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
