package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.n0.v.d.f.c.e;
import d.a.n0.z.b;
/* loaded from: classes4.dex */
public class ConcernTabEmptyView extends b<e> {
    public ViewHolder m;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public View f13930a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13931b;

        /* renamed from: c  reason: collision with root package name */
        public View f13932c;

        public ViewHolder(View view) {
            super(view);
            this.f13930a = view;
            this.f13931b = (TextView) view.findViewById(R.id.tv_empty);
            this.f13932c = this.f13930a.findViewById(R.id.devider_line);
        }
    }

    public ConcernTabEmptyView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.m = new ViewHolder(m());
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.special_bar_concern_empty;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.m.f13931b, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.m.f13932c, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void n(e eVar) {
    }
}
