package com.baidu.tieba.homepage.personalize.readProgressBar;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.j0.a1.g.l.b;
import d.b.j0.x.t;
/* loaded from: classes4.dex */
public class ReadProgessDelegetAdapter extends d.b.c.j.e.a<b, ViewHolder> {
    public final TbPageContext<?> m;
    public w n;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.b.j0.a1.g.l.a f16969a;

        public ViewHolder(d.b.j0.a1.g.l.a aVar) {
            super(aVar.m());
            this.f16969a = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements w {
        public a(ReadProgessDelegetAdapter readProgessDelegetAdapter) {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            TiebaStatic.log(new StatisticItem("c11273"));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
        }
    }

    public ReadProgessDelegetAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        a aVar = new a(this);
        this.n = aVar;
        this.m = tbPageContext;
        c0(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public ViewHolder R(ViewGroup viewGroup) {
        return new ViewHolder(new d.b.j0.a1.g.l.a(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, b bVar, ViewHolder viewHolder) {
        t.b().a(new StatisticItem("c11272"));
        viewHolder.f16969a.n(bVar);
        return viewHolder.a();
    }
}
