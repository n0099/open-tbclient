package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a, a> {
    public c(Context context) {
        super(context, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a.grS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aI */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_category_layout, (ViewGroup) null));
    }

    private void a(a aVar) {
        if (aVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(aVar.grQ, R.color.cp_cont_b, 1, skinType);
            am.setBackgroundResource(aVar.grR, R.color.cp_bg_line_c, skinType);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a aVar, a aVar2) {
        if (aVar != null) {
            aVar2.grQ.setText(aVar.auI);
        }
        if (i == 0) {
            aVar2.grR.setVisibility(8);
        } else {
            aVar2.grR.setVisibility(0);
        }
        a(aVar2);
        return aVar2.getView();
    }

    /* loaded from: classes3.dex */
    public static class a extends aa.a {
        public TextView grQ;
        public View grR;

        public a(View view) {
            super(view);
            this.grQ = (TextView) getView().findViewById(R.id.enter_effect_txt);
            this.grR = getView().findViewById(R.id.ala_enter_effect_devide);
        }
    }
}
