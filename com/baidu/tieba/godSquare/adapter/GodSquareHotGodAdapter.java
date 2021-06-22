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
import d.a.o0.z.b0;
import d.a.o0.z.e0.h;
/* loaded from: classes4.dex */
public class GodSquareHotGodAdapter extends d.a.c.k.e.a<h, ViewHolder> {
    public TbPageContext<?> m;
    public d.a.o0.w0.d.a n;
    public b0 o;

    /* loaded from: classes4.dex */
    public class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public d.a.o0.w0.d.a f16232a;

        public ViewHolder(GodSquareHotGodAdapter godSquareHotGodAdapter, d.a.o0.w0.d.a aVar) {
            super(aVar.m());
            this.f16232a = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0 {
        public a() {
        }

        @Override // d.a.o0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            h hVar;
            MetaData metaData;
            if (view == null || GodSquareHotGodAdapter.this.n == null || !(baseCardInfo instanceof h) || (metaData = (hVar = (h) baseCardInfo).f67318e) == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            if (view.getId() != GodSquareHotGodAdapter.this.n.m.getId()) {
                if (view.getId() == GodSquareHotGodAdapter.this.n.m().getId() || view.getId() == GodSquareHotGodAdapter.this.n.o.getId()) {
                    TiebaStatic.log(new StatisticItem("c10951").param("obj_id", hVar.f67318e.getUserId()));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c10803").param("obj_locate", 4).param("obj_id", hVar.f67318e.getUserId()));
        }
    }

    public GodSquareHotGodAdapter(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), h.f67316h);
        this.o = new a();
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ViewHolder Q(ViewGroup viewGroup) {
        d.a.o0.w0.d.a aVar = new d.a.o0.w0.d.a(this.m);
        this.n = aVar;
        aVar.u(this.m.getUniqueId());
        this.n.p(this.o);
        return new ViewHolder(this, this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, h hVar, ViewHolder viewHolder) {
        d.a.o0.w0.d.a aVar;
        if (viewHolder == null || (aVar = viewHolder.f16232a) == null) {
            return null;
        }
        aVar.n(hVar);
        return viewHolder.a();
    }
}
