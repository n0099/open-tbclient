package com.baidu.tieba.ala.livecard.adapters;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.m0.r.q.a2;
import d.a.n0.o.e;
import d.a.n0.o.f;
import d.a.n0.r0.j;
import d.a.n0.r0.k;
import d.a.n0.v.i.e.c;
import d.a.n0.z.b0;
import d.a.n0.z.z;
/* loaded from: classes4.dex */
public class FrsAlaShareItemAdapter extends k<a2, FrsPageAlaShareHolder> implements z, f {
    public String w;
    public c x;
    public String y;
    public b0<a2> z;

    /* loaded from: classes4.dex */
    public static class FrsPageAlaShareHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public c f14049a;

        public FrsPageAlaShareHolder(c cVar) {
            super(cVar.m());
            this.f14049a = cVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<a2> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b0
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
            if (customMessage == null || FrsAlaShareItemAdapter.this.o == null) {
                return;
            }
            customMessage.setData(a2Var);
            FrsAlaShareItemAdapter.this.o.sendMessage(customMessage);
        }
    }

    public FrsAlaShareItemAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        this.z = new a();
    }

    @Override // d.a.n0.z.z
    public void a(String str) {
        this.w = str;
    }

    @Override // d.a.n0.o.f
    public void g(String str) {
        this.y = str;
    }

    @Override // d.a.n0.z.z
    public void r(int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: v0 */
    public FrsPageAlaShareHolder Q(ViewGroup viewGroup) {
        TbPageContext<?> tbPageContext = this.o;
        if (tbPageContext == null) {
            return null;
        }
        c cVar = new c(tbPageContext, this.f42913i);
        this.x = cVar;
        cVar.U(this.f42913i);
        this.x.a(this.w);
        this.x.p(this.z);
        return new FrsPageAlaShareHolder(this.x);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.r0.k, d.a.c.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, a2 a2Var, FrsPageAlaShareHolder frsPageAlaShareHolder) {
        CustomMessage customMessage = new CustomMessage(2921017);
        FrsViewData frsViewData = this.n;
        a2Var.O1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
        customMessage.setData(a2Var);
        this.o.sendMessage(customMessage);
        if (a2Var != null) {
            c cVar = frsPageAlaShareHolder.f14049a;
            if (cVar instanceof e) {
                cVar.setPage(this.y);
            }
            frsPageAlaShareHolder.f14049a.a(this.w);
            j.h(frsPageAlaShareHolder.f14049a.N(), this.n);
            j.h(frsPageAlaShareHolder.f14049a.P(), this.n);
            frsPageAlaShareHolder.f14049a.n(a2Var);
            a2Var.C4();
        }
        return frsPageAlaShareHolder.a();
    }
}
