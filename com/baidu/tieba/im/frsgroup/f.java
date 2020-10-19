package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes23.dex */
public class f extends af.a {
    public int ajp;
    public View dividerLine;
    public GroupImageView jMO;
    public TextView jMP;
    public TextView jMQ;
    public TextView jMR;
    public TextView jMS;
    public ImageView jMT;
    public ImageView jMU;
    public ImageView jMV;
    public ImageView[] jMW;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ajp = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.jMO = (GroupImageView) view.findViewById(R.id.item_head);
        this.jMP = (TextView) view.findViewById(R.id.item_group_name);
        this.jMQ = (TextView) view.findViewById(R.id.item_group_meizi);
        this.jMR = (TextView) view.findViewById(R.id.item_group_num);
        this.jMS = (TextView) view.findViewById(R.id.item_introduce);
        this.jMT = (ImageView) view.findViewById(R.id.item_grade1);
        this.jMU = (ImageView) view.findViewById(R.id.item_grade2);
        this.jMV = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.jMW = new ImageView[4];
        this.jMW[1] = this.jMT;
        this.jMW[2] = this.jMU;
        this.jMW[3] = this.jMV;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.jMO.setTag(null);
            this.jMO.setDrawBorder(true);
            this.jMO.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.jMO.setTag(portrait);
                this.jMO.startLoad(portrait, 10, false);
            }
            this.jMP.setText(groupInfoData.getName());
            this.jMQ.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.jMR.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.jMS.setText(groupInfoData.getIntro().trim());
            a(this.jMW, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.jMP, R.color.common_color_10009, 1);
                ap.setImageResource(this.jMT, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jMU, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jMV, R.drawable.icon_vip_grade_big_small_s);
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
