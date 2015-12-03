package com.baidu.tieba.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.a.a.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m aMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aMp = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Object tag = view.getTag();
        if (tag instanceof g.a) {
            g.a aVar = (g.a) tag;
            if (!TextUtils.isEmpty(aVar.link)) {
                bf vD = bf.vD();
                TbPageContext<?> Io = this.aMp.Io();
                String[] strArr = new String[3];
                strArr[0] = aVar.link;
                vD.b(Io, strArr);
            }
            str = this.aMp.aMn;
            if (!TextUtils.isEmpty(str)) {
                str2 = this.aMp.aMn;
                TiebaStatic.log(new av(str2).r("obj_locate", aVar.position));
            }
        }
    }
}
