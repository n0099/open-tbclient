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
    public ImageView[] ktA;
    public GroupImageView kts;
    public TextView ktt;
    public TextView ktu;
    public TextView ktv;
    public TextView ktw;
    public ImageView ktx;
    public ImageView kty;
    public ImageView ktz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aku = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.kts = (GroupImageView) view.findViewById(R.id.item_head);
        this.ktt = (TextView) view.findViewById(R.id.item_group_name);
        this.ktu = (TextView) view.findViewById(R.id.item_group_meizi);
        this.ktv = (TextView) view.findViewById(R.id.item_group_num);
        this.ktw = (TextView) view.findViewById(R.id.item_introduce);
        this.ktx = (ImageView) view.findViewById(R.id.item_grade1);
        this.kty = (ImageView) view.findViewById(R.id.item_grade2);
        this.ktz = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.ktA = new ImageView[4];
        this.ktA[1] = this.ktx;
        this.ktA[2] = this.kty;
        this.ktA[3] = this.ktz;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.kts.setTag(null);
            this.kts.setDrawBorder(true);
            this.kts.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.kts.setTag(portrait);
                this.kts.startLoad(portrait, 10, false);
            }
            this.ktt.setText(groupInfoData.getName());
            this.ktu.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.ktv.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.ktw.setText(groupInfoData.getIntro().trim());
            a(this.ktA, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ap.setViewTextColor(this.ktt, R.color.common_color_10009, 1);
                ap.setImageResource(this.ktx, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.kty, R.drawable.icon_vip_grade_big_small_s);
                ap.setImageResource(this.ktz, R.drawable.icon_vip_grade_big_small_s);
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
