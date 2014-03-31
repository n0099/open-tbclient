package com.baidu.tieba.im.nearbygroups;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class k implements a {
    private LinearLayout a;
    private TextView b;
    private TextView c;
    private NearbyGroupsActivity d;
    private View e;

    public k(NearbyGroupsActivity nearbyGroupsActivity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.d = nearbyGroupsActivity;
        this.e = LayoutInflater.from(this.d).inflate(com.baidu.tieba.im.i.im_group_list_group, (ViewGroup) null);
        this.b = (TextView) this.e.findViewById(com.baidu.tieba.im.h.tv_group_line_top);
        this.a = (LinearLayout) this.e.findViewById(com.baidu.tieba.im.h.list_group);
        this.c = (TextView) this.e.findViewById(com.baidu.tieba.im.h.tv_group_name);
        int l = TbadkApplication.j().l();
        this.d.getLayoutMode().a(l == 1);
        this.d.getLayoutMode().a(this.a);
        if (l == 1) {
            this.c.setTextColor(this.d.getResources().getColor(com.baidu.tieba.im.e.common_list_text_1));
            a(com.baidu.tieba.im.g.icon_list_small_lbs_1);
            return;
        }
        this.c.setTextColor(this.d.getResources().getColor(com.baidu.tieba.im.e.common_list_text));
        a(com.baidu.tieba.im.g.icon_list_small_lbs);
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public final View a() {
        return this.e;
    }

    @Override // com.baidu.tieba.im.nearbygroups.a
    public final void a(Object obj) {
        if (obj instanceof com.baidu.tieba.im.data.e) {
            this.c.setText(((com.baidu.tieba.im.data.e) obj).a());
            this.b.setVisibility(8);
        }
    }

    private void a(int i) {
        Drawable drawable = this.d.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.c.setCompoundDrawables(drawable, null, null, null);
    }
}
