package com.baidu.tbplugin.app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbplugin.a.c;
import com.baidu.tbplugin.a.d;
import com.baidu.tbplugin.a.e;
import com.baidu.tbplugin.f;
import com.baidu.tbplugin.m;
import com.baidu.tbplugin.n;
import java.util.List;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
class a extends BaseAdapter {
    final /* synthetic */ PluginsActivity a;
    private List<Class<?>> b;

    public a(PluginsActivity pluginsActivity, List<Class<?>> list) {
        this.a = pluginsActivity;
        this.b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tbplugin.a.a aVar;
        d dVar;
        if (view == null) {
            view = View.inflate(this.a, n.plugin_item, null);
            b bVar = new b(null);
            bVar.a = (TextView) view.findViewById(m.name);
            bVar.b = (TextView) view.findViewById(m.version);
            bVar.c = (TextView) view.findViewById(m.jar);
            bVar.d = (TextView) view.findViewById(m.so);
            bVar.e = (TextView) view.findViewById(m.res);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        Class cls = (Class) getItem(i);
        bVar2.a.setText(((c) f.a(cls, c.class)).a());
        int[] a = ((e) f.a(cls, e.class)).a();
        StringBuilder sb = new StringBuilder();
        for (int i2 : a) {
            sb.append(i2);
            sb.append(",");
        }
        bVar2.b.setText("Versions:" + sb.toString().substring(0, sb.toString().length() - 1));
        if (((com.baidu.tbplugin.a.a) f.a(cls, com.baidu.tbplugin.a.a.class)) != null) {
            bVar2.c.setVisibility(0);
            bVar2.c.setText("Library:\n " + aVar.a());
        } else {
            bVar2.c.setVisibility(8);
        }
        if (((d) f.a(cls, d.class)) != null) {
            bVar2.e.setVisibility(0);
            bVar2.e.setText("Resources:\n " + dVar.a());
        } else {
            bVar2.e.setVisibility(8);
        }
        com.baidu.tbplugin.a.b bVar3 = (com.baidu.tbplugin.a.b) f.a(cls, com.baidu.tbplugin.a.b.class);
        if (bVar3 != null) {
            bVar2.d.setVisibility(0);
            String[] a2 = bVar3.a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NativeLibrary:\n");
            for (String str : a2) {
                sb2.append(str);
                sb2.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            bVar2.d.setText(sb2.toString());
        } else {
            bVar2.d.setVisibility(8);
        }
        return view;
    }
}
