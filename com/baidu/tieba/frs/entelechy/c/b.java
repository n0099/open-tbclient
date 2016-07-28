package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.ds;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.u;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dl {
    final /* synthetic */ a bLG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bLG = aVar;
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        dl dlVar;
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        dl dlVar2;
        dl dlVar3;
        com.baidu.tieba.frs.entelechy.c.a.a aVar3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        URI uri;
        if (i > 100) {
            if (dsVar != null && (dsVar.bID instanceof String)) {
                try {
                    uri = new URI((String) dsVar.bID);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    ay ayVar = new ay("c10079");
                    ayVar.ab("obj_type", host);
                    TiebaStatic.log(ayVar);
                }
            }
        } else {
            ay ayVar2 = new ay("c10074");
            ayVar2.s("obj_type", i);
            frsActivity = this.bLG.bLx;
            ayVar2.ab("fid", frsActivity.getForumId());
            TiebaStatic.log(ayVar2);
        }
        if (HorizontalTabView.hR(i) && dsVar != null) {
            String str = (String) dsVar.bID;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m10getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity2 = this.bLG.bLx;
                    k.showToast(frsActivity2.getPageContext().getPageActivity(), u.j.book_plugin_not_install_tip);
                    return;
                }
                bi us = bi.us();
                frsActivity3 = this.bLG.bLx;
                us.c(frsActivity3.getPageContext(), new String[]{str});
                return;
            }
            return;
        }
        if (i == 1) {
            aVar3 = this.bLG.bLz;
            aVar3.YD();
        } else {
            aVar = this.bLG.bLz;
            aVar.YE();
        }
        dlVar = this.bLG.bLA;
        if (dlVar != null) {
            aVar2 = this.bLG.bLz;
            if (aVar2.YC() != 4 || i != 1) {
                dlVar2 = this.bLG.bLA;
                dlVar2.a(i, i2, dsVar);
                return;
            }
            dlVar3 = this.bLG.bLA;
            dlVar3.a(2, i2, dsVar);
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dl
    public void Vk() {
    }
}
