package com.baidu.tieba.im.nearbygroups;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class j implements a {
    private NearbyGroupsActivity d;
    private int f;
    private LinearLayout a = null;
    private TextView b = null;
    private Button c = null;
    private View e = null;

    public j(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        this.d = null;
        this.d = nearbyGroupsActivity;
        this.f = i;
        b();
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public View a() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public void a(int i, Object obj) {
    }

    public void b() {
        this.e = com.baidu.adp.lib.e.b.a().a(this.d, v.nearby_group_guide, null);
        this.a = (LinearLayout) this.e.findViewById(u.guide_parent);
        this.b = (TextView) this.e.findViewById(u.guide_tip);
        this.c = (Button) this.e.findViewById(u.guide_setting);
        this.c.setOnClickListener(this.d);
        if (this.f == 2) {
            this.b.setText(x.nearby_group_gps_no_data);
            this.c.setVisibility(8);
        } else if (this.f == 0) {
            this.b.setText(x.nearby_group_gps_close);
            this.c.setVisibility(0);
        } else if (this.f == 1) {
            this.b.setText(x.nearby_group_gps_error);
            this.c.setVisibility(8);
        }
        c();
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a((View) this.a);
    }

    public void c() {
        a(TbadkApplication.m252getInst().getSkinType());
    }
}
