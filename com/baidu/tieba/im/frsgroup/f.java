package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes5.dex */
public class f extends v.a {
    public int ccJ;
    public View dividerLine;
    public GroupImageView gAh;
    public TextView gAi;
    public TextView gAj;
    public TextView gAk;
    public TextView gAl;
    public ImageView gAm;
    public ImageView gAn;
    public ImageView gAo;
    public ImageView[] gAp;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ccJ = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gAh = (GroupImageView) view.findViewById(R.id.item_head);
        this.gAi = (TextView) view.findViewById(R.id.item_group_name);
        this.gAj = (TextView) view.findViewById(R.id.item_group_meizi);
        this.gAk = (TextView) view.findViewById(R.id.item_group_num);
        this.gAl = (TextView) view.findViewById(R.id.item_introduce);
        this.gAm = (ImageView) view.findViewById(R.id.item_grade1);
        this.gAn = (ImageView) view.findViewById(R.id.item_grade2);
        this.gAo = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.gAp = new ImageView[4];
        this.gAp[1] = this.gAm;
        this.gAp[2] = this.gAn;
        this.gAp[3] = this.gAo;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gAh.setTag(null);
            this.gAh.setDrawBorder(true);
            this.gAh.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gAh.setTag(portrait);
                this.gAh.startLoad(portrait, 10, false);
            }
            this.gAi.setText(groupInfoData.getName());
            this.gAj.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gAk.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gAl.setText(groupInfoData.getIntro().trim());
            a(this.gAp, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.f(this.gAi, R.color.common_color_10009, 1);
                al.c(this.gAm, (int) R.drawable.icon_vip_grade_big_small_s);
                al.c(this.gAn, (int) R.drawable.icon_vip_grade_big_small_s);
                al.c(this.gAo, (int) R.drawable.icon_vip_grade_big_small_s);
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
