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
import d.b.c.j.e.a;
/* loaded from: classes4.dex */
public class AlaEnterEffectCategoryAdapter extends a<d.b.j0.t.j.g.d.d.a, ViewHolder> {

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f14763a;

        /* renamed from: b  reason: collision with root package name */
        public View f14764b;

        public ViewHolder(View view) {
            super(view);
            this.f14763a = (TextView) a().findViewById(R.id.enter_effect_txt);
            this.f14764b = a().findViewById(R.id.ala_enter_effect_devide);
        }
    }

    public AlaEnterEffectCategoryAdapter(Context context) {
        super(context, d.b.j0.t.j.g.d.d.a.f62954f);
    }

    public final void h0(ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(viewHolder.f14763a, R.color.CAM_X0105, 1, skinType);
        SkinManager.setBackgroundResource(viewHolder.f14764b, R.color.CAM_X0204, skinType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public ViewHolder R(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f43095e).inflate(R.layout.ala_enter_effect_category_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.j0.t.j.g.d.d.a aVar, ViewHolder viewHolder) {
        if (aVar != null) {
            viewHolder.f14763a.setText(aVar.f62955e);
        }
        if (i == 0) {
            viewHolder.f14764b.setVisibility(8);
        } else {
            viewHolder.f14764b.setVisibility(0);
        }
        h0(viewHolder);
        return viewHolder.a();
    }
}
