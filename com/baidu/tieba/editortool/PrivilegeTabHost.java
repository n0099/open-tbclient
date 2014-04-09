package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PrivilegeTabHost extends LinearLayout implements an {
    private LayoutInflater a;
    private PrivilegeTabContentView b;
    private PrivilegeTabWidgetView c;
    private ProgressBar d;
    private ArrayList<ag> e;
    private int f;
    private int g;
    private Context h;
    private al i;

    public PrivilegeTabHost(Context context) {
        super(context);
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = -1;
        this.i = new ak(this);
        a(context);
    }

    public PrivilegeTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = -1;
        this.i = new ak(this);
        a(context);
    }

    private void a(Context context) {
        this.h = context;
        removeAllViews();
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a.inflate(com.baidu.tieba.a.i.privilege_tab_host, (ViewGroup) this, true);
        this.b = (PrivilegeTabContentView) findViewById(com.baidu.tieba.a.h.privilege_tab_content);
        this.c = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.a.h.privilege_tab_widget);
        this.d = (ProgressBar) findViewById(com.baidu.tieba.a.h.privilege_progress);
        this.c.setOnTabSelectedListener(this);
        setOrientation(1);
        this.g = TbadkApplication.j().l();
        b(this.g);
        this.e.clear();
        this.e.add(new a(this.i));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int l = TbadkApplication.j().l();
        if (l != this.g) {
            this.g = l;
            b(this.g);
        }
        if (i != 8 && i != 4) {
            Iterator<ag> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().a(this.h);
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.e.size()) {
            this.b.a(this.e.get(i));
            this.c.setShowDelete(true);
            this.c.setCurrentTab(i);
            this.f = i;
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
        Iterator<ag> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(xVar);
        }
        this.b.setOnDataSelected(xVar);
        this.c.setOnDataSelected(xVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<ag> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }
}
