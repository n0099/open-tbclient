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
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.k0.a1.g.l.b;
import d.a.k0.x.t;
/* loaded from: classes4.dex */
public class ReadProgessDelegetAdapter extends d.a.c.j.e.a<b, ViewHolder> {
    public final TbPageContext<?> m;
    public w n;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.a.k0.a1.g.l.a f16556a;

        public ViewHolder(d.a.k0.a1.g.l.a aVar) {
            super(aVar.l());
            this.f16556a = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements w {
        public a(ReadProgessDelegetAdapter readProgessDelegetAdapter) {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            TiebaStatic.log(new StatisticItem("c11273"));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
        }
    }

    public ReadProgessDelegetAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        a aVar = new a(this);
        this.n = aVar;
        this.m = tbPageContext;
        Z(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public ViewHolder P(ViewGroup viewGroup) {
        return new ViewHolder(new d.a.k0.a1.g.l.a(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, b bVar, ViewHolder viewHolder) {
        t.b().a(new StatisticItem("c11272"));
        viewHolder.f16556a.m(bVar);
        return viewHolder.a();
    }
}
