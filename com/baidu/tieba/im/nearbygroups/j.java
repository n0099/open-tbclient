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
    private NearbyGroupsActivity bgd;
    private int mType;
    private LinearLayout mParent = null;
    private TextView Hl = null;
    private Button bgi = null;
    private View ay = null;

    public j(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        this.bgd = null;
        this.bgd = nearbyGroupsActivity;
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
        this.ay = com.baidu.adp.lib.g.b.ek().inflate(this.bgd, w.nearby_group_guide, null);
        this.mParent = (LinearLayout) this.ay.findViewById(v.guide_parent);
        this.Hl = (TextView) this.ay.findViewById(v.guide_tip);
        this.bgi = (Button) this.ay.findViewById(v.guide_setting);
        this.bgi.setOnClickListener(this.bgd);
        if (this.mType == 2) {
            this.Hl.setText(y.nearby_group_gps_no_data);
            this.bgi.setVisibility(8);
        } else if (this.mType == 0) {
            this.Hl.setText(y.nearby_group_gps_close);
            this.bgi.setVisibility(0);
        } else if (this.mType == 1) {
            this.Hl.setText(y.nearby_group_gps_error);
            this.bgi.setVisibility(8);
        }
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
