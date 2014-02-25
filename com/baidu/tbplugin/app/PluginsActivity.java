package com.baidu.tbplugin.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tbplugin.j;
import com.baidu.tbplugin.m;
import com.baidu.tbplugin.n;
import java.util.List;
/* loaded from: classes.dex */
public class PluginsActivity extends Activity implements View.OnClickListener {
    private ListView a;
    private View b;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.plugins_activity);
        findViewById(m.all).setOnClickListener(this);
        findViewById(m.assets).setOnClickListener(this);
        findViewById(m.installed).setOnClickListener(this);
        this.a = (ListView) findViewById(m.list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<Class<?>> a;
        int id = view.getId();
        if (id == m.all) {
            a = j.a().b().a(1);
        } else if (id == m.assets) {
            a = j.a().b().a(2);
        } else {
            a = id == m.installed ? j.a().b().a(3) : null;
        }
        if (a != null) {
            this.a.setAdapter((ListAdapter) new a(this, a));
        } else {
            this.a.setAdapter((ListAdapter) null);
        }
        view.setBackgroundColor(-1);
        if (this.b != null) {
            this.b.setBackgroundColor(0);
        }
        this.b = view;
    }
}
