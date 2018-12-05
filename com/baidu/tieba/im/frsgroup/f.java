package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupInfoData;
/* loaded from: classes3.dex */
public class f extends q.a {
    public int aLF;
    public View dividerLine;
    public GroupImageView ePr;
    public TextView ePs;
    public TextView ePt;
    public TextView ePu;
    public TextView ePv;
    public ImageView ePw;
    public ImageView ePx;
    public ImageView ePy;
    public ImageView[] ePz;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.aLF = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.ePr = (GroupImageView) view.findViewById(e.g.item_head);
        this.ePs = (TextView) view.findViewById(e.g.item_group_name);
        this.ePt = (TextView) view.findViewById(e.g.item_group_meizi);
        this.ePu = (TextView) view.findViewById(e.g.item_group_num);
        this.ePv = (TextView) view.findViewById(e.g.item_introduce);
        this.ePw = (ImageView) view.findViewById(e.g.item_grade1);
        this.ePx = (ImageView) view.findViewById(e.g.item_grade2);
        this.ePy = (ImageView) view.findViewById(e.g.item_grade3);
        this.dividerLine = view.findViewById(e.g.divider_line);
        this.ePz = new ImageView[4];
        this.ePz[1] = this.ePw;
        this.ePz[2] = this.ePx;
        this.ePz[3] = this.ePy;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.ePr.setTag(null);
            this.ePr.setDrawBorder(true);
            this.ePr.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.ePr.setTag(portrait);
                this.ePr.startLoad(portrait, 10, false);
            }
            this.ePs.setText(groupInfoData.getName());
            this.ePt.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.ePu.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.ePv.setText(groupInfoData.getIntro().trim());
            a(this.ePz, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                al.c(this.ePs, e.d.common_color_10009, 1);
                al.c(this.ePw, e.f.icon_vip_grade_big_small_s);
                al.c(this.ePx, e.f.icon_vip_grade_big_small_s);
                al.c(this.ePy, e.f.icon_vip_grade_big_small_s);
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
