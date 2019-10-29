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
    public int csX;
    public View dividerLine;
    public GroupImageView gGZ;
    public TextView gHa;
    public TextView gHb;
    public TextView gHc;
    public TextView gHd;
    public ImageView gHe;
    public ImageView gHf;
    public ImageView gHg;
    public ImageView[] gHh;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.csX = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gGZ = (GroupImageView) view.findViewById(R.id.item_head);
        this.gHa = (TextView) view.findViewById(R.id.item_group_name);
        this.gHb = (TextView) view.findViewById(R.id.item_group_meizi);
        this.gHc = (TextView) view.findViewById(R.id.item_group_num);
        this.gHd = (TextView) view.findViewById(R.id.item_introduce);
        this.gHe = (ImageView) view.findViewById(R.id.item_grade1);
        this.gHf = (ImageView) view.findViewById(R.id.item_grade2);
        this.gHg = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.gHh = new ImageView[4];
        this.gHh[1] = this.gHe;
        this.gHh[2] = this.gHf;
        this.gHh[3] = this.gHg;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gGZ.setTag(null);
            this.gGZ.setDrawBorder(true);
            this.gGZ.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gGZ.setTag(portrait);
                this.gGZ.startLoad(portrait, 10, false);
            }
            this.gHa.setText(groupInfoData.getName());
            this.gHb.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gHc.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gHd.setText(groupInfoData.getIntro().trim());
            a(this.gHh, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.gHa, R.color.common_color_10009, 1);
                am.setImageResource(this.gHe, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.gHf, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.gHg, R.drawable.icon_vip_grade_big_small_s);
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
