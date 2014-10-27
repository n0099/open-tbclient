package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class l implements a {
    private ImageView aWA;
    private ImageView[] aWB;
    private GroupImageView aWt;
    private TextView aWu;
    private TextView aWw;
    private TextView aWx;
    private ImageView aWy;
    private ImageView aWz;
    private NearbyGroupsActivity bgd;
    private TextView bgk;
    private TextView bgl;
    private TextView bgm;
    private LinearLayout bgn;
    private TextView bgo;
    private TextView bgp;
    private TextView bgq;
    private LinearLayout mParent = null;
    private View ay = null;
    private DecimalFormat bgr = new DecimalFormat("#.#");

    public l(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgd = null;
        this.bgd = nearbyGroupsActivity;
        init();
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public View getView() {
        return this.ay;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public void b(int i, Object obj) {
        if (obj instanceof com.baidu.tieba.im.data.d) {
            com.baidu.tieba.im.data.d dVar = (com.baidu.tieba.im.data.d) obj;
            this.bgn.setTag(dVar.getGroupId());
            this.aWu.setText(dVar.getName());
            this.aWw.setText(String.valueOf(dVar.getMemberNum()) + "/" + dVar.getMaxMemberNum());
            this.aWx.setText(dVar.getIntro());
            String portrait = dVar.getPortrait();
            this.aWt.setTag(null);
            this.aWt.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            this.aWt.setDrawBorder(true);
            if (!TextUtils.isEmpty(portrait)) {
                this.aWt.setTag(portrait);
            }
            this.aWt.c(portrait, 10, false);
            if (dVar.isMemGroup()) {
                aw.b(this.aWu, s.im_group_vip_text, 1);
            } else {
                this.bgd.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
                this.bgd.getLayoutMode().h(this.aWu);
            }
            a(this.aWB, dVar.getGrade(), dVar.isMemGroup());
            String gi = gi(dVar.Mk());
            this.bgl.setText(gi);
            this.bgm.setText(gi);
            if (dVar.Mj()) {
                this.bgo.setVisibility(0);
                this.bgl.setVisibility(0);
                this.bgm.setVisibility(8);
            } else {
                this.bgo.setVisibility(8);
                this.bgl.setVisibility(8);
                this.bgm.setVisibility(0);
            }
            if (dVar.Ml()) {
                this.bgp.setVisibility(0);
            } else {
                this.bgp.setVisibility(8);
            }
            if (dVar.Mm()) {
                this.bgq.setVisibility(0);
            } else {
                this.bgq.setVisibility(8);
            }
        }
    }

    private String gi(int i) {
        if (i >= 0 && i < 1000) {
            int i2 = i / 100;
            if (i2 == 9) {
                return "<1km";
            }
            return "<" + (i2 + 1) + "00m";
        }
        return String.valueOf(this.bgr.format(i / 1000.0d)) + "km";
    }

    private void a(ImageView[] imageViewArr, int i, boolean z) {
        if (z) {
            aw.c(imageViewArr[1], u.icon_vip_grade_big_small_s);
            aw.c(imageViewArr[2], u.icon_vip_grade_big_small_s);
            aw.c(imageViewArr[3], u.icon_vip_grade_big_small_s);
        } else {
            this.bgd.getLayoutMode().h(imageViewArr[1]);
            this.bgd.getLayoutMode().h(imageViewArr[2]);
            this.bgd.getLayoutMode().h(imageViewArr[3]);
        }
        int i2 = i < 0 ? 0 : i;
        if (i2 > 3) {
            i2 = 3;
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            if (i3 <= i2) {
                imageViewArr[i3].setVisibility(0);
            } else {
                imageViewArr[i3].setVisibility(8);
            }
        }
    }

    public void init() {
        this.ay = com.baidu.adp.lib.g.b.ek().inflate(this.bgd, w.im_group_list_item, null);
        this.mParent = (LinearLayout) this.ay.findViewById(v.list_item);
        this.bgo = (TextView) this.ay.findViewById(v.isMeizi);
        this.bgp = (TextView) this.ay.findViewById(v.isNewCreate);
        this.bgq = (TextView) this.ay.findViewById(v.isRecentlyReplay);
        this.bgn = (LinearLayout) this.ay.findViewById(v.list_item_content);
        this.bgk = (TextView) this.ay.findViewById(v.tv_im_line_bottom);
        this.bgl = (TextView) this.ay.findViewById(v.tv_distance);
        this.bgm = (TextView) this.ay.findViewById(v.tv_top_distance);
        this.aWt = (GroupImageView) this.ay.findViewById(v.item_head);
        this.aWu = (TextView) this.ay.findViewById(v.item_group_name);
        this.aWw = (TextView) this.ay.findViewById(v.item_group_num);
        this.aWx = (TextView) this.ay.findViewById(v.item_introduce);
        this.aWy = (ImageView) this.ay.findViewById(v.item_grade1);
        this.aWz = (ImageView) this.ay.findViewById(v.item_grade2);
        this.aWA = (ImageView) this.ay.findViewById(v.item_grade3);
        this.aWB = new ImageView[4];
        this.aWB[1] = this.aWy;
        this.aWB[2] = this.aWz;
        this.aWB[3] = this.aWA;
        this.bgn.setOnClickListener(this.bgd);
        this.bgk.setVisibility(0);
        QZ();
    }

    public void onChangeSkinType(int i) {
        this.bgd.getLayoutMode().L(i == 1);
        this.bgd.getLayoutMode().h(this.mParent);
    }

    public void QZ() {
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }
}
