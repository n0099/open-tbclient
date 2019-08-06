package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes5.dex */
public class f extends v.a {
    public int cdS;
    public View dividerLine;
    public GroupImageView gHj;
    public TextView gHk;
    public TextView gHl;
    public TextView gHm;
    public TextView gHn;
    public ImageView gHo;
    public ImageView gHp;
    public ImageView gHq;
    public ImageView[] gHr;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.cdS = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gHj = (GroupImageView) view.findViewById(R.id.item_head);
        this.gHk = (TextView) view.findViewById(R.id.item_group_name);
        this.gHl = (TextView) view.findViewById(R.id.item_group_meizi);
        this.gHm = (TextView) view.findViewById(R.id.item_group_num);
        this.gHn = (TextView) view.findViewById(R.id.item_introduce);
        this.gHo = (ImageView) view.findViewById(R.id.item_grade1);
        this.gHp = (ImageView) view.findViewById(R.id.item_grade2);
        this.gHq = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.gHr = new ImageView[4];
        this.gHr[1] = this.gHo;
        this.gHr[2] = this.gHp;
        this.gHr[3] = this.gHq;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gHj.setTag(null);
            this.gHj.setDrawBorder(true);
            this.gHj.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gHj.setTag(portrait);
                this.gHj.startLoad(portrait, 10, false);
            }
            this.gHk.setText(groupInfoData.getName());
            this.gHl.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gHm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gHn.setText(groupInfoData.getIntro().trim());
            a(this.gHr, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.f(this.gHk, R.color.common_color_10009, 1);
                am.c(this.gHo, (int) R.drawable.icon_vip_grade_big_small_s);
                am.c(this.gHp, (int) R.drawable.icon_vip_grade_big_small_s);
                am.c(this.gHq, (int) R.drawable.icon_vip_grade_big_small_s);
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
