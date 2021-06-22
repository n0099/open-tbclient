package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.o0.v.d.f.c.g;
import d.a.o0.z.b;
/* loaded from: classes4.dex */
public class ConcernTabRecommendTitleView extends b<g> {
    public ViewHolder m;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f14025a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f14026b;

        /* renamed from: c  reason: collision with root package name */
        public View f14027c;

        public ViewHolder(View view) {
            super(view);
            this.f14025a = view;
            this.f14026b = (TextView) view.findViewById(R.id.title);
            this.f14027c = this.f14025a.findViewById(R.id.divider);
        }
    }

    public ConcernTabRecommendTitleView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new ViewHolder(m());
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.special_bar_concern_recommend_title;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f14026b, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: t */
    public void n(g gVar) {
        ViewHolder viewHolder = this.m;
        if (viewHolder != null) {
            if (gVar.f65569e) {
                viewHolder.f14027c.setVisibility(0);
            } else {
                viewHolder.f14027c.setVisibility(8);
            }
        }
    }
}
