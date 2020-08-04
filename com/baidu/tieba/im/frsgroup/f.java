package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes17.dex */
public class f extends ad.a {
    public int aho;
    public View dividerLine;
    public GroupImageView jai;
    public TextView jaj;
    public TextView jak;
    public TextView jal;
    public TextView jam;
    public ImageView jan;
    public ImageView jao;
    public ImageView jap;
    public ImageView[] jaq;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aho = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.jai = (GroupImageView) view.findViewById(R.id.item_head);
        this.jaj = (TextView) view.findViewById(R.id.item_group_name);
        this.jak = (TextView) view.findViewById(R.id.item_group_meizi);
        this.jal = (TextView) view.findViewById(R.id.item_group_num);
        this.jam = (TextView) view.findViewById(R.id.item_introduce);
        this.jan = (ImageView) view.findViewById(R.id.item_grade1);
        this.jao = (ImageView) view.findViewById(R.id.item_grade2);
        this.jap = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.jaq = new ImageView[4];
        this.jaq[1] = this.jan;
        this.jaq[2] = this.jao;
        this.jaq[3] = this.jap;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.jai.setTag(null);
            this.jai.setDrawBorder(true);
            this.jai.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.jai.setTag(portrait);
                this.jai.startLoad(portrait, 10, false);
            }
            this.jaj.setText(groupInfoData.getName());
            this.jak.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.jal.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.jam.setText(groupInfoData.getIntro().trim());
            a(this.jaq, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ao.setViewTextColor(this.jaj, R.color.common_color_10009, 1);
                ao.setImageResource(this.jan, R.drawable.icon_vip_grade_big_small_s);
                ao.setImageResource(this.jao, R.drawable.icon_vip_grade_big_small_s);
                ao.setImageResource(this.jap, R.drawable.icon_vip_grade_big_small_s);
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
