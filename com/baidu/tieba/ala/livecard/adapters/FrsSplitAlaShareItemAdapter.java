package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import d.a.k0.m.e;
import d.a.k0.m.f;
import d.a.k0.q0.j;
import d.a.k0.q0.k;
import d.a.k0.t.i.e.c;
import d.a.k0.x.b0;
import d.a.k0.x.z;
/* loaded from: classes4.dex */
public class FrsSplitAlaShareItemAdapter extends k<z1, FrsPageAlaShareHolder> implements z, f {
    public String w;
    public c x;
    public String y;
    public b0<a2> z;

    /* loaded from: classes4.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public c f14096a;

        public FrsPageAlaShareHolder(c cVar) {
            super(cVar.l());
            this.f14096a = cVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.k0.x.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            CustomMessage customMessage;
            if (view.getId() == R.id.layout_root) {
                customMessage = new CustomMessage(2921018);
            } else if (view.getId() != R.id.card_home_page_normal_thread_user_name && view.getId() != R.id.card_home_page_normal_thread_user_header) {
                customMessage = view.getId() == R.id.video_container ? new CustomMessage(2921019) : null;
            } else {
                customMessage = new CustomMessage(2921016);
            }
            if (customMessage == null || FrsSplitAlaShareItemAdapter.this.o == null) {
                return;
            }
            customMessage.setData(a2Var);
            FrsSplitAlaShareItemAdapter.this.o.sendMessage(customMessage);
        }
    }

    public FrsSplitAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.z = new a();
    }

    @Override // d.a.k0.x.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.a.k0.m.f
    public void g(String str) {
        this.y = str;
    }

    @Override // d.a.k0.x.z
    public void q(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: u0 */
    public FrsPageAlaShareHolder P(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        c cVar = new c(tbPageContext, this.f39568i);
        this.x = cVar;
        cVar.T(this.f39568i);
        this.x.a(this.w);
        this.x.o(this.z);
        return new FrsPageAlaShareHolder(this.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.q0.k, d.a.c.j.e.a
    /* renamed from: v0 */
    public View W(int i2, View view, ViewGroup viewGroup, z1 z1Var, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(2921017);
        FrsViewData frsViewData = this.n;
        int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
        a2 a2Var = z1Var.w;
        a2Var.M1 = (z1Var.position + 1) - topThreadSize;
        customMessage.setData(a2Var);
        this.o.sendMessage(customMessage);
        if (z1Var != null) {
            c cVar = frsPageAlaShareHolder.f14096a;
            if (cVar instanceof e) {
                cVar.setPage(this.y);
            }
            frsPageAlaShareHolder.f14096a.a(this.w);
            j.h(frsPageAlaShareHolder.f14096a.M(), this.n);
            j.h(frsPageAlaShareHolder.f14096a.O(), this.n);
            frsPageAlaShareHolder.f14096a.m(z1Var.w);
            z1Var.w.A4();
        }
        return frsPageAlaShareHolder.a();
    }
}
