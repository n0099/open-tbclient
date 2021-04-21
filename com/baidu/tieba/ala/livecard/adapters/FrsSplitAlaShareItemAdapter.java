package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.z1;
import d.b.j0.m.e;
import d.b.j0.m.f;
import d.b.j0.q0.j;
import d.b.j0.q0.k;
import d.b.j0.t.i.e.c;
import d.b.j0.x.b0;
import d.b.j0.x.z;
/* loaded from: classes4.dex */
public class FrsSplitAlaShareItemAdapter extends k<z1, FrsPageAlaShareHolder> implements z, f {
    public String w;
    public c x;
    public String y;
    public b0<a2> z;

    /* loaded from: classes4.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public c f14701a;

        public FrsPageAlaShareHolder(c cVar) {
            super(cVar.m());
            this.f14701a = cVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.j0.x.b0
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

    @Override // d.b.j0.x.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.b.j0.m.f
    public void o(String str) {
        this.y = str;
    }

    @Override // d.b.j0.x.z
    public void p(int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: v0 */
    public FrsPageAlaShareHolder R(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        c cVar = new c(tbPageContext, this.i);
        this.x = cVar;
        cVar.W(this.i);
        this.x.a(this.w);
        this.x.q(this.z);
        return new FrsPageAlaShareHolder(this.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.q0.k, d.b.c.j.e.a
    /* renamed from: w0 */
    public View X(int i, View view, ViewGroup viewGroup, z1 z1Var, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(2921017);
        FrsViewData frsViewData = this.n;
        int topThreadSize = frsViewData != null ? frsViewData.getTopThreadSize() : 0;
        a2 a2Var = z1Var.w;
        a2Var.M1 = (z1Var.position + 1) - topThreadSize;
        customMessage.setData(a2Var);
        this.o.sendMessage(customMessage);
        if (z1Var != null) {
            c cVar = frsPageAlaShareHolder.f14701a;
            if (cVar instanceof e) {
                cVar.setPage(this.y);
            }
            frsPageAlaShareHolder.f14701a.a(this.w);
            j.h(frsPageAlaShareHolder.f14701a.P(), this.n);
            j.h(frsPageAlaShareHolder.f14701a.R(), this.n);
            frsPageAlaShareHolder.f14701a.n(z1Var.w);
            z1Var.w.y4();
        }
        return frsPageAlaShareHolder.a();
    }
}
