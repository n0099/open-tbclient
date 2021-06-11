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
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.b1.h.l.b;
import d.a.n0.z.t;
/* loaded from: classes4.dex */
public class ReadProgessDelegetAdapter extends d.a.c.k.e.a<b, ViewHolder> {
    public final TbPageContext<?> m;
    public w n;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.b1.h.l.a f16529a;

        public ViewHolder(d.a.n0.b1.h.l.a aVar) {
            super(aVar.m());
            this.f16529a = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements w {
        public a(ReadProgessDelegetAdapter readProgessDelegetAdapter) {
        }

        @Override // d.a.c.k.e.w
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
        a0(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: e0 */
    public ViewHolder Q(ViewGroup viewGroup) {
        return new ViewHolder(new d.a.n0.b1.h.l.a(this.m, viewGroup));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, b bVar, ViewHolder viewHolder) {
        t.b().a(new StatisticItem("c11272"));
        viewHolder.f16529a.n(bVar);
        return viewHolder.a();
    }
}
