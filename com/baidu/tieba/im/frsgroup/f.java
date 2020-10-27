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
    public int ajq;
    public View dividerLine;
    public GroupImageView jZm;
    public TextView jZn;
    public TextView jZo;
    public TextView jZp;
    public TextView jZq;
    public ImageView jZr;
    public ImageView jZs;
    public ImageView jZt;
    public ImageView[] jZu;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ajq = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.jZm = (GroupImageView) view.findViewById(R.id.item_head);
        this.jZn = (TextView) view.findViewById(R.id.item_group_name);
        this.jZo = (TextView) view.findViewById(R.id.item_group_meizi);
        this.jZp = (TextView) view.findViewById(R.id.item_group_num);
        this.jZq = (TextView) view.findViewById(R.id.item_introduce);
        this.jZr = (ImageView) view.findViewById(R.id.item_grade1);
        this.jZs = (ImageView) view.findViewById(R.id.item_grade2);
        this.jZt = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.jZu = new ImageView[4];
        this.jZu[1] = this.jZr;
        this.jZu[2] = this.jZs;
        this.jZu[3] = this.jZt;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.jZm.setTag(null);
            this.jZm.setDrawBorder(true);
            this.jZm.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.jZm.setTag(portrait);
                this.jZm.startLoad(portrait, 10, false);
            }
            this.jZn.setText(groupInfoData.getName());
            this.jZo.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.jZp.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.jZq.setText(groupInfoData.getIntro().trim());
            a(this.jZu, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.jZn, R.color.common_color_10009, 1);
                ap.setImageResource(this.jZr, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jZs, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jZt, R.drawable.icon_vip_grade_big_small_s);
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
