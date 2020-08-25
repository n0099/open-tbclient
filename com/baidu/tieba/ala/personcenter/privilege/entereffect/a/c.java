package com.baidu.tieba.ala.personcenter.privilege.entereffect.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a, a> {
    public c(Context context) {
        super(context, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a.gWF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_enter_effect_category_layout, (ViewGroup) null));
    }

    private void a(a aVar) {
        if (aVar != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(aVar.gWD, R.color.cp_cont_b, 1, skinType);
            ap.setBackgroundResource(aVar.gWE, R.color.cp_bg_line_c, skinType);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.personcenter.privilege.entereffect.data.a aVar, a aVar2) {
        if (aVar != null) {
            aVar2.gWD.setText(aVar.aDd);
        }
        if (i == 0) {
            aVar2.gWE.setVisibility(8);
        } else {
            aVar2.gWE.setVisibility(0);
        }
        a(aVar2);
        return aVar2.getView();
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public TextView gWD;
        public View gWE;

        public a(View view) {
            super(view);
            this.gWD = (TextView) getView().findViewById(R.id.enter_effect_txt);
            this.gWE = getView().findViewById(R.id.ala_enter_effect_devide);
        }
    }
}
