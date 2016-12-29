package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.widget.Toast;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bCT = cVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        String str;
        FrsActivity frsActivity;
        String str2;
        FrsActivity frsActivity2;
        if (!com.baidu.tbadk.util.d.isFastDoubleClick()) {
            if (com.baidu.adp.lib.util.i.fZ()) {
                z = this.bCT.bCP;
                if (!z) {
                    this.bCT.Ym();
                    return;
                }
                at atVar = new at("c11729");
                str = this.bCT.aRe;
                TiebaStatic.log(atVar.ab("fid", str));
                com.baidu.tieba.acrossForum.a Ml = com.baidu.tieba.acrossForum.a.Ml();
                frsActivity = this.bCT.bzH;
                TbPageContext pageContext = frsActivity.getPageContext();
                str2 = this.bCT.bCQ;
                Ml.b(pageContext, "frs_across", str2);
                return;
            }
            frsActivity2 = this.bCT.bzH;
            Toast.makeText(frsActivity2.getPageContext().getPageActivity(), r.j.neterror, 0).show();
        }
    }
}
