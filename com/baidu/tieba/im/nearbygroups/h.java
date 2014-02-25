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
public class h implements a {
    private NearbyGroupsActivity d;
    private int f;
    private LinearLayout a = null;
    private TextView b = null;
    private Button c = null;
    private View e = null;

    public h(NearbyGroupsActivity nearbyGroupsActivity, int i) {
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
        c();
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a((View) this.a);
    }

    public void c() {
        a(TiebaApplication.g().al());
    }
}
