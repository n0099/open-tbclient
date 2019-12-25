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
/* loaded from: classes7.dex */
public class f extends v.a {
    public int MA;
    public View dividerLine;
    public GroupImageView hum;
    public TextView hun;
    public TextView huo;
    public TextView hup;
    public TextView huq;
    public ImageView hur;
    public ImageView hus;
    public ImageView hut;
    public ImageView[] huu;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.MA = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.hum = (GroupImageView) view.findViewById(R.id.item_head);
        this.hun = (TextView) view.findViewById(R.id.item_group_name);
        this.huo = (TextView) view.findViewById(R.id.item_group_meizi);
        this.hup = (TextView) view.findViewById(R.id.item_group_num);
        this.huq = (TextView) view.findViewById(R.id.item_introduce);
        this.hur = (ImageView) view.findViewById(R.id.item_grade1);
        this.hus = (ImageView) view.findViewById(R.id.item_grade2);
        this.hut = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.huu = new ImageView[4];
        this.huu[1] = this.hur;
        this.huu[2] = this.hus;
        this.huu[3] = this.hut;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.hum.setTag(null);
            this.hum.setDrawBorder(true);
            this.hum.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.hum.setTag(portrait);
                this.hum.startLoad(portrait, 10, false);
            }
            this.hun.setText(groupInfoData.getName());
            this.huo.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.hup.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.huq.setText(groupInfoData.getIntro().trim());
            a(this.huu, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.hun, R.color.common_color_10009, 1);
                am.setImageResource(this.hur, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hus, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.hut, R.drawable.icon_vip_grade_big_small_s);
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
