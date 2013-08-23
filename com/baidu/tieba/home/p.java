package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class p extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.data.w f1192a;
    private Context b;
    private com.baidu.tieba.view.p c;
    private View.OnClickListener d;
    private com.baidu.tieba.util.a f;
    private int g;
    private boolean e = false;
    private int h = 200;
    private boolean i = false;
    private float j = 0.4f;

    public void a(com.baidu.tieba.data.w wVar) {
        a(TiebaApplication.g().aZ());
        this.e = true;
        this.f1192a = wVar;
    }

    public p(Context context) {
        this.g = 200;
        this.b = context;
        this.f = new com.baidu.tieba.util.a(context);
        this.g = UtilHelper.a(context);
        a(TiebaApplication.g().aZ());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList a2;
        if (!this.e) {
            return 1;
        }
        if (this.f1192a == null || (a2 = this.f1192a.a()) == null) {
            return 0;
        }
        return a2.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList a2;
        if (!this.e) {
            return 1;
        }
        if (this.f1192a == null || (a2 = this.f1192a.a()) == null) {
            return null;
        }
        return (com.baidu.tieba.data.x) a2.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.data.x xVar;
        if (!this.e) {
            return a();
        }
        if (this.c == null) {
            this.c = new com.baidu.tieba.view.p(this.b);
        }
        this.c.a(this.g, this.i, this.j);
        View a2 = (view == null || view.getTag() == null) ? this.c.a() : view;
        a2.setPadding(0, i == 0 ? 8 : 0, 0, 0);
        ArrayList a3 = this.f1192a.a();
        if (a3 != null && (xVar = (com.baidu.tieba.data.x) a3.get(i)) != null) {
            this.c.a(a2, xVar);
            this.c.a(TiebaApplication.g().an(), a2);
        }
        return a2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tieba.data.x xVar;
        ArrayList j;
        if (this.e && this.f1192a != null) {
            ArrayList a2 = this.f1192a.a();
            if (a2 == null || (xVar = (com.baidu.tieba.data.x) a2.get(i)) == null || (j = xVar.j()) == null) {
                return 2;
            }
            int size = j.size();
            if (size >= 3) {
                return 5;
            }
            if (size == 2) {
                return 4;
            }
            return size == 1 ? 3 : 2;
        }
        return 0;
    }

    public View a() {
        View view = new View(this.b);
        view.setBackgroundColor(0);
        return view;
    }

    public void a(boolean z) {
        this.i = z;
        this.h = this.g;
        if (this.i) {
            if (this.h > 480) {
                this.h = 480;
            }
            if (this.h > UtilHelper.a(this.b, 320.0f)) {
                this.h = UtilHelper.a(this.b, 320.0f);
            }
            this.f.a(1);
            this.f.b("_small");
        } else {
            if (this.h > this.j * 480.0f) {
                this.h = (int) (this.j * 480.0f);
            }
            if (this.h > UtilHelper.a(this.b, 320.0f) * this.j) {
                this.h = (int) (UtilHelper.a(this.b, 320.0f) * this.j);
            }
            this.f.a(2);
            this.f.b("_mobile");
        }
        this.f.a(this.h, this.h);
    }

    public com.baidu.tieba.util.a b() {
        return this.f;
    }
}
