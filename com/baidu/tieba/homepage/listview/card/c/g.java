package com.baidu.tieba.homepage.listview.card.c;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.c.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ e bAb;
    private final /* synthetic */ d bAc;
    private final /* synthetic */ d.a bAd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, d dVar, d.a aVar) {
        this.bAb = eVar;
        this.bAc = dVar;
        this.bAd = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        int a = y.a(this.bAc.bzV, this.bAd);
        if (a >= 0) {
            com.baidu.tieba.homepage.fragment.data.d.D("c10558", a + 1);
        }
        if (!StringUtils.isNull(this.bAd.bzX)) {
            bf vD = bf.vD();
            tbPageContext = this.bAb.mPageContext;
            vD.b(tbPageContext, new String[]{this.bAd.bzX});
        }
    }
}
