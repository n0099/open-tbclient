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
import d.a.c.k.e.a;
/* loaded from: classes4.dex */
public class AlaEnterEffectCategoryAdapter extends a<d.a.o0.v.j.g.d.d.a, ViewHolder> {

    /* loaded from: classes4.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f14205a;

        /* renamed from: b  reason: collision with root package name */
        public View f14206b;

        public ViewHolder(View view) {
            super(view);
            this.f14205a = (TextView) a().findViewById(R.id.enter_effect_txt);
            this.f14206b = a().findViewById(R.id.ala_enter_effect_devide);
        }
    }

    public AlaEnterEffectCategoryAdapter(Context context) {
        super(context, d.a.o0.v.j.g.d.d.a.f66009f);
    }

    public final void e0(ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(viewHolder.f14205a, R.color.CAM_X0105, 1, skinType);
        SkinManager.setBackgroundResource(viewHolder.f14206b, R.color.CAM_X0204, skinType);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public ViewHolder Q(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.f43012e).inflate(R.layout.ala_enter_effect_category_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.o0.v.j.g.d.d.a aVar, ViewHolder viewHolder) {
        if (aVar != null) {
            viewHolder.f14205a.setText(aVar.f66010e);
        }
        if (i2 == 0) {
            viewHolder.f14206b.setVisibility(8);
        } else {
            viewHolder.f14206b.setVisibility(0);
        }
        e0(viewHolder);
        return viewHolder.a();
    }
}
