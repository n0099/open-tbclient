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
/* loaded from: classes17.dex */
public class f extends af.a {
    public int aiD;
    public View dividerLine;
    public GroupImageView jpo;
    public TextView jpp;
    public TextView jpq;
    public TextView jpr;
    public TextView jps;
    public ImageView jpt;
    public ImageView jpu;
    public ImageView jpv;
    public ImageView[] jpw;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aiD = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.jpo = (GroupImageView) view.findViewById(R.id.item_head);
        this.jpp = (TextView) view.findViewById(R.id.item_group_name);
        this.jpq = (TextView) view.findViewById(R.id.item_group_meizi);
        this.jpr = (TextView) view.findViewById(R.id.item_group_num);
        this.jps = (TextView) view.findViewById(R.id.item_introduce);
        this.jpt = (ImageView) view.findViewById(R.id.item_grade1);
        this.jpu = (ImageView) view.findViewById(R.id.item_grade2);
        this.jpv = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.jpw = new ImageView[4];
        this.jpw[1] = this.jpt;
        this.jpw[2] = this.jpu;
        this.jpw[3] = this.jpv;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.jpo.setTag(null);
            this.jpo.setDrawBorder(true);
            this.jpo.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.jpo.setTag(portrait);
                this.jpo.startLoad(portrait, 10, false);
            }
            this.jpp.setText(groupInfoData.getName());
            this.jpq.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.jpr.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.jps.setText(groupInfoData.getIntro().trim());
            a(this.jpw, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.jpp, R.color.common_color_10009, 1);
                ap.setImageResource(this.jpt, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jpu, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jpv, R.drawable.icon_vip_grade_big_small_s);
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
