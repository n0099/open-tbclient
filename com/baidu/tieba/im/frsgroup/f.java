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
    public int cdL;
    public View dividerLine;
    public GroupImageView gGr;
    public TextView gGs;
    public TextView gGt;
    public TextView gGu;
    public TextView gGv;
    public ImageView gGw;
    public ImageView gGx;
    public ImageView gGy;
    public ImageView[] gGz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.cdL = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gGr = (GroupImageView) view.findViewById(R.id.item_head);
        this.gGs = (TextView) view.findViewById(R.id.item_group_name);
        this.gGt = (TextView) view.findViewById(R.id.item_group_meizi);
        this.gGu = (TextView) view.findViewById(R.id.item_group_num);
        this.gGv = (TextView) view.findViewById(R.id.item_introduce);
        this.gGw = (ImageView) view.findViewById(R.id.item_grade1);
        this.gGx = (ImageView) view.findViewById(R.id.item_grade2);
        this.gGy = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.gGz = new ImageView[4];
        this.gGz[1] = this.gGw;
        this.gGz[2] = this.gGx;
        this.gGz[3] = this.gGy;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gGr.setTag(null);
            this.gGr.setDrawBorder(true);
            this.gGr.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gGr.setTag(portrait);
                this.gGr.startLoad(portrait, 10, false);
            }
            this.gGs.setText(groupInfoData.getName());
            this.gGt.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gGu.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gGv.setText(groupInfoData.getIntro().trim());
            a(this.gGz, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.f(this.gGs, R.color.common_color_10009, 1);
                am.c(this.gGw, (int) R.drawable.icon_vip_grade_big_small_s);
                am.c(this.gGx, (int) R.drawable.icon_vip_grade_big_small_s);
                am.c(this.gGy, (int) R.drawable.icon_vip_grade_big_small_s);
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
