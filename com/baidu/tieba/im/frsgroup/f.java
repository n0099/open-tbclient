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
    public int csg;
    public View dividerLine;
    public GroupImageView gGi;
    public TextView gGj;
    public TextView gGk;
    public TextView gGl;
    public TextView gGm;
    public ImageView gGn;
    public ImageView gGo;
    public ImageView gGp;
    public ImageView[] gGq;
    public View rootView;

    public f(View view, View.OnClickListener onClickListener) {
        super(view);
        this.csg = 3;
        this.rootView = view;
        this.rootView.setOnClickListener(onClickListener);
        this.gGi = (GroupImageView) view.findViewById(R.id.item_head);
        this.gGj = (TextView) view.findViewById(R.id.item_group_name);
        this.gGk = (TextView) view.findViewById(R.id.item_group_meizi);
        this.gGl = (TextView) view.findViewById(R.id.item_group_num);
        this.gGm = (TextView) view.findViewById(R.id.item_introduce);
        this.gGn = (ImageView) view.findViewById(R.id.item_grade1);
        this.gGo = (ImageView) view.findViewById(R.id.item_grade2);
        this.gGp = (ImageView) view.findViewById(R.id.item_grade3);
        this.dividerLine = view.findViewById(R.id.divider_line);
        this.gGq = new ImageView[4];
        this.gGq[1] = this.gGn;
        this.gGq[2] = this.gGo;
        this.gGq[3] = this.gGp;
    }

    public void a(GroupInfoData groupInfoData) {
        if (groupInfoData != null) {
            this.gGi.setTag(null);
            this.gGi.setDrawBorder(true);
            this.gGi.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                this.gGi.setTag(portrait);
                this.gGi.startLoad(portrait, 10, false);
            }
            this.gGj.setText(groupInfoData.getName());
            this.gGk.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
            this.gGl.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            this.gGm.setText(groupInfoData.getIntro().trim());
            a(this.gGq, groupInfoData.getGrade());
            if (groupInfoData.isMemGroup()) {
                am.setViewTextColor(this.gGj, R.color.common_color_10009, 1);
                am.setImageResource(this.gGn, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.gGo, R.drawable.icon_vip_grade_big_small_s);
                am.setImageResource(this.gGp, R.drawable.icon_vip_grade_big_small_s);
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
