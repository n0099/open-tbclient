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
    private GroupImageView aWH;
    private TextView aWI;
    private TextView aWK;
    private TextView aWL;
    private ImageView aWM;
    private ImageView aWN;
    private ImageView aWO;
    private ImageView[] aWP;
    private TextView bgA;
    private LinearLayout bgB;
    private TextView bgC;
    private TextView bgD;
    private TextView bgE;
    private NearbyGroupsActivity bgr;
    private TextView bgy;
    private TextView bgz;
    private LinearLayout mParent = null;
    private View ay = null;
    private DecimalFormat bgF = new DecimalFormat("#.#");

    public l(NearbyGroupsActivity nearbyGroupsActivity) {
        this.bgr = null;
        this.bgr = nearbyGroupsActivity;
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
            this.bgB.setTag(dVar.getGroupId());
            this.aWI.setText(dVar.getName());
            this.aWK.setText(String.valueOf(dVar.getMemberNum()) + "/" + dVar.getMaxMemberNum());
            this.aWL.setText(dVar.getIntro());
            String portrait = dVar.getPortrait();
            this.aWH.setTag(null);
            this.aWH.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
            this.aWH.setDrawBorder(true);
            if (!TextUtils.isEmpty(portrait)) {
                this.aWH.setTag(portrait);
            }
            this.aWH.c(portrait, 10, false);
            if (dVar.isMemGroup()) {
                aw.b(this.aWI, s.im_group_vip_text, 1);
            } else {
                this.bgr.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
                this.bgr.getLayoutMode().h(this.aWI);
            }
            a(this.aWP, dVar.getGrade(), dVar.isMemGroup());
            String gi = gi(dVar.Mo());
            this.bgz.setText(gi);
            this.bgA.setText(gi);
            if (dVar.Mn()) {
                this.bgC.setVisibility(0);
                this.bgz.setVisibility(0);
                this.bgA.setVisibility(8);
            } else {
                this.bgC.setVisibility(8);
                this.bgz.setVisibility(8);
                this.bgA.setVisibility(0);
            }
            if (dVar.Mp()) {
                this.bgD.setVisibility(0);
            } else {
                this.bgD.setVisibility(8);
            }
            if (dVar.Mq()) {
                this.bgE.setVisibility(0);
            } else {
                this.bgE.setVisibility(8);
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
        return String.valueOf(this.bgF.format(i / 1000.0d)) + "km";
    }

    private void a(ImageView[] imageViewArr, int i, boolean z) {
        if (z) {
            aw.c(imageViewArr[1], u.icon_vip_grade_big_small_s);
            aw.c(imageViewArr[2], u.icon_vip_grade_big_small_s);
            aw.c(imageViewArr[3], u.icon_vip_grade_big_small_s);
        } else {
            this.bgr.getLayoutMode().h(imageViewArr[1]);
            this.bgr.getLayoutMode().h(imageViewArr[2]);
            this.bgr.getLayoutMode().h(imageViewArr[3]);
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
        this.ay = com.baidu.adp.lib.g.b.ek().inflate(this.bgr, w.im_group_list_item, null);
        this.mParent = (LinearLayout) this.ay.findViewById(v.list_item);
        this.bgC = (TextView) this.ay.findViewById(v.isMeizi);
        this.bgD = (TextView) this.ay.findViewById(v.isNewCreate);
        this.bgE = (TextView) this.ay.findViewById(v.isRecentlyReplay);
        this.bgB = (LinearLayout) this.ay.findViewById(v.list_item_content);
        this.bgy = (TextView) this.ay.findViewById(v.tv_im_line_bottom);
        this.bgz = (TextView) this.ay.findViewById(v.tv_distance);
        this.bgA = (TextView) this.ay.findViewById(v.tv_top_distance);
        this.aWH = (GroupImageView) this.ay.findViewById(v.item_head);
        this.aWI = (TextView) this.ay.findViewById(v.item_group_name);
        this.aWK = (TextView) this.ay.findViewById(v.item_group_num);
        this.aWL = (TextView) this.ay.findViewById(v.item_introduce);
        this.aWM = (ImageView) this.ay.findViewById(v.item_grade1);
        this.aWN = (ImageView) this.ay.findViewById(v.item_grade2);
        this.aWO = (ImageView) this.ay.findViewById(v.item_grade3);
        this.aWP = new ImageView[4];
        this.aWP[1] = this.aWM;
        this.aWP[2] = this.aWN;
        this.aWP[3] = this.aWO;
        this.bgB.setOnClickListener(this.bgr);
        this.bgy.setVisibility(0);
        Rc();
    }

    public void onChangeSkinType(int i) {
        this.bgr.getLayoutMode().L(i == 1);
        this.bgr.getLayoutMode().h(this.mParent);
    }

    public void Rc() {
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }
}
