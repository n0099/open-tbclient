package com.baidu.tieba.im.nearbygroups;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class k implements a {
    private NearbyGroupsActivity d;
    private LinearLayout a = null;
    private TextView b = null;
    private TextView c = null;
    private View e = null;

    public k(NearbyGroupsActivity nearbyGroupsActivity) {
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
        if (obj instanceof com.baidu.tieba.im.data.j) {
            this.c.setText(((com.baidu.tieba.im.data.j) obj).a());
            this.b.setVisibility(8);
        }
    }

    public void b() {
        this.e = LayoutInflater.from(this.d).inflate(s.im_group_list_group, (ViewGroup) null);
        this.b = (TextView) this.e.findViewById(r.tv_group_line_top);
        this.a = (LinearLayout) this.e.findViewById(r.list_group);
        this.c = (TextView) this.e.findViewById(r.tv_group_name);
        c();
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a((View) this.a);
        if (i == 1) {
            this.c.setTextColor(this.d.getResources().getColor(o.common_list_text_1));
            b(q.icon_list_small_lbs_1);
            return;
        }
        this.c.setTextColor(this.d.getResources().getColor(o.common_list_text));
        b(q.icon_list_small_lbs);
    }

    private void b(int i) {
        Drawable drawable = this.d.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.c.setCompoundDrawables(drawable, null, null, null);
    }

    public void c() {
        a(TbadkApplication.m252getInst().getSkinType());
    }
}
