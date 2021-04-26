package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.t.d.f.c.e;
import d.a.j0.x.b;
/* loaded from: classes4.dex */
public class ConcernTabEmptyView extends b<e> {
    public ViewHolder m;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14655a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14656b;

        /* renamed from: c  reason: collision with root package name */
        public View f14657c;

        public ViewHolder(View view) {
            super(view);
            this.f14655a = view;
            this.f14656b = (TextView) view.findViewById(R.id.tv_empty);
            this.f14657c = this.f14655a.findViewById(R.id.devider_line);
        }
    }

    public ConcernTabEmptyView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new ViewHolder(l());
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.special_bar_concern_empty;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f14656b, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.m.f14657c, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(e eVar) {
    }
}
