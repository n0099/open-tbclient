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
/* loaded from: classes5.dex */
public class f extends v.a {
    public int ceL;
    public View dividerLine;
    public GroupImageView gJb;
    public TextView gJc;
    public TextView gJd;
    public TextView gJe;
    public TextView gJf;
    public ImageView gJg;
    public ImageView gJh;
    public ImageView gJi;
    public ImageView[] gJj;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.ceL = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gJb = (GroupImageView) view.findViewById(R.id.item_head);
        this.gJc = (TextView) view.findViewById(R.id.item_group_name);
        this.gJd = (TextView) view.findViewById(R.id.item_group_meizi);
        this.gJe = (TextView) view.findViewById(R.id.item_group_num);
        this.gJf = (TextView) view.findViewById(R.id.item_introduce);
        this.gJg = (ImageView) view.findViewById(R.id.item_grade1);
        this.gJh = (ImageView) view.findViewById(R.id.item_grade2);
        this.gJi = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.gJj = new ImageView[4];
        this.gJj[1] = this.gJg;
        this.gJj[2] = this.gJh;
        this.gJj[3] = this.gJi;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gJb.setTag(null);
            this.gJb.setDrawBorder(true);
            this.gJb.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gJb.setTag(portrait);
                this.gJb.startLoad(portrait, 10, false);
            }
            this.gJc.setText(groupInfoData.getName());
            this.gJd.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gJe.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gJf.setText(groupInfoData.getIntro().trim());
            a(this.gJj, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.f(this.gJc, R.color.common_color_10009, 1);
                am.c(this.gJg, (int) R.drawable.icon_vip_grade_big_small_s);
                am.c(this.gJh, (int) R.drawable.icon_vip_grade_big_small_s);
                am.c(this.gJi, (int) R.drawable.icon_vip_grade_big_small_s);
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
