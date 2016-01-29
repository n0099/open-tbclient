package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.card.a.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ u aPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aPT = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof l.a) {
            l.a aVar = (l.a) tag;
            if (!TextUtils.isEmpty(aVar.link)) {
                be wt = be.wt();
                TbPageContext<?> JK = this.aPT.JK();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                wt.c(JK, strArr);
            }
            str = this.aPT.aPR;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aPT.aPR;
                TiebaStatic.log(new com.baidu.tbadk.core.util.au(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
