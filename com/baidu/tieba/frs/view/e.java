package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bXS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bXS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.g gVar;
        if ((this.bXS.Fp == null || this.bXS.Fp.getOrignalPage() == null || this.bXS.Fp.getOrignalPage().checkUpIsLogin()) && (gVar = (com.baidu.tieba.tbadkCore.g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
            String url = gVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.bXS.Fp.getPageActivity(), r.l.book_plugin_not_install_tip);
                return;
            }
            ba.vt().c(this.bXS.Fp, new String[]{url});
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bfH(), this.bXS.bHh.getForumId(), this.bXS.bHh.getForumName(), null);
            a.ch("obj_url", gVar.getUrl());
            a.save();
        }
    }
}
