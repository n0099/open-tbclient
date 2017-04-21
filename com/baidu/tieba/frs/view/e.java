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
    final /* synthetic */ c cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cgf = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.g gVar;
        if ((this.cgf.aaY == null || this.cgf.aaY.getOrignalPage() == null || this.cgf.aaY.getOrignalPage().checkUpIsLogin()) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
            String url = gVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.cgf.aaY.getPageActivity(), w.l.book_plugin_not_install_tip);
                return;
            }
            bb.wn().c(this.cgf.aaY, new String[]{url});
            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bhk(), this.cgf.bQw.getForumId(), this.cgf.bQw.getForumName(), null);
            a.cb("obj_url", gVar.getUrl());
            a.save();
        }
    }
}
