package com.baidu.tieba.homepage.listview.card.b.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.homepage.fragment.data.d;
import com.baidu.tieba.homepage.listview.card.b.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bzO;
    private final /* synthetic */ b.a bzP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, b.a aVar2) {
        this.bzO = aVar;
        this.bzP = aVar2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        int i;
        TbPageContext<?> tbPageContext2;
        int i2;
        tbPageContext = this.bzO.mContext;
        if (bj.ah(tbPageContext.getPageActivity())) {
            i = this.bzO.position;
            if (i >= 0) {
                i2 = this.bzO.position;
                d.D("c10553", i2 + 1);
            }
            bf vD = bf.vD();
            tbPageContext2 = this.bzO.mContext;
            vD.b(tbPageContext2, new String[]{this.bzP.bzy});
        }
    }
}
