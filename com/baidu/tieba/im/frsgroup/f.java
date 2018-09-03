package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class f extends q.a {
    public int azF;
    public View dividerLine;
    public GroupImageView esf;
    public TextView esg;
    public TextView esh;
    public TextView esi;
    public TextView esj;
    public ImageView esk;
    public ImageView esl;
    public ImageView esm;
    public ImageView[] esn;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.azF = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.esf = (GroupImageView) view.findViewById(f.g.item_head);
        this.esg = (TextView) view.findViewById(f.g.item_group_name);
        this.esh = (TextView) view.findViewById(f.g.item_group_meizi);
        this.esi = (TextView) view.findViewById(f.g.item_group_num);
        this.esj = (TextView) view.findViewById(f.g.item_introduce);
        this.esk = (ImageView) view.findViewById(f.g.item_grade1);
        this.esl = (ImageView) view.findViewById(f.g.item_grade2);
        this.esm = (ImageView) view.findViewById(f.g.item_grade3);
        this.dividerLine = view.findViewById(f.g.divider_line);
        this.esn = new ImageView[4];
        this.esn[1] = this.esk;
        this.esn[2] = this.esl;
        this.esn[3] = this.esm;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.esf.setTag(null);
            this.esf.setDrawBorder(true);
            this.esf.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.esf.setTag(portrait);
                this.esf.startLoad(portrait, 10, false);
            }
            this.esg.setText(groupInfoData.getName());
            this.esh.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.esi.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.esj.setText(groupInfoData.getIntro().trim());
            a(this.esn, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.c(this.esg, f.d.common_color_10009, 1);
                am.c(this.esk, f.C0146f.icon_vip_grade_big_small_s);
                am.c(this.esl, f.C0146f.icon_vip_grade_big_small_s);
                am.c(this.esm, f.C0146f.icon_vip_grade_big_small_s);
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
