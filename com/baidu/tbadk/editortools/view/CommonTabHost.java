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
import d.b.h0.w.y.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class CommonTabHost extends ICommonTabHost implements CommonTabWidgetView.b {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f13582e;

    /* renamed from: f  reason: collision with root package name */
    public CommonTabContentView f13583f;

    /* renamed from: g  reason: collision with root package name */
    public CommonTabWidgetView f13584g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f13585h;
    public ArrayList<d.b.h0.w.y.a> i;
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
        public void b(d.b.h0.w.y.a aVar) {
            CommonTabHost.this.m();
            CommonTabHost.this.f13584g.e();
            CommonTabHost.this.f13584g.setDatas(CommonTabHost.this.i);
            int size = CommonTabHost.this.i.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                a.b i2 = ((d.b.h0.w.y.a) CommonTabHost.this.i.get(i)).i();
                if (i2 != null) {
                    CommonTabHost.this.l(i2);
                    z = true;
                }
            }
            if (!z) {
                CommonTabHost.this.f13584g.setVisibility(8);
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

        void b(d.b.h0.w.y.a aVar);

        void onLoadFail();
    }

    public CommonTabHost(Context context) {
        super(context);
        this.i = new ArrayList<>();
        this.j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a();
        this.p = false;
        n(context);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabWidgetView.b
    public void a(int i) {
        setCurrentTab(i);
    }

    public void b() {
        setVisibility(0);
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.f13582e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.b.h0.w.n
    public int getToolId() {
        return this.m;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    public void init() {
    }

    public void k(d.b.h0.w.y.a aVar) {
        aVar.s(this.o);
        aVar.setEditorTools(this.f13582e);
        this.i.add(aVar);
    }

    public final void l(a.b bVar) {
        this.f13584g.b(bVar);
    }

    public final void m() {
        this.f13585h.setVisibility(8);
    }

    public final void n(Context context) {
        this.l = context;
        removeAllViews();
        LayoutInflater.from(context).inflate(R.layout.common_tab_host, (ViewGroup) this, true);
        this.f13583f = (CommonTabContentView) findViewById(R.id.common_tab_content);
        this.f13584g = (CommonTabWidgetView) findViewById(R.id.common_tab_widget);
        this.f13585h = (ProgressBar) findViewById(R.id.common_progress);
        this.f13584g.setOnTabSelectedListener(this);
        this.f13584g.setEditorTools(this.f13582e);
        setOrientation(1);
        this.k = TbadkCoreApplication.getInst().getSkinType();
        setBackgroundColorId(R.color.CAM_X0201);
    }

    public final void o() {
        this.f13585h.setVisibility(0);
    }

    public void onAction(d.b.h0.w.a aVar) {
        Iterator<d.b.h0.w.y.a> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onAction(aVar);
        }
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundColor(this, this.n, i);
        this.f13584g.d(i);
        this.f13583f.d(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<d.b.h0.w.y.a> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void setBackgroundColorId(int i) {
        super.setBackgroundColor(getContext().getResources().getColor(i));
        this.n = i;
    }

    public void setCurrentTab(int i) {
        if (i < 0 || i >= this.i.size()) {
            return;
        }
        this.f13583f.e(this.i.get(i));
        this.f13584g.setCurrentTab(i);
        this.j = i;
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f13582e = editorTools;
        ArrayList<d.b.h0.w.y.a> arrayList = this.i;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<d.b.h0.w.y.a> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().setEditorTools(this.f13582e);
            }
        }
        CommonTabWidgetView commonTabWidgetView = this.f13584g;
        if (commonTabWidgetView != null) {
            commonTabWidgetView.setEditorTools(this.f13582e);
        }
    }

    public void setShowDelete(boolean z) {
        this.f13584g.setShowDelete(z);
    }

    @Override // com.baidu.tbadk.editortools.view.ICommonTabHost, d.b.h0.w.n
    public void setToolId(int i) {
        this.m = i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.k) {
            this.k = skinType;
            onChangeSkinType(skinType);
        }
        if (i == 8 || i == 4 || this.p) {
            return;
        }
        this.p = true;
        Iterator<d.b.h0.w.y.a> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().q(this.l);
        }
    }

    public CommonTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new ArrayList<>();
        this.j = -1;
        this.k = -1;
        this.m = 0;
        this.n = R.color.common_color_10255;
        this.o = new a();
        this.p = false;
        n(context);
    }
}
