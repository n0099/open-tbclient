package com.baidu.tieba.homepage.listview;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    private final /* synthetic */ String aOd;
    final /* synthetic */ c byO;
    private final /* synthetic */ com.baidu.tieba.homepage.fragment.data.e byR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, com.baidu.tieba.homepage.fragment.data.e eVar, String str) {
        this.byO = cVar;
        this.byR = eVar;
        this.aOd = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.fragment.data.d.a(this.byR);
        if (bj.ah(this.byO.pageContext.getPageActivity()) && !StringUtils.isNull(this.aOd)) {
            bf.vD().b(this.byO.pageContext, new String[]{this.aOd});
        }
    }
}
