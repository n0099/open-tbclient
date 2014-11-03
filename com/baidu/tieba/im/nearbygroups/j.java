package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class j implements a {
    private NearbyGroupsActivity bgr;
    private int mType;
    private LinearLayout mParent = null;
    private TextView Hm = null;
    private Button bgw = null;
    private View ay = null;

    public j(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        this.bgr = null;
        this.bgr = nearbyGroupsActivity;
        this.mType = i;
        init();
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public View getView() {
        return this.ay;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public void b(int i, Object obj) {
    }

    public void init() {
        this.ay = com.baidu.adp.lib.g.b.ek().inflate(this.bgr, w.nearby_group_guide, null);
        this.mParent = (LinearLayout) this.ay.findViewById(v.guide_parent);
        this.Hm = (TextView) this.ay.findViewById(v.guide_tip);
        this.bgw = (Button) this.ay.findViewById(v.guide_setting);
        this.bgw.setOnClickListener(this.bgr);
        if (this.mType == 2) {
            this.Hm.setText(y.nearby_group_gps_no_data);
            this.bgw.setVisibility(8);
        } else if (this.mType == 0) {
            this.Hm.setText(y.nearby_group_gps_close);
            this.bgw.setVisibility(0);
        } else if (this.mType == 1) {
            this.Hm.setText(y.nearby_group_gps_error);
            this.bgw.setVisibility(8);
        }
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
