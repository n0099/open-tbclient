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
    public int aku;
    public View dividerLine;
    public ImageView ktA;
    public ImageView ktB;
    public ImageView[] ktC;
    public GroupImageView ktu;
    public TextView ktv;
    public TextView ktw;
    public TextView ktx;
    public TextView kty;
    public ImageView ktz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aku = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.ktu = (GroupImageView) view.findViewById(R.id.item_head);
        this.ktv = (TextView) view.findViewById(R.id.item_group_name);
        this.ktw = (TextView) view.findViewById(R.id.item_group_meizi);
        this.ktx = (TextView) view.findViewById(R.id.item_group_num);
        this.kty = (TextView) view.findViewById(R.id.item_introduce);
        this.ktz = (ImageView) view.findViewById(R.id.item_grade1);
        this.ktA = (ImageView) view.findViewById(R.id.item_grade2);
        this.ktB = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.ktC = new ImageView[4];
        this.ktC[1] = this.ktz;
        this.ktC[2] = this.ktA;
        this.ktC[3] = this.ktB;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.ktu.setTag(null);
            this.ktu.setDrawBorder(true);
            this.ktu.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ktu.setTag(portrait);
                this.ktu.startLoad(portrait, 10, false);
            }
            this.ktv.setText(groupInfoData.getName());
            this.ktw.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.ktx.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.kty.setText(groupInfoData.getIntro().trim());
            a(this.ktC, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.ktv, R.color.common_color_10009, 1);
                ap.setImageResource(this.ktz, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.ktA, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.ktB, R.drawable.icon_vip_grade_big_small_s);
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
