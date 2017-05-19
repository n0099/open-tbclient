package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b cdb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cdb = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        if ((this.cdb.aat == null || bg.aN(this.cdb.aat.getPageActivity())) && view != null && (view.getTag() instanceof g) && (gVar = (g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
            String url = gVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.cdb.aat.getPageActivity(), w.l.book_plugin_not_install_tip);
                return;
            }
            bb.vB().c(this.cdb.aat, new String[]{url});
            a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.beM(), this.cdb.bPw.getForumId(), this.cdb.bPw.getForumName(), null);
            a.cb("obj_url", gVar.getUrl());
            a.save();
        }
    }
}
