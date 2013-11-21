package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.v;
import com.baidu.tieba.data.w;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bf;
import com.baidu.tieba.view.r;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private v f1296a;
    private Context b;
    private r c;
    private View.OnClickListener d;
    private com.baidu.tieba.util.i f;
    private int g;
    private boolean e = false;
    private int h = 200;
    private boolean i = false;
    private float j = 0.4f;
    private boolean k = false;

    public void a(v vVar) {
        b(bf.a().b());
        this.e = true;
        this.f1296a = vVar;
    }

    public e(Context context) {
        this.g = 200;
        this.b = context;
        this.f = new com.baidu.tieba.util.i(context);
        this.g = UtilHelper.a(context);
        b(bf.a().b());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<w> b;
        if (!this.e) {
            return 1;
        }
        if (this.f1296a == null || (b = this.f1296a.b()) == null) {
            return 0;
        }
        return b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.e || this.f1296a == null || this.f1296a.b() == null) {
            return null;
        }
        ArrayList<w> b = this.f1296a.b();
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
            this.c = new r(this.b);
        }
        this.c.a(this.g, this.i, this.j);
        this.c.a(this.k);
        View a2 = (view == null || view.getTag() == null) ? this.c.a() : view;
        a2.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(R.dimen.forumfeed_first_item_margin_top) : 0, 0, 0);
        int ap = TiebaApplication.g().ap();
        ArrayList<w> b = this.f1296a.b();
        if (b != null && (wVar = b.get(i)) != null) {
            this.c.a(a2, wVar);
            this.c.a(ap, a2);
        }
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.a().a(ap == 1);
        baseFragmentActivity.a().a(a2);
        return a2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        w wVar;
        ArrayList<ai> j;
        if (this.e && this.f1296a != null) {
            ArrayList<w> b = this.f1296a.b();
            if (b == null || (wVar = b.get(i)) == null || (j = wVar.j()) == null) {
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

    public void b(boolean z) {
        this.i = z;
        this.h = this.g;
        if (this.i) {
            if (this.h > 480) {
                this.h = 480;
            }
            if (this.h > UtilHelper.a(this.b, 320.0f)) {
                this.h = UtilHelper.a(this.b, 320.0f);
            }
            this.f.b("_small");
        } else {
            if (this.h > this.j * 480.0f) {
                this.h = (int) (this.j * 480.0f);
            }
            if (this.h > UtilHelper.a(this.b, 320.0f) * this.j) {
                this.h = (int) (UtilHelper.a(this.b, 320.0f) * this.j);
            }
            this.f.b("_mobile");
        }
        this.f.a(this.h, this.h);
    }

    public com.baidu.tieba.util.i b() {
        return this.f;
    }
}
