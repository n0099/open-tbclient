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
    public int aiB;
    public View dividerLine;
    public GroupImageView jpi;
    public TextView jpj;
    public TextView jpk;
    public TextView jpl;
    public TextView jpm;
    public ImageView jpn;
    public ImageView jpo;
    public ImageView jpp;
    public ImageView[] jpq;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aiB = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.jpi = (GroupImageView) view.findViewById(R.id.item_head);
        this.jpj = (TextView) view.findViewById(R.id.item_group_name);
        this.jpk = (TextView) view.findViewById(R.id.item_group_meizi);
        this.jpl = (TextView) view.findViewById(R.id.item_group_num);
        this.jpm = (TextView) view.findViewById(R.id.item_introduce);
        this.jpn = (ImageView) view.findViewById(R.id.item_grade1);
        this.jpo = (ImageView) view.findViewById(R.id.item_grade2);
        this.jpp = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.jpq = new ImageView[4];
        this.jpq[1] = this.jpn;
        this.jpq[2] = this.jpo;
        this.jpq[3] = this.jpp;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.jpi.setTag(null);
            this.jpi.setDrawBorder(true);
            this.jpi.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.jpi.setTag(portrait);
                this.jpi.startLoad(portrait, 10, false);
            }
            this.jpj.setText(groupInfoData.getName());
            this.jpk.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.jpl.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.jpm.setText(groupInfoData.getIntro().trim());
            a(this.jpq, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.jpj, R.color.common_color_10009, 1);
                ap.setImageResource(this.jpn, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jpo, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.jpp, R.drawable.icon_vip_grade_big_small_s);
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
