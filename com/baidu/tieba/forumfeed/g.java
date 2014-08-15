package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.data.q;
import com.baidu.tieba.s;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter {
    private com.baidu.tieba.data.p a;
    private Context b;
    private com.baidu.tieba.view.j c;
    private int e;
    private boolean d = false;
    private boolean f = false;
    private float g = 0.4f;
    private boolean h = false;

    public void a(com.baidu.tieba.data.p pVar) {
        b(bb.a().b());
        this.d = true;
        this.a = pVar;
    }

    public g(Context context) {
        this.e = Constants.MEDIA_INFO;
        this.b = context;
        this.e = com.baidu.adp.lib.util.j.b(context);
        b(bb.a().b());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<q> b;
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
        ArrayList<q> b = this.a.b();
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
        this.h = z;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        q qVar;
        if (!this.d) {
            return a();
        }
        if (this.c == null) {
            this.c = new com.baidu.tieba.view.j(this.b);
        }
        this.c.a(this.e, this.f, this.g);
        this.c.a(this.h);
        View a = (view == null || view.getTag() == null) ? this.c.a() : view;
        a.setPadding(0, i == 0 ? this.b.getResources().getDimensionPixelSize(s.forumfeed_first_item_margin_top) : 0, 0, 0);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        ArrayList<q> b = this.a.b();
        if (b != null && (qVar = b.get(i)) != null) {
            this.c.a(a, qVar);
            this.c.a(skinType, a);
        }
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.c().a(skinType == 1);
        baseFragmentActivity.c().a(a);
        return a;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        q qVar;
        ArrayList<MediaData> k;
        if (this.d && this.a != null) {
            ArrayList<q> b = this.a.b();
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
        this.f = z;
    }
}
