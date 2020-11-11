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
    public GroupImageView kfk;
    public TextView kfl;
    public TextView kfm;
    public TextView kfn;
    public TextView kfo;
    public ImageView kfp;
    public ImageView kfq;
    public ImageView kfr;
    public ImageView[] kfs;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ajq = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.kfk = (GroupImageView) view.findViewById(R.id.item_head);
        this.kfl = (TextView) view.findViewById(R.id.item_group_name);
        this.kfm = (TextView) view.findViewById(R.id.item_group_meizi);
        this.kfn = (TextView) view.findViewById(R.id.item_group_num);
        this.kfo = (TextView) view.findViewById(R.id.item_introduce);
        this.kfp = (ImageView) view.findViewById(R.id.item_grade1);
        this.kfq = (ImageView) view.findViewById(R.id.item_grade2);
        this.kfr = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.kfs = new ImageView[4];
        this.kfs[1] = this.kfp;
        this.kfs[2] = this.kfq;
        this.kfs[3] = this.kfr;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.kfk.setTag(null);
            this.kfk.setDrawBorder(true);
            this.kfk.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.kfk.setTag(portrait);
                this.kfk.startLoad(portrait, 10, false);
            }
            this.kfl.setText(groupInfoData.getName());
            this.kfm.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.kfn.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.kfo.setText(groupInfoData.getIntro().trim());
            a(this.kfs, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.kfl, R.color.common_color_10009, 1);
                ap.setImageResource(this.kfp, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.kfq, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.kfr, R.drawable.icon_vip_grade_big_small_s);
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
