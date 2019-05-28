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
    public int ccI;
    public View dividerLine;
    public GroupImageView gAf;
    public TextView gAg;
    public TextView gAh;
    public TextView gAi;
    public TextView gAj;
    public ImageView gAk;
    public ImageView gAl;
    public ImageView gAm;
    public ImageView[] gAn;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ccI = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gAf = (GroupImageView) view.findViewById(R.id.item_head);
        this.gAg = (TextView) view.findViewById(R.id.item_group_name);
        this.gAh = (TextView) view.findViewById(R.id.item_group_meizi);
        this.gAi = (TextView) view.findViewById(R.id.item_group_num);
        this.gAj = (TextView) view.findViewById(R.id.item_introduce);
        this.gAk = (ImageView) view.findViewById(R.id.item_grade1);
        this.gAl = (ImageView) view.findViewById(R.id.item_grade2);
        this.gAm = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.gAn = new ImageView[4];
        this.gAn[1] = this.gAk;
        this.gAn[2] = this.gAl;
        this.gAn[3] = this.gAm;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gAf.setTag(null);
            this.gAf.setDrawBorder(true);
            this.gAf.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gAf.setTag(portrait);
                this.gAf.startLoad(portrait, 10, false);
            }
            this.gAg.setText(groupInfoData.getName());
            this.gAh.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gAi.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gAj.setText(groupInfoData.getIntro().trim());
            a(this.gAn, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.f(this.gAg, R.color.common_color_10009, 1);
                al.c(this.gAk, (int) R.drawable.icon_vip_grade_big_small_s);
                al.c(this.gAl, (int) R.drawable.icon_vip_grade_big_small_s);
                al.c(this.gAm, (int) R.drawable.icon_vip_grade_big_small_s);
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
