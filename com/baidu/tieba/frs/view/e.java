package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.d.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c cgZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cgZ = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.tbadkCore.h hVar;
        if ((this.cgZ.Gd == null || this.cgZ.Gd.getOrignalPage() == null || this.cgZ.Gd.getOrignalPage().checkUpIsLogin()) && (hVar = (com.baidu.tieba.tbadkCore.h) view.getTag()) != null && !StringUtils.isNull(hVar.getUrl())) {
            String url = hVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.cgZ.Gd.getPageActivity(), t.j.book_plugin_not_install_tip);
                return;
            }
            bi.vx().c(this.cgZ.Gd, new String[]{url});
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.bha(), this.cgZ.bRp.getForumId(), this.cgZ.bRp.getForumName(), null);
            a.bS("obj_url", hVar.getUrl());
            a.save();
        }
    }
}
