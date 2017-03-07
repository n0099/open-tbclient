package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cfo = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.g gVar;
        if ((this.cfo.aaI == null || this.cfo.aaI.getOrignalPage() == null || this.cfo.aaI.getOrignalPage().checkUpIsLogin()) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
            String url = gVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.cfo.aaI.getPageActivity(), w.l.book_plugin_not_install_tip);
                return;
            }
            bb.vQ().c(this.cfo.aaI, new String[]{url});
            a.C0075a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bfu(), this.cfo.bOq.getForumId(), this.cfo.bOq.getForumName(), null);
            a.cb("obj_url", gVar.getUrl());
            a.save();
        }
    }
}
