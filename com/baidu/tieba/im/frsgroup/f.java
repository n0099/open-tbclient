package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes10.dex */
public class f extends y.a {
    public int afT;
    public View dividerLine;
    public GroupImageView ilq;
    public TextView ilr;
    public TextView ils;
    public TextView ilt;
    public TextView ilu;
    public ImageView ilv;
    public ImageView ilw;
    public ImageView ilx;
    public ImageView[] ily;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.afT = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.ilq = (GroupImageView) view.findViewById(R.id.item_head);
        this.ilr = (TextView) view.findViewById(R.id.item_group_name);
        this.ils = (TextView) view.findViewById(R.id.item_group_meizi);
        this.ilt = (TextView) view.findViewById(R.id.item_group_num);
        this.ilu = (TextView) view.findViewById(R.id.item_introduce);
        this.ilv = (ImageView) view.findViewById(R.id.item_grade1);
        this.ilw = (ImageView) view.findViewById(R.id.item_grade2);
        this.ilx = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.ily = new ImageView[4];
        this.ily[1] = this.ilv;
        this.ily[2] = this.ilw;
        this.ily[3] = this.ilx;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.ilq.setTag(null);
            this.ilq.setDrawBorder(true);
            this.ilq.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ilq.setTag(portrait);
                this.ilq.startLoad(portrait, 10, false);
            }
            this.ilr.setText(groupInfoData.getName());
            this.ils.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.ilt.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.ilu.setText(groupInfoData.getIntro().trim());
            a(this.ily, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.ilr, R.color.common_color_10009, 1);
                am.setImageResource(this.ilv, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.ilw, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.ilx, R.drawable.icon_vip_grade_big_small_s);
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
