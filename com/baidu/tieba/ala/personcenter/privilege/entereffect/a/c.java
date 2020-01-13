package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a, a> {
    public c(Context context) {
        super(context, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a.fuN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_category_layout, (ViewGroup) null));
    }

    private void a(a aVar) {
        if (aVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(aVar.fuL, R.color.cp_cont_b, 1, skinType);
            am.setBackgroundResource(aVar.fuM, R.color.cp_bg_line_c, skinType);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a aVar, a aVar2) {
        if (aVar != null) {
            aVar2.fuL.setText(aVar.VG);
        }
        if (i == 0) {
            aVar2.fuM.setVisibility(8);
        } else {
            aVar2.fuM.setVisibility(0);
        }
        a(aVar2);
        return aVar2.getView();
    }

    /* loaded from: classes2.dex */
    public static class a extends v.a {
        public TextView fuL;
        public View fuM;

        public a(View view) {
            super(view);
            this.fuL = (TextView) getView().findViewById(R.id.enter_effect_txt);
            this.fuM = getView().findViewById(R.id.ala_enter_effect_devide);
        }
    }
}
