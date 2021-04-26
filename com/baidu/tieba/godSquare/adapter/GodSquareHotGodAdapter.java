package com.baidu.tieba.godSquare.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.j0.x.b0;
import d.a.j0.x.e0.h;
/* loaded from: classes4.dex */
public class GodSquareHotGodAdapter extends d.a.c.j.e.a<h, ViewHolder> {
    public TbPageContext<?> m;
    public d.a.j0.v0.d.a n;
    public b0 o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.a.j0.v0.d.a f16870a;

        public ViewHolder(GodSquareHotGodAdapter godSquareHotGodAdapter, d.a.j0.v0.d.a aVar) {
            super(aVar.l());
            this.f16870a = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0 {
        public a() {
        }

        @Override // d.a.j0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            h hVar;
            MetaData metaData;
            if (view == null || GodSquareHotGodAdapter.this.n == null || !(baseCardInfo instanceof h) || (metaData = (hVar = (h) baseCardInfo).f62471e) == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            if (view.getId() != GodSquareHotGodAdapter.this.n.m.getId()) {
                if (view.getId() == GodSquareHotGodAdapter.this.n.l().getId() || view.getId() == GodSquareHotGodAdapter.this.n.o.getId()) {
                    TiebaStatic.log(new StatisticItem("c10951").param("obj_id", hVar.f62471e.getUserId()));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c10803").param("obj_locate", 4).param("obj_id", hVar.f62471e.getUserId()));
        }
    }

    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.f62469h);
        this.o = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ViewHolder P(ViewGroup viewGroup) {
        d.a.j0.v0.d.a aVar = new d.a.j0.v0.d.a(this.m);
        this.n = aVar;
        aVar.t(this.m.getUniqueId());
        this.n.o(this.o);
        return new ViewHolder(this, this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        d.a.j0.v0.d.a aVar;
        if (viewHolder == null || (aVar = viewHolder.f16870a) == null) {
            return null;
        }
        aVar.m(hVar);
        return viewHolder.a();
    }
}
