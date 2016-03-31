package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.a.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w aSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.aSO = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof m.a) {
            m.a aVar = (m.a) tag;
            if (!TextUtils.isEmpty(aVar.link)) {
                com.baidu.tbadk.core.util.bg wM = com.baidu.tbadk.core.util.bg.wM();
                TbPageContext<?> Lb = this.aSO.Lb();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                wM.c(Lb, strArr);
            }
            str = this.aSO.aSM;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aSO.aSM;
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
