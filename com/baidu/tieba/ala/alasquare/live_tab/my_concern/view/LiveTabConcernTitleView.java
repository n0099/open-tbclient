package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.v.d.f.c.g;
import d.a.n0.z.b;
/* loaded from: classes4.dex */
public class LiveTabConcernTitleView extends b<g> {
    public ViewHolder m;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LiveTabConcernTitleView f13761a;

        /* renamed from: b  reason: collision with root package name */
        public View f13762b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f13763c;

        public ViewHolder(LiveTabConcernTitleView liveTabConcernTitleView) {
            super(liveTabConcernTitleView.l());
            this.f13761a = liveTabConcernTitleView;
            View l = liveTabConcernTitleView.l();
            this.f13762b = l;
            this.f13763c = (TextView) l.findViewById(R.id.tab_sub_rec_title_tv);
        }
    }

    public LiveTabConcernTitleView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new ViewHolder(this);
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.tab_sub_title_view;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundColor(this.m.f13762b, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.m.f13763c, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: s */
    public void m(g gVar) {
        ViewHolder viewHolder;
        if (gVar == null || StringUtils.isNull(gVar.f61731f) || (viewHolder = this.m) == null) {
            return;
        }
        viewHolder.f13763c.setText(gVar.f61731f);
    }
}
