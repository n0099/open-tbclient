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
import d.a.k0.v0.d.b;
import d.a.k0.x.b0;
import d.a.k0.x.e0.h;
/* loaded from: classes4.dex */
public class GodSquareRecGodAdapter extends d.a.c.j.e.a<h, ViewHolder> {
    public TbPageContext<?> m;
    public b n;
    public b0 o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public b f16187a;

        public ViewHolder(GodSquareRecGodAdapter godSquareRecGodAdapter, b bVar) {
            super(bVar.l());
            this.f16187a = bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0 {
        public a() {
        }

        @Override // d.a.k0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            h hVar;
            MetaData metaData;
            if (view == null || GodSquareRecGodAdapter.this.n == null || !(baseCardInfo instanceof h) || (metaData = (hVar = (h) baseCardInfo).f63195e) == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            if (view.getId() != GodSquareRecGodAdapter.this.n.m.getId()) {
                if (view.getId() == GodSquareRecGodAdapter.this.n.l().getId() || view.getId() == GodSquareRecGodAdapter.this.n.o.getId()) {
                    TiebaStatic.log(new StatisticItem("c10951").param("obj_id", hVar.f63195e.getUserId()));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c10803").param("obj_locate", 4).param("obj_id", hVar.f63195e.getUserId()));
        }
    }

    public GodSquareRecGodAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), h.f63194i);
        this.o = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ViewHolder P(ViewGroup viewGroup) {
        b bVar = new b(this.m);
        this.n = bVar;
        bVar.t(this.m.getUniqueId());
        this.n.o(this.o);
        return new ViewHolder(this, this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        b bVar;
        if (viewHolder == null || (bVar = viewHolder.f16187a) == null) {
            return null;
        }
        bVar.m(hVar);
        return viewHolder.a();
    }
}
