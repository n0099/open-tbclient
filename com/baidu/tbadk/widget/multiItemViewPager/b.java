package com.baidu.tbadk.widget.multiItemViewPager;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a aCF;
    private final /* synthetic */ c aCG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, c cVar) {
        this.aCF = aVar;
        this.aCG = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        ArrayList arrayList;
        TbPageContext<?> tbPageContext2;
        String str;
        String str2;
        String str3;
        String str4;
        tbPageContext = this.aCF.mContext;
        if (bj.ah(tbPageContext.getPageActivity())) {
            arrayList = this.aCF.aCC;
            int a = y.a(arrayList, this.aCG);
            if (a >= 0) {
                str = this.aCF.aCD;
                if (str != null) {
                    str2 = this.aCF.aCE;
                    if (str2 != null) {
                        str3 = this.aCF.aCD;
                        av avVar = new av(str3);
                        str4 = this.aCF.aCE;
                        TiebaStatic.log(avVar.r(str4, a + 1));
                    }
                }
            }
            bf vD = bf.vD();
            tbPageContext2 = this.aCF.mContext;
            vD.b(tbPageContext2, new String[]{this.aCG.link});
        }
    }
}
