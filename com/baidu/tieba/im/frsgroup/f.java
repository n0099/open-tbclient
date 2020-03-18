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
    public int Nj;
    public View dividerLine;
    public GroupImageView hBC;
    public TextView hBD;
    public TextView hBE;
    public TextView hBF;
    public TextView hBG;
    public ImageView hBH;
    public ImageView hBI;
    public ImageView hBJ;
    public ImageView[] hBK;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.Nj = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.hBC = (GroupImageView) view.findViewById(R.id.item_head);
        this.hBD = (TextView) view.findViewById(R.id.item_group_name);
        this.hBE = (TextView) view.findViewById(R.id.item_group_meizi);
        this.hBF = (TextView) view.findViewById(R.id.item_group_num);
        this.hBG = (TextView) view.findViewById(R.id.item_introduce);
        this.hBH = (ImageView) view.findViewById(R.id.item_grade1);
        this.hBI = (ImageView) view.findViewById(R.id.item_grade2);
        this.hBJ = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.hBK = new ImageView[4];
        this.hBK[1] = this.hBH;
        this.hBK[2] = this.hBI;
        this.hBK[3] = this.hBJ;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.hBC.setTag(null);
            this.hBC.setDrawBorder(true);
            this.hBC.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.hBC.setTag(portrait);
                this.hBC.startLoad(portrait, 10, false);
            }
            this.hBD.setText(groupInfoData.getName());
            this.hBE.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.hBF.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.hBG.setText(groupInfoData.getIntro().trim());
            a(this.hBK, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.hBD, R.color.common_color_10009, 1);
                am.setImageResource(this.hBH, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hBI, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hBJ, R.drawable.icon_vip_grade_big_small_s);
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
