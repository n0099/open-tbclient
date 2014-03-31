package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PrivilegeTabHost extends LinearLayout implements an {
    private LayoutInflater a;
    private PrivilegeTabContentView b;
    private PrivilegeTabWidgetView c;
    private ArrayList<ag> d;
    private int e;
    private int f;
    private Context g;
    private al h;

    public PrivilegeTabHost(Context context) {
        super(context);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = -1;
        this.h = new ak(this);
        a(context);
    }

    public PrivilegeTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = -1;
        this.h = new ak(this);
        a(context);
    }

    private void a(Context context) {
        this.g = context;
        removeAllViews();
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a.inflate(com.baidu.tieba.a.i.privilege_tab_host, (ViewGroup) this, true);
        this.b = (PrivilegeTabContentView) findViewById(com.baidu.tieba.a.h.privilege_tab_content);
        this.c = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.a.h.privilege_tab_widget);
        this.c.setOnTabSelectedListener(this);
        setOrientation(1);
        this.f = TbadkApplication.j().l();
        b(this.f);
        this.d.clear();
        this.d.add(new a(this.h));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int l = TbadkApplication.j().l();
        if (l != this.f) {
            this.f = l;
            b(this.f);
        }
        if (i == 8 || i == 4) {
            Iterator<ag> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            return;
        }
        Iterator<ag> it2 = this.d.iterator();
        while (it2.hasNext()) {
            it2.next().a(this.g);
        }
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.d.size()) {
            this.b.a(this.d.get(i));
            this.c.setShowDelete(true);
            this.c.setCurrentTab(i);
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.editortool.an
    public final void a(int i) {
        setCurrentTab(i);
    }

    public final void b(int i) {
        this.c.a(i);
        this.b.a(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.x xVar) {
        Iterator<ag> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(xVar);
        }
        this.b.setOnDataSelected(xVar);
        this.c.setOnDataSelected(xVar);
    }
}
