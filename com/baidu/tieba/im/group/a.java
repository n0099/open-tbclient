package com.baidu.tieba.im.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private Context a;
    private final int[] b = {u.icon_nearby_group, u.icon_qr_code, u.icon_add_group};
    private final int[] c = {y.nearby_group_title, y.qr_code, y.group_tab_addgroup};
    private int d = 0;
    private String e = "";

    public a(Context context) {
        this.a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
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
            view = LayoutInflater.from(this.a).inflate(w.discover_group_item, viewGroup, false);
            b bVar2 = new b(this, null);
            bVar2.a = (HeadImageView) view.findViewById(v.portrait);
            bVar2.b = (TextView) view.findViewById(v.title);
            bVar2.c = (TextView) view.findViewById(v.description);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.a.setImageResource(this.b[i]);
        bVar.b.setText(this.c[i]);
        bVar.c.setText(b(i));
        int skinType = TbadkApplication.m252getInst().getSkinType();
        DiscoverGroupActivity discoverGroupActivity = (DiscoverGroupActivity) this.a;
        discoverGroupActivity.getLayoutMode().a(skinType == 1);
        discoverGroupActivity.getLayoutMode().a(view);
        return view;
    }

    public void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public void a(String str) {
        this.e = str;
    }

    private String b(int i) {
        switch (i) {
            case 0:
                return this.a.getString(y.nearbygroup_description, this.e, String.valueOf(this.d));
            case 1:
                return this.a.getString(y.qrcode_description);
            case 2:
                return this.a.getString(y.addgroup_description);
            default:
                return null;
        }
    }
}
