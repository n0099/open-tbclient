package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.editortool.ab;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private com.baidu.tieba.data.p a;
    private Context b;
    private com.baidu.tieba.view.k c;
    private ab e;
    private int f;
    private boolean d = false;
    private int g = Constants.MEDIA_INFO;
    private boolean h = false;
    private float i = 0.4f;
    private boolean j = false;

    public void a(com.baidu.tieba.data.p pVar) {
        b(bf.a().b());
        this.d = true;
        this.a = pVar;
    }

    public g(Context context) {
        this.f = Constants.MEDIA_INFO;
        this.b = context;
        this.e = new ab(context);
        this.f = com.baidu.adp.lib.util.h.b(context);
        b(bf.a().b());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<com.baidu.tieba.data.q> b;
        if (!this.d) {
            return 1;
        }
        if (this.a == null || (b = this.a.b()) == null) {
            return 0;
        }
        return b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.d || this.a == null || this.a.b() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.q> b = this.a.b();
        if (i < 0 || b == null || i >= b.size()) {
            return null;
        }
        return b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public void a(boolean z) {
        this.j = z;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.data.q qVar;
        if (!this.d) {
            return a();
        }
        if (this.c == null) {
            this.c = new com.baidu.tieba.view.k(this.b);
        }
        this.c.a(this.f, this.h, this.i);
        this.c.a(this.j);
        View a = (view == null || view.getTag() == null) ? this.c.a() : view;
        a.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(com.baidu.tieba.p.forumfeed_first_item_margin_top) : 0, 0, 0);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        ArrayList<com.baidu.tieba.data.q> b = this.a.b();
        if (b != null && (qVar = b.get(i)) != null) {
            this.c.a(a, qVar);
            this.c.a(skinType, a);
        }
        com.baidu.tbadk.core.e eVar = (com.baidu.tbadk.core.e) this.b;
        eVar.a().a(skinType == 1);
        eVar.a().a(a);
        return a;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        com.baidu.tieba.data.q qVar;
        ArrayList<com.baidu.tbadk.core.data.k> k;
        if (this.d && this.a != null) {
            ArrayList<com.baidu.tieba.data.q> b = this.a.b();
            if (b == null || (qVar = b.get(i)) == null || (k = qVar.k()) == null) {
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
        this.h = z;
        this.g = this.f;
        if (this.h) {
            if (this.g > 480) {
                this.g = 480;
            }
            if (this.g > com.baidu.adp.lib.util.h.a(this.b, 320.0f)) {
                this.g = com.baidu.adp.lib.util.h.a(this.b, 320.0f);
            }
            this.e.b("_small");
        } else {
            if (this.g > this.i * 480.0f) {
                this.g = (int) (this.i * 480.0f);
            }
            if (this.g > com.baidu.adp.lib.util.h.a(this.b, 320.0f) * this.i) {
                this.g = (int) (com.baidu.adp.lib.util.h.a(this.b, 320.0f) * this.i);
            }
            this.e.b("_mobile");
        }
        this.e.a(this.g, this.g);
    }

    public ab b() {
        return this.e;
    }
}
