package com.baidu.tieba.im.nearbygroups;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i implements a {
    private NearbyGroupsActivity d;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f1850a = null;
    private TextView b = null;
    private TextView c = null;
    private View e = null;

    public i(NearbyGroupsActivity nearbyGroupsActivity) {
        this.d = null;
        this.d = nearbyGroupsActivity;
        b();
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public View a() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public void a(int i, Object obj) {
        if (obj instanceof com.baidu.tieba.im.data.c) {
            this.c.setText(((com.baidu.tieba.im.data.c) obj).a());
            this.b.setVisibility(8);
        }
    }

    public void b() {
        this.e = LayoutInflater.from(this.d).inflate(R.layout.im_group_list_group, (ViewGroup) null);
        this.b = (TextView) this.e.findViewById(R.id.tv_group_line_top);
        this.f1850a = (LinearLayout) this.e.findViewById(R.id.list_group);
        this.c = (TextView) this.e.findViewById(R.id.tv_group_name);
        c();
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.f1850a);
        if (i == 1) {
            this.c.setTextColor(this.d.getResources().getColor(R.color.common_list_text_1));
            b(R.drawable.icon_list_small_lbs_1);
            return;
        }
        this.c.setTextColor(this.d.getResources().getColor(R.color.common_list_text));
        b(R.drawable.icon_list_small_lbs);
    }

    private void b(int i) {
        Drawable drawable = this.d.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.c.setCompoundDrawables(drawable, null, null, null);
    }

    public void c() {
        a(TiebaApplication.h().an());
    }
}
