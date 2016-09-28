package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c cgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cgX = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.h hVar;
        if ((this.cgX.Gd == null || this.cgX.Gd.getOrignalPage() == null || this.cgX.Gd.getOrignalPage().checkUpIsLogin()) && (hVar = (com.baidu.tieba.tbadkCore.h) view.getTag()) != null && !StringUtils.isNull(hVar.getUrl())) {
            String url = hVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.cgX.Gd.getPageActivity(), r.j.book_plugin_not_install_tip);
                return;
            }
            bh.vL().c(this.cgX.Gd, new String[]{url});
            a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.bhI(), this.cgX.bRi.getForumId(), this.cgX.bRi.getForumName(), null);
            a.bT("obj_url", hVar.getUrl());
            a.save();
        }
    }
}
