package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.widget.Toast;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c bWJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bWJ = cVar;
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
                z = this.bWJ.bWF;
                if (!z) {
                    this.bWJ.adS();
                    return;
                }
                av avVar = new av("c11729");
                str = this.bWJ.aRN;
                TiebaStatic.log(avVar.ab("fid", str));
                com.baidu.tieba.acrossForum.a MS = com.baidu.tieba.acrossForum.a.MS();
                frsActivity = this.bWJ.bTA;
                TbPageContext pageContext = frsActivity.getPageContext();
                str2 = this.bWJ.bWG;
                MS.b(pageContext, "frs_across", str2);
                return;
            }
            frsActivity2 = this.bWJ.bTA;
            Toast.makeText(frsActivity2.getPageContext().getPageActivity(), r.j.neterror, 0).show();
        }
    }
}
