package com.baidu.tieba.editortool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PrivilegeTabHost extends LinearLayout implements ap {
    private PrivilegeTabContentView a;
    private PrivilegeTabWidgetView b;
    private ProgressBar c;
    private ArrayList<ai> d;
    private int e;
    private int f;
    private Context g;
    private an h;

    public PrivilegeTabHost(Context context) {
        super(context);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = -1;
        this.h = new am(this);
        a(context);
    }

    public PrivilegeTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new ArrayList<>();
        this.e = -1;
        this.f = -1;
        this.h = new am(this);
        a(context);
    }

    private void a() {
        this.d.clear();
        this.d.add(new a(this.h));
    }

    private void a(Context context) {
        this.g = context;
        removeAllViews();
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.privilege_tab_host, this, true);
        this.a = (PrivilegeTabContentView) findViewById(com.baidu.tieba.u.privilege_tab_content);
        this.b = (PrivilegeTabWidgetView) findViewById(com.baidu.tieba.u.privilege_tab_widget);
        this.c = (ProgressBar) findViewById(com.baidu.tieba.u.privilege_progress);
        this.b.setOnTabSelectedListener(this);
        setOrientation(1);
        this.f = TbadkApplication.m252getInst().getSkinType();
        b(this.f);
        b();
    }

    private void b() {
        a();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (skinType != this.f) {
            this.f = skinType;
            b(this.f);
        }
        if (i != 8 && i != 4) {
            Iterator<ai> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a(this.g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ak akVar) {
        this.b.a(akVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.d.size()) {
            this.a.a(this.d.get(i));
            this.b.setShowDelete(true);
            this.b.setCurrentTab(i);
            this.e = i;
        }
    }

    @Override // com.baidu.tieba.editortool.ap
    public void a(int i) {
        setCurrentTab(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.c.setVisibility(8);
    }

    public void b(int i) {
        this.b.a(i);
        this.a.a(i);
    }

    public void setOnDataSelected(com.baidu.tbadk.editortool.w wVar) {
        Iterator<ai> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(wVar);
        }
        this.a.setOnDataSelected(wVar);
        this.b.setOnDataSelected(wVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<ai> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }
}
