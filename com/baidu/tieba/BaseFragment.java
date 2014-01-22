package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.tieba.util.bz;
/* loaded from: classes.dex */
public abstract class BaseFragment extends Fragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private int a = -1;
    private com.baidu.tieba.util.s b;

    @Override // android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.a(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        this.b = com.baidu.tieba.util.s.a();
        super.a(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
    }

    public void a(String str) {
        if (i() != null) {
            String name = getClass().getName();
            String str2 = i().getApplicationContext().getPackageName() + ".chat";
            if (name.startsWith(i().getApplicationContext().getPackageName() + ".im") || name.startsWith(str2)) {
                this.b.a(str, 2000);
            } else {
                com.baidu.adp.lib.g.g.a((Context) i(), str);
            }
        }
    }

    public void c(int i) {
        if (i() != null) {
            String name = getClass().getName();
            String str = i().getApplicationContext().getPackageName() + ".chat";
            if (name.startsWith(i().getApplicationContext().getPackageName() + ".im") || name.startsWith(str)) {
                this.b.a(i, 2000);
            } else {
                com.baidu.adp.lib.g.g.a((Context) i(), i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void c_() {
        super.c_();
    }

    @Override // android.support.v4.app.Fragment
    public void r() {
        if (this.b != null) {
            this.b.c();
        }
        super.r();
        if (F()) {
            if (TiebaApplication.h().al() != this.a) {
                this.a = TiebaApplication.h().al();
                d(this.a);
            }
            bz.a(getClass().getName());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void s() {
        this.b.b();
        super.s();
    }

    @Override // android.support.v4.app.Fragment
    public void d() {
        super.d();
    }

    @Override // android.support.v4.app.Fragment
    public void t() {
        super.t();
    }

    @Override // android.support.v4.app.Fragment
    public void e() {
        super.e();
    }

    @Override // android.support.v4.app.Fragment
    public void b() {
        super.b();
    }

    public void d(int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.support.v4.app.Fragment
    public void b(boolean z) {
        super.b(z);
        if (!z) {
            r();
        } else {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F() {
        return !p();
    }
}
