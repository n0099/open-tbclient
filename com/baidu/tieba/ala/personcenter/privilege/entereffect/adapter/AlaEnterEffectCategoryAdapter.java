package com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class AlaEnterEffectCategoryAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a, ViewHolder> {
    public AlaEnterEffectCategoryAdapter(Context context) {
        super(context, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a.icV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aZ */
    public ViewHolder e(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_category_layout, (ViewGroup) null));
    }

    private void a(ViewHolder viewHolder) {
        if (viewHolder != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setViewTextColor(viewHolder.icT, R.color.CAM_X0105, 1, skinType);
            ao.setBackgroundResource(viewHolder.icU, R.color.CAM_X0204, skinType);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a aVar, ViewHolder viewHolder) {
        if (aVar != null) {
            viewHolder.icT.setText(aVar.aJs);
        }
        if (i == 0) {
            viewHolder.icU.setVisibility(8);
        } else {
            viewHolder.icU.setVisibility(0);
        }
        a(viewHolder);
        return viewHolder.getView();
    }

    /* loaded from: classes10.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public TextView icT;
        public View icU;

        public ViewHolder(View view) {
            super(view);
            this.icT = (TextView) getView().findViewById(R.id.enter_effect_txt);
            this.icU = getView().findViewById(R.id.ala_enter_effect_devide);
        }
    }
}
