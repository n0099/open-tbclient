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
import d.b.j0.x.b0;
import d.b.j0.x.e0.h;
/* loaded from: classes4.dex */
public class GodSquareHotGodAdapter extends d.b.c.j.e.a<h, ViewHolder> {
    public TbPageContext<?> m;
    public d.b.j0.v0.d.a n;
    public b0 o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.b.j0.v0.d.a f16621a;

        public ViewHolder(GodSquareHotGodAdapter godSquareHotGodAdapter, d.b.j0.v0.d.a aVar) {
            super(aVar.m());
            this.f16621a = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0 {
        public a() {
        }

        @Override // d.b.j0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            h hVar;
            MetaData metaData;
            if (view == null || GodSquareHotGodAdapter.this.n == null || !(baseCardInfo instanceof h) || (metaData = (hVar = (h) baseCardInfo).f64207e) == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            if (view.getId() != GodSquareHotGodAdapter.this.n.m.getId()) {
                if (view.getId() == GodSquareHotGodAdapter.this.n.m().getId() || view.getId() == GodSquareHotGodAdapter.this.n.o.getId()) {
                    TiebaStatic.log(new StatisticItem("c10951").param("obj_id", hVar.f64207e.getUserId()));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c10803").param("obj_locate", 4).param("obj_id", hVar.f64207e.getUserId()));
        }
    }

    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.f64206h);
        this.o = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public ViewHolder R(ViewGroup viewGroup) {
        d.b.j0.v0.d.a aVar = new d.b.j0.v0.d.a(this.m);
        this.n = aVar;
        aVar.v(this.m.getUniqueId());
        this.n.q(this.o);
        return new ViewHolder(this, this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        d.b.j0.v0.d.a aVar;
        if (viewHolder == null || (aVar = viewHolder.f16621a) == null) {
            return null;
        }
        aVar.n(hVar);
        return viewHolder.a();
    }
}
