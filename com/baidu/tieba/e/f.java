package com.baidu.tieba.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ah;
import com.baidu.tieba.data.u;
import com.baidu.tieba.data.v;
import com.baidu.tieba.util.bv;
import com.baidu.tieba.view.ai;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class f extends BaseAdapter {
    private u a;
    private Context b;
    private ai c;
    private View.OnClickListener d;
    private com.baidu.tieba.util.i f;
    private int g;
    private boolean e = false;
    private int h = 200;
    private boolean i = false;
    private float j = 0.4f;
    private boolean k = false;

    public final void a(u uVar) {
        b(bv.a().b());
        this.e = true;
        this.a = uVar;
    }

    public f(Context context) {
        this.g = 200;
        this.b = context;
        this.f = new com.baidu.tieba.util.i(context);
        this.g = BdUtilHelper.b(context);
        b(bv.a().b());
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList<v> b;
        if (!this.e) {
            return 1;
        }
        if (this.a == null || (b = this.a.b()) == null) {
            return 0;
        }
        return b.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (!this.e || this.a == null || this.a.b() == null) {
            return null;
        }
        ArrayList<v> b = this.a.b();
        if (i < 0 || b == null || i >= b.size()) {
            return null;
        }
        return b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public final void a(boolean z) {
        this.k = z;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        v vVar;
        if (!this.e) {
            View view2 = new View(this.b);
            view2.setBackgroundColor(0);
            return view2;
        }
        if (this.c == null) {
            this.c = new ai(this.b);
        }
        this.c.a(this.g, this.i, this.j);
        this.c.a(this.k);
        View a = (view == null || view.getTag() == null) ? this.c.a() : view;
        a.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(R.dimen.forumfeed_first_item_margin_top) : 0, 0, 0);
        int ae = TiebaApplication.g().ae();
        ArrayList<v> b = this.a.b();
        if (b != null && (vVar = b.get(i)) != null) {
            this.c.a(a, vVar);
            this.c.a(ae, a);
        }
        com.baidu.tieba.k kVar = (com.baidu.tieba.k) this.b;
        kVar.a().a(ae == 1);
        kVar.a().a(a);
        return a;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        v vVar;
        ArrayList<ah> k;
        if (this.e && this.a != null) {
            ArrayList<v> b = this.a.b();
            if (b == null || (vVar = b.get(i)) == null || (k = vVar.k()) == null) {
                return 2;
            }
            int size = k.size();
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

    private void b(boolean z) {
        this.i = z;
        this.h = this.g;
        if (this.i) {
            if (this.h > 480) {
                this.h = 480;
            }
            if (this.h > BdUtilHelper.a(this.b, 320.0f)) {
                this.h = BdUtilHelper.a(this.b, 320.0f);
            }
            this.f.f = "_small";
        } else {
            if (this.h > this.j * 480.0f) {
                this.h = (int) (this.j * 480.0f);
            }
            if (this.h > BdUtilHelper.a(this.b, 320.0f) * this.j) {
                this.h = (int) (BdUtilHelper.a(this.b, 320.0f) * this.j);
            }
            this.f.f = "_mobile";
        }
        this.f.a(this.h, this.h);
    }

    public final com.baidu.tieba.util.i a() {
        return this.f;
    }
}
