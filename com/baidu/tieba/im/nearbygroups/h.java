package com.baidu.tieba.im.nearbygroups;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class h implements a {
    private LinearLayout a;
    private TextView b;
    private Button c;
    private NearbyGroupsActivity d;
    private View e;
    private int f;

    public h(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.d = nearbyGroupsActivity;
        this.f = i;
        this.e = LayoutInflater.from(this.d).inflate(R.layout.nearby_group_guide, (ViewGroup) null);
        this.a = (LinearLayout) this.e.findViewById(R.id.guide_parent);
        this.b = (TextView) this.e.findViewById(R.id.guide_tip);
        this.c = (Button) this.e.findViewById(R.id.guide_setting);
        this.c.setOnClickListener(this.d);
        if (this.f == 2) {
            this.b.setText(R.string.nearby_group_gps_no_data);
            this.c.setVisibility(8);
        } else if (this.f == 0) {
            this.b.setText(R.string.nearby_group_gps_close);
            this.c.setVisibility(0);
        } else if (this.f == 1) {
            this.b.setText(R.string.nearby_group_gps_error);
            this.c.setVisibility(8);
        }
        this.d.getLayoutMode().a(TiebaApplication.g().ae() == 1);
        this.d.getLayoutMode().a(this.a);
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public final View a() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public final void a(Object obj) {
    }
}
