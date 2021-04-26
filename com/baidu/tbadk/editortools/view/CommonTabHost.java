package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tieba.R;
import d.a.i0.w.y.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.b {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f13586e;

    /* renamed from: f  reason: collision with root package name */
    public CommonTabContentView f13587f;

    /* renamed from: g  reason: collision with root package name */
    public CommonTabWidgetView f13588g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f13589h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<d.a.i0.w.y.a> f13590i;
    public int j;
    public int k;
    public Context l;
    public int m;
    public int n;
    public b o;
    public boolean p;

    /* loaded from: classes3.dex */
    public class a implements b {
        public a() {
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void a() {
            CommonTabHost.this.o();
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void b(d.a.i0.w.y.a aVar) {
            CommonTabHost.this.m();
            CommonTabHost.this.f13588g.e();
            CommonTabHost.this.f13588g.setDatas(CommonTabHost.this.f13590i);
            int size = CommonTabHost.this.f13590i.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                a.b i3 = ((d.a.i0.w.y.a) CommonTabHost.this.f13590i.get(i2)).i();
                if (i3 != null) {
                    CommonTabHost.this.l(i3);
                    z = true;
                }
            }
            if (!z) {
                CommonTabHost.this.f13588g.setVisibility(8);
            }
            if (CommonTabHost.this.j < 0) {
                CommonTabHost.this.setCurrentTab(0);
                return;
            }
            CommonTabHost commonTabHost = CommonTabHost.this;
            commonTabHost.setCurrentTab(commonTabHost.j);
        }

        @Override // com.baidu.tbadk.editortools.view.CommonTabHost.b
        public void onLoadFail() {
            CommonTabHost.this.m();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b(d.a.i0.w.y.a aVar);

        void onLoadFail();
    }

    public CommonTabHost(Context context) {
        super(context);
        this.f13590i = new ArrayList<>();
        this.j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a();
        this.p = false;
        n(context);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.b
    public void a(int i2) {
        setCurrentTab(i2);
    }

    public void b() {
        setVisibility(0);
    }

    @Override // d.a.i0.w.n
    public void d(d.a.i0.w.a aVar) {
        EditorTools editorTools = this.f13586e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.a.i0.w.n
    public int getToolId() {
        return this.m;
    }

    @Override // d.a.i0.w.n
    public void hide() {
        setVisibility(8);
    }

    public void init() {
    }

    public void k(d.a.i0.w.y.a aVar) {
        aVar.s(this.o);
        aVar.setEditorTools(this.f13586e);
        this.f13590i.add(aVar);
    }

    public final void l(a.b bVar) {
        this.f13588g.b(bVar);
    }

    public final void m() {
        this.f13589h.setVisibility(8);
    }

    public final void n(Context context) {
        this.l = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.f13587f = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.f13588g = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.f13589h = (ProgressBar) findViewById(R.id.common_progress);
        this.f13588g.setOnTabSelectedListener(this);
        this.f13588g.setEditorTools(this.f13586e);
        setOrientation(1);
        this.k = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.CAM_X0201);
    }

    public final void o() {
        this.f13589h.setVisibility(0);
    }

    public void onAction(d.a.i0.w.a aVar) {
        Iterator<d.a.i0.w.y.a> it = this.f13590i.iterator();
        while (it.hasNext()) {
            it.next().onAction(aVar);
        }
    }

    @Override // d.a.i0.w.n
    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this, this.n, i2);
        this.f13588g.d(i2);
        this.f13587f.d(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<d.a.i0.w.y.a> it = this.f13590i.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void setBackgroundColorId(int i2) {
        super.setBackgroundColor(getContext().getResources().getColor(i2));
        this.n = i2;
    }

    public void setCurrentTab(int i2) {
        if (i2 < 0 || i2 >= this.f13590i.size()) {
            return;
        }
        this.f13587f.e(this.f13590i.get(i2));
        this.f13588g.setCurrentTab(i2);
        this.j = i2;
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.a.i0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f13586e = editorTools;
        ArrayList<d.a.i0.w.y.a> arrayList = this.f13590i;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<d.a.i0.w.y.a> it = this.f13590i.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.f13586e);
            }
        }
        CommonTabWidgetView commonTabWidgetView = this.f13588g;
        if (commonTabWidgetView != null) {
            commonTabWidgetView.setEditorTools(this.f13586e);
        }
    }

    public void setShowDelete(boolean z) {
        this.f13588g.setShowDelete(z);
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.a.i0.w.n
    public void setToolId(int i2) {
        this.m = i2;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.k) {
            this.k = skinType;
            onChangeSkinType(skinType);
        }
        if (i2 == 8 || i2 == 4 || this.p) {
            return;
        }
        this.p = true;
        Iterator<d.a.i0.w.y.a> it = this.f13590i.iterator();
        while (it.hasNext()) {
            it.next().q(this.l);
        }
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13590i = new ArrayList<>();
        this.j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a();
        this.p = false;
        n(context);
    }
}
