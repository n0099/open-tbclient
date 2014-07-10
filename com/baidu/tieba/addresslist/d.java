package com.baidu.tieba.addresslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ba;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.atomData.bj;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
import com.baidu.tieba.addresslist.view.AssortView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.core.d implements com.baidu.adp.widget.ListView.d, com.baidu.tieba.addresslist.b.b, com.baidu.tieba.addresslist.view.a {
    private com.baidu.tieba.addresslist.c.a b;
    private e c;
    private f d;
    private g e;
    private h f;
    private com.baidu.tbadk.core.c g;
    private View h;
    private AssortView i;
    private View j;
    private q k;
    private BdListView l;
    private com.baidu.tieba.addresslist.a.a m;
    private int n;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
        this.b = new com.baidu.tieba.addresslist.c.a();
        this.b.setUniqueId(d());
    }

    private void f() {
        this.c = new e(this);
        a(this.c);
        this.d = new f(this);
        a(this.d);
        this.e = new g(this);
        a(this.e);
        this.f = new h(this);
        a(this.f);
    }

    @Override // com.baidu.tbadk.core.d
    public void e() {
        super.e();
        i();
        com.baidu.tbadk.core.f.b(TbadkApplication.m252getInst().getApplicationContext(), "contacts_list");
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        h();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b.b(this);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) getActivity();
        if (baseFragmentActivity != null) {
            this.g = baseFragmentActivity.c();
        }
        return a(layoutInflater);
    }

    private View a(LayoutInflater layoutInflater) {
        this.h = layoutInflater.inflate(w.addresslist_fragment, (ViewGroup) null);
        this.k = new q(TbadkApplication.m252getInst().getApplicationContext());
        this.m = new com.baidu.tieba.addresslist.a.a(TbadkApplication.m252getInst().getApplicationContext(), this.g);
        this.j = this.h.findViewById(v.addresslist_search_layout);
        this.j.setOnClickListener(this);
        this.l = (BdListView) this.h.findViewById(v.addresslist_contacts_list);
        this.l.setPullRefresh(this.k);
        this.l.setAdapter((ListAdapter) this.m);
        this.l.setOnItemClickListener(this);
        this.k.a(this);
        this.i = (AssortView) this.h.findViewById(v.addresslist_assortview);
        this.i.setClickable(true);
        this.i.setOnTouchListener(this);
        return this.h;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.b.a(this);
        g();
    }

    private void g() {
        this.b.b();
    }

    private void h() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new RequestUnreadPointNum());
    }

    private void i() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001189));
    }

    private void b(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.m = new com.baidu.tieba.addresslist.a.a(TbadkApplication.m252getInst().getApplicationContext(), this.g);
        this.l.setAdapter((ListAdapter) this.m);
        this.m.a(list);
        this.m.a(this.n);
        this.m.notifyDataSetChanged();
        if (list == null || list.size() == 0) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.addresslist.b.b
    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        b(list);
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (this.g != null) {
            this.g.a(this.h);
        }
        this.k.a(i);
        this.m.notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (com.baidu.adp.lib.util.j.c()) {
            this.b.c();
        } else {
            this.l.d();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == v.addresslist_search_layout) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), QuickSearchActivity.class);
            startActivity(intent);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            a(new CustomMessage(2002001, new com.baidu.tbadk.newFriends.b(getActivity())));
            this.n = 0;
            this.m.a(this.n);
            this.m.notifyDataSetChanged();
            com.baidu.tbadk.core.f.a(TbadkApplication.m252getInst().getApplicationContext(), "contacts_new");
        } else if (i == 1) {
            a(new CustomMessage(2002001, new bj(getActivity())));
        } else if (i == 2) {
            a(new CustomMessage(2002001, new ba(getActivity(), 0, 1)));
            com.baidu.tbadk.core.f.a(TbadkApplication.m252getInst().getApplicationContext(), "contacts_mygp");
        } else {
            com.baidu.tbadk.coreExtra.relationship.b item = this.m.getItem(i);
            if (item != null && item.c() > 0) {
                a(new CustomMessage(2002005, new bc(TbadkApplication.m252getInst().getApplicationContext(), item.c(), item.b(), item.d(), 0)));
                com.baidu.tbadk.core.f.a(TbadkApplication.m252getInst().getApplicationContext(), "contacts_to_chat");
            }
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void c(String str) {
        int a;
        List<com.baidu.tbadk.coreExtra.relationship.b> a2 = this.b.a();
        if (a2 != null && a2.size() != 0 && (a = this.b.a(str)) >= 0) {
            this.l.setSelection(a + 3);
        }
    }

    @Override // com.baidu.tieba.addresslist.view.a
    public void a() {
    }
}
