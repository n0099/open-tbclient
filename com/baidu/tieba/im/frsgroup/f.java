package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes10.dex */
public class f extends aa.a {
    public int agt;
    public View dividerLine;
    public GroupImageView iAe;
    public TextView iAf;
    public TextView iAg;
    public TextView iAh;
    public TextView iAi;
    public ImageView iAj;
    public ImageView iAk;
    public ImageView iAl;
    public ImageView[] iAm;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.agt = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.iAe = (GroupImageView) view.findViewById(R.id.item_head);
        this.iAf = (TextView) view.findViewById(R.id.item_group_name);
        this.iAg = (TextView) view.findViewById(R.id.item_group_meizi);
        this.iAh = (TextView) view.findViewById(R.id.item_group_num);
        this.iAi = (TextView) view.findViewById(R.id.item_introduce);
        this.iAj = (ImageView) view.findViewById(R.id.item_grade1);
        this.iAk = (ImageView) view.findViewById(R.id.item_grade2);
        this.iAl = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.iAm = new ImageView[4];
        this.iAm[1] = this.iAj;
        this.iAm[2] = this.iAk;
        this.iAm[3] = this.iAl;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.iAe.setTag(null);
            this.iAe.setDrawBorder(true);
            this.iAe.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.iAe.setTag(portrait);
                this.iAe.startLoad(portrait, 10, false);
            }
            this.iAf.setText(groupInfoData.getName());
            this.iAg.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.iAh.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.iAi.setText(groupInfoData.getIntro().trim());
            a(this.iAm, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.iAf, R.color.common_color_10009, 1);
                am.setImageResource(this.iAj, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.iAk, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.iAl, R.drawable.icon_vip_grade_big_small_s);
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
