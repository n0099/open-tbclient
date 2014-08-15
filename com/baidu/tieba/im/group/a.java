package com.baidu.tieba.im.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context a;
    private ArrayList<c> b = new ArrayList<>();
    private int[] c = {t.icon_nearby_group, t.icon_qr_code, t.icon_add_group};
    private int[] d = {x.nearby_group_title, x.qr_code, x.group_tab_addgroup};
    private int[] e = {0, 1, 2};
    private int f = 0;
    private String g = "";

    public a(Context context) {
        this.a = context;
        if (TbadkApplication.m252getInst().isNearByGroupOpen()) {
            this.b.clear();
            for (int i = 0; i < this.c.length; i++) {
                this.b.add(new c(this.d[i], this.c[i], "", this.e[i]));
            }
            return;
        }
        this.b.clear();
        for (int i2 = 1; i2 < this.c.length; i2++) {
            this.b.add(new c(this.d[i2], this.c[i2], "", this.e[i2]));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c getItem(int i) {
        if (i < this.b.size()) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(v.discover_group_item, viewGroup, false);
            bVar = new b(this, null);
            bVar.a = (HeadImageView) view.findViewById(u.portrait);
            bVar.b = (TextView) view.findViewById(u.title);
            bVar.c = (TextView) view.findViewById(u.description);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.a.setImageResource(this.b.get(i).b());
        bVar.b.setText(this.b.get(i).a());
        bVar.c.setText(c(this.b.get(i).c()));
        int skinType = TbadkApplication.m252getInst().getSkinType();
        DiscoverGroupActivity discoverGroupActivity = (DiscoverGroupActivity) this.a;
        discoverGroupActivity.getLayoutMode().a(skinType == 1);
        discoverGroupActivity.getLayoutMode().a(view);
        return view;
    }

    public void b(int i) {
        this.f = i;
        notifyDataSetChanged();
    }

    public void a(String str) {
        this.g = str;
    }

    public ArrayList<c> a() {
        return this.b;
    }

    private String c(int i) {
        switch (i) {
            case 0:
                return this.a.getString(x.nearbygroup_description, this.g, String.valueOf(this.f));
            case 1:
                return this.a.getString(x.qrcode_description);
            case 2:
                return this.a.getString(x.addgroup_description);
            default:
                return null;
        }
    }
}
