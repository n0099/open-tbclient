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
import d.b.i0.t.d.f.c.g;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class LiveTabConcernTitleView extends b<g> {
    public ViewHolder m;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LiveTabConcernTitleView f14800a;

        /* renamed from: b  reason: collision with root package name */
        public View f14801b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14802c;

        public ViewHolder(LiveTabConcernTitleView liveTabConcernTitleView) {
            super(liveTabConcernTitleView.m());
            this.f14800a = liveTabConcernTitleView;
            View m = liveTabConcernTitleView.m();
            this.f14801b = m;
            this.f14802c = (TextView) m.findViewById(R.id.tab_sub_rec_title_tv);
        }
    }

    public LiveTabConcernTitleView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new ViewHolder(this);
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.tab_sub_title_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundColor(this.m.f14801b, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.m.f14802c, R.color.CAM_X0105);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(g gVar) {
        ViewHolder viewHolder;
        if (gVar == null || StringUtils.isNull(gVar.f60545f) || (viewHolder = this.m) == null) {
            return;
        }
        viewHolder.f14802c.setText(gVar.f60545f);
    }
}
