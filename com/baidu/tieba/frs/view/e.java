package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c cme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cme = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.h hVar;
        if ((this.cme.Gf == null || this.cme.Gf.getOrignalPage() == null || this.cme.Gf.getOrignalPage().checkUpIsLogin()) && (hVar = (com.baidu.tieba.tbadkCore.h) view.getTag()) != null && !StringUtils.isNull(hVar.getUrl())) {
            String url = hVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.cme.Gf.getPageActivity(), r.j.book_plugin_not_install_tip);
                return;
            }
            bf.vP().c(this.cme.Gf, new String[]{url});
            a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.bke(), this.cme.bTA.getForumId(), this.cme.bTA.getForumName(), null);
            a.bV("obj_url", hVar.getUrl());
            a.save();
        }
    }
}
