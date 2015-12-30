package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.card.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aNQ = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof i.a) {
            i.a aVar = (i.a) tag;
            if (!TextUtils.isEmpty(aVar.link)) {
                bf vn = bf.vn();
                TbPageContext<?> Ie = this.aNQ.Ie();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                vn.b(Ie, strArr);
            }
            str = this.aNQ.aNO;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aNQ.aNO;
                TiebaStatic.log(new av(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
