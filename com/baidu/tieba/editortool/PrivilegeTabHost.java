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
public class PrivilegeTabHost extends LinearLayout implements ap {
    private LayoutInflater a;
    private PrivilegeTabContentView b;
    private PrivilegeTabWidgetView c;
    private ProgressBar d;
    private ArrayList<ai> e;
    private int f;
    private int g;
    private Context h;
    private an i;

    public PrivilegeTabHost(Context context) {
        super(context);
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = -1;
        this.i = new am(this);
        a(context);
    }

    public PrivilegeTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList<>();
        this.f = -1;
        this.g = -1;
        this.i = new am(this);
        a(context);
    }

    private void a() {
        this.e.clear();
        this.e.add(new a(this.i));
    }

    private void a(Context context) {
        this.h = context;
        removeAllViews();
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.a.inflate(com.baidu.tieba.v.privilege_tab_host, (ViewGroup) this, true);
        this.b = (PrivilegeTabContentView) findViewById(com.baidu.tieba.u.privilege_tab_content);
        this.c = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.u.privilege_tab_widget);
        this.d = (ProgressBar) findViewById(com.baidu.tieba.u.privilege_progress);
        this.c.setOnTabSelectedListener(this);
        setOrientation(1);
        this.g = TbadkApplication.m252getInst().getSkinType();
        b(this.g);
        b();
    }

    private void b() {
        a();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType != this.g) {
            this.g = skinType;
            b(this.g);
        }
        if (i != 8 && i != 4) {
            Iterator<ai> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().a(this.h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ak akVar) {
        this.c.a(akVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.e.size()) {
            this.b.a(this.e.get(i));
            this.c.setShowDelete(true);
            this.c.setCurrentTab(i);
            this.f = i;
        }
    }

    @Override // com.baidu.tieba.editortool.ap
    public void a(int i) {
        setCurrentTab(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.d.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.d.setVisibility(8);
    }

    public void b(int i) {
        this.c.a(i);
        this.b.a(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        Iterator<ai> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(wVar);
        }
        this.b.setOnDataSelected(wVar);
        this.c.setOnDataSelected(wVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<ai> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }
}
