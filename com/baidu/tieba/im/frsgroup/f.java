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
    public GroupImageView hzO;
    public TextView hzP;
    public TextView hzQ;
    public TextView hzR;
    public TextView hzS;
    public ImageView hzT;
    public ImageView hzU;
    public ImageView hzV;
    public ImageView[] hzW;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.Ni = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.hzO = (GroupImageView) view.findViewById(R.id.item_head);
        this.hzP = (TextView) view.findViewById(R.id.item_group_name);
        this.hzQ = (TextView) view.findViewById(R.id.item_group_meizi);
        this.hzR = (TextView) view.findViewById(R.id.item_group_num);
        this.hzS = (TextView) view.findViewById(R.id.item_introduce);
        this.hzT = (ImageView) view.findViewById(R.id.item_grade1);
        this.hzU = (ImageView) view.findViewById(R.id.item_grade2);
        this.hzV = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.hzW = new ImageView[4];
        this.hzW[1] = this.hzT;
        this.hzW[2] = this.hzU;
        this.hzW[3] = this.hzV;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.hzO.setTag(null);
            this.hzO.setDrawBorder(true);
            this.hzO.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.hzO.setTag(portrait);
                this.hzO.startLoad(portrait, 10, false);
            }
            this.hzP.setText(groupInfoData.getName());
            this.hzQ.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.hzR.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.hzS.setText(groupInfoData.getIntro().trim());
            a(this.hzW, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.hzP, R.color.common_color_10009, 1);
                am.setImageResource(this.hzT, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hzU, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hzV, R.drawable.icon_vip_grade_big_small_s);
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
