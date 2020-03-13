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
/* loaded from: classes10.dex */
public class f extends v.a {
    public int Ni;
    public View dividerLine;
    public GroupImageView hAc;
    public TextView hAd;
    public TextView hAe;
    public TextView hAf;
    public TextView hAg;
    public ImageView hAh;
    public ImageView hAi;
    public ImageView hAj;
    public ImageView[] hAk;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.Ni = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.hAc = (GroupImageView) view.findViewById(R.id.item_head);
        this.hAd = (TextView) view.findViewById(R.id.item_group_name);
        this.hAe = (TextView) view.findViewById(R.id.item_group_meizi);
        this.hAf = (TextView) view.findViewById(R.id.item_group_num);
        this.hAg = (TextView) view.findViewById(R.id.item_introduce);
        this.hAh = (ImageView) view.findViewById(R.id.item_grade1);
        this.hAi = (ImageView) view.findViewById(R.id.item_grade2);
        this.hAj = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.hAk = new ImageView[4];
        this.hAk[1] = this.hAh;
        this.hAk[2] = this.hAi;
        this.hAk[3] = this.hAj;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.hAc.setTag(null);
            this.hAc.setDrawBorder(true);
            this.hAc.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.hAc.setTag(portrait);
                this.hAc.startLoad(portrait, 10, false);
            }
            this.hAd.setText(groupInfoData.getName());
            this.hAe.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.hAf.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.hAg.setText(groupInfoData.getIntro().trim());
            a(this.hAk, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.hAd, R.color.common_color_10009, 1);
                am.setImageResource(this.hAh, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hAi, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hAj, R.drawable.icon_vip_grade_big_small_s);
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
