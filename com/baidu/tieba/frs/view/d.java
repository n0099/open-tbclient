package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b crq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.crq = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        if ((this.crq.aat == null || bl.aN(this.crq.aat.getPageActivity())) && view != null && (view.getTag() instanceof g) && (gVar = (g) view.getTag()) != null && !StringUtils.isNull(gVar.getUrl())) {
            String url = gVar.getUrl();
            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                com.baidu.adp.lib.util.k.showToast(this.crq.aat.getPageActivity(), w.l.book_plugin_not_install_tip);
                return;
            }
            be.vP().c(this.crq.aat, new String[]{url});
            a.C0085a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bku(), this.crq.cdv.getForumId(), this.crq.cdv.getForumName(), null);
            a.cf("obj_url", gVar.getUrl());
            a.save();
        }
    }
}
