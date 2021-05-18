package com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.j.e.a;
/* loaded from: classes4.dex */
public class AlaEnterEffectCategoryAdapter extends a<d.a.k0.t.j.g.d.d.a, ViewHolder> {

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f14163a;

        /* renamed from: b  reason: collision with root package name */
        public View f14164b;

        public ViewHolder(View view) {
            super(view);
            this.f14163a = (TextView) a().findViewById(R.id.enter_effect_txt);
            this.f14164b = a().findViewById(R.id.ala_enter_effect_devide);
        }
    }

    public AlaEnterEffectCategoryAdapter(Context context) {
        super(context, d.a.k0.t.j.g.d.d.a.f61881f);
    }

    public final void e0(ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(viewHolder.f14163a, R.color.CAM_X0105, 1, skinType);
        SkinManager.setBackgroundResource(viewHolder.f14164b, R.color.CAM_X0204, skinType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public ViewHolder P(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f39564e).inflate(R.layout.ala_enter_effect_category_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.k0.t.j.g.d.d.a aVar, ViewHolder viewHolder) {
        if (aVar != null) {
            viewHolder.f14163a.setText(aVar.f61882e);
        }
        if (i2 == 0) {
            viewHolder.f14164b.setVisibility(8);
        } else {
            viewHolder.f14164b.setVisibility(0);
        }
        e0(viewHolder);
        return viewHolder.a();
    }
}
