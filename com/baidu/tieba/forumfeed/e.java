package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.data.v;
import com.baidu.tieba.data.w;
import com.baidu.tieba.util.bx;
import com.baidu.tieba.view.af;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private v a;
    private Context b;
    private af c;
    private View.OnClickListener d;
    private com.baidu.tieba.util.i f;
    private int g;
    private boolean e = false;
    private int h = 200;
    private boolean i = false;
    private float j = 0.4f;
    private boolean k = false;

    public void a(v vVar) {
        b(bx.a().b());
        this.e = true;
        this.a = vVar;
    }

    public e(Context context) {
        this.g = 200;
        this.b = context;
        this.f = new com.baidu.tieba.util.i(context);
        this.g = com.baidu.adp.lib.g.g.b(context);
        b(bx.a().b());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<w> b;
        if (!this.e) {
            return 1;
        }
        if (this.a == null || (b = this.a.b()) == null) {
            return 0;
        }
        return b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.e || this.a == null || this.a.b() == null) {
            return null;
        }
        ArrayList<w> b = this.a.b();
        if (i < 0 || b == null || i >= b.size()) {
            return null;
        }
        return b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void a(boolean z) {
        this.k = z;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        w wVar;
        if (!this.e) {
            return a();
        }
        if (this.c == null) {
            this.c = new af(this.b);
        }
        this.c.a(this.g, this.i, this.j);
        this.c.a(this.k);
        View a = (view == null || view.getTag() == null) ? this.c.a() : view;
        a.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(R.dimen.forumfeed_first_item_margin_top) : 0, 0, 0);
        int al = TiebaApplication.h().al();
        ArrayList<w> b = this.a.b();
        if (b != null && (wVar = b.get(i)) != null) {
            this.c.a(a, wVar);
            this.c.a(al, a);
        }
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.a().a(al == 1);
        baseFragmentActivity.a().a(a);
        return a;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        w wVar;
        ArrayList<aj> k;
        if (this.e && this.a != null) {
            ArrayList<w> b = this.a.b();
            if (b == null || (wVar = b.get(i)) == null || (k = wVar.k()) == null) {
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

    public View a() {
        View view = new View(this.b);
        view.setBackgroundColor(0);
        return view;
    }

    public void b(boolean z) {
        this.i = z;
        this.h = this.g;
        if (this.i) {
            if (this.h > 480) {
                this.h = 480;
            }
            if (this.h > com.baidu.adp.lib.g.g.a(this.b, 320.0f)) {
                this.h = com.baidu.adp.lib.g.g.a(this.b, 320.0f);
            }
            this.f.b("_small");
        } else {
            if (this.h > this.j * 480.0f) {
                this.h = (int) (this.j * 480.0f);
            }
            if (this.h > com.baidu.adp.lib.g.g.a(this.b, 320.0f) * this.j) {
                this.h = (int) (com.baidu.adp.lib.g.g.a(this.b, 320.0f) * this.j);
            }
            this.f.b("_mobile");
        }
        this.f.a(this.h, this.h);
    }

    public com.baidu.tieba.util.i b() {
        return this.f;
    }
}
