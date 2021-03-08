package com.baidu.tieba.ala.personcenter.privilege.entereffect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class AlaEnterEffectCategoryAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a, ViewHolder> {
    public AlaEnterEffectCategoryAdapter(Context context) {
        super(context, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a.ieJ);
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
            ap.setViewTextColor(viewHolder.ieH, R.color.CAM_X0105, 1, skinType);
            ap.setBackgroundResource(viewHolder.ieI, R.color.CAM_X0204, skinType);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a aVar, ViewHolder viewHolder) {
        if (aVar != null) {
            viewHolder.ieH.setText(aVar.aHS);
        }
        if (i == 0) {
            viewHolder.ieI.setVisibility(8);
        } else {
            viewHolder.ieI.setVisibility(0);
        }
        a(viewHolder);
        return viewHolder.getView();
    }

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public TextView ieH;
        public View ieI;

        public ViewHolder(View view) {
            super(view);
            this.ieH = (TextView) getView().findViewById(R.id.enter_effect_txt);
            this.ieI = getView().findViewById(R.id.ala_enter_effect_devide);
        }
    }
}
