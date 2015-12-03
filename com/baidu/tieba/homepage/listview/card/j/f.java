package com.baidu.tieba.homepage.listview.card.j;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.c.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ d.a bAd;
    final /* synthetic */ c bCb;
    private final /* synthetic */ b bCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, b bVar, d.a aVar) {
        this.bCb = cVar;
        this.bCc = bVar;
        this.bAd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext<?> tbPageContext2;
        tbPageContext = this.bCb.pageContext;
        if (bj.ah(tbPageContext.getPageActivity())) {
            int a = y.a(this.bCc.bBZ, this.bAd);
            if (a >= 0) {
                com.baidu.tieba.homepage.fragment.data.d.D("c10551", a + 1);
            }
            if (!StringUtils.isNull(this.bAd.bzX)) {
                bf vD = bf.vD();
                tbPageContext2 = this.bCb.mPageContext;
                vD.b(tbPageContext2, new String[]{this.bAd.bzX});
            }
        }
    }
}
