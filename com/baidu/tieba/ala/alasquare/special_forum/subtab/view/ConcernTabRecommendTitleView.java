package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.t.d.f.c.g;
import d.a.j0.x.b;
/* loaded from: classes4.dex */
public class ConcernTabRecommendTitleView extends b<g> {
    public ViewHolder m;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14668a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14669b;

        /* renamed from: c  reason: collision with root package name */
        public View f14670c;

        public ViewHolder(View view) {
            super(view);
            this.f14668a = view;
            this.f14669b = (TextView) view.findViewById(R.id.title);
            this.f14670c = this.f14668a.findViewById(R.id.divider);
        }
    }

    public ConcernTabRecommendTitleView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new ViewHolder(l());
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.special_bar_concern_recommend_title;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f14669b, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(g gVar) {
        ViewHolder viewHolder = this.m;
        if (viewHolder != null) {
            if (gVar.f60718e) {
                viewHolder.f14670c.setVisibility(0);
            } else {
                viewHolder.f14670c.setVisibility(8);
            }
        }
    }
}
