package com.baidu.tieba.homepage.listview.card.j;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bCb;
    private final /* synthetic */ b bCc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, b bVar) {
        this.bCb = cVar;
        this.bCc = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext<?> tbPageContext2;
        tbPageContext = this.bCb.pageContext;
        if (bj.ah(tbPageContext.getPageActivity())) {
            com.baidu.tieba.homepage.fragment.data.d.b(this.bCc);
            if (!StringUtils.isNull(this.bCc.bBY)) {
                bf vD = bf.vD();
                tbPageContext2 = this.bCb.mPageContext;
                vD.b(tbPageContext2, new String[]{this.bCc.bBY});
            }
        }
    }
}
