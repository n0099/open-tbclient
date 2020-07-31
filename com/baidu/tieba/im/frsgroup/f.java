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
    public GroupImageView jag;
    public TextView jah;
    public TextView jai;
    public TextView jaj;
    public TextView jak;
    public ImageView jal;
    public ImageView jam;
    public ImageView jan;
    public ImageView[] jao;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aho = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.jag = (GroupImageView) view.findViewById(R.id.item_head);
        this.jah = (TextView) view.findViewById(R.id.item_group_name);
        this.jai = (TextView) view.findViewById(R.id.item_group_meizi);
        this.jaj = (TextView) view.findViewById(R.id.item_group_num);
        this.jak = (TextView) view.findViewById(R.id.item_introduce);
        this.jal = (ImageView) view.findViewById(R.id.item_grade1);
        this.jam = (ImageView) view.findViewById(R.id.item_grade2);
        this.jan = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.jao = new ImageView[4];
        this.jao[1] = this.jal;
        this.jao[2] = this.jam;
        this.jao[3] = this.jan;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.jag.setTag(null);
            this.jag.setDrawBorder(true);
            this.jag.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.jag.setTag(portrait);
                this.jag.startLoad(portrait, 10, false);
            }
            this.jah.setText(groupInfoData.getName());
            this.jai.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.jaj.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.jak.setText(groupInfoData.getIntro().trim());
            a(this.jao, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                ao.setViewTextColor(this.jah, R.color.common_color_10009, 1);
                ao.setImageResource(this.jal, R.drawable.icon_vip_grade_big_small_s);
                ao.setImageResource(this.jam, R.drawable.icon_vip_grade_big_small_s);
                ao.setImageResource(this.jan, R.drawable.icon_vip_grade_big_small_s);
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
