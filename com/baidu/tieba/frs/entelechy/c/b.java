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
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.t;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dg {
    final /* synthetic */ a bWW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bWW = aVar;
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(dh dhVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.dg
    public void a(int i, int i2, dn dnVar) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        dg dgVar;
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        dg dgVar2;
        dg dgVar3;
        com.baidu.tieba.frs.entelechy.c.a.a aVar3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        URI uri;
        if (i > 100) {
            if (dnVar != null && (dnVar.bTF instanceof String)) {
                try {
                    uri = new URI((String) dnVar.bTF);
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
            frsActivity = this.bWW.bWH;
            ayVar2.ab("fid", frsActivity.getForumId());
            TiebaStatic.log(ayVar2);
            if (i == 99) {
                TiebaStatic.log(new ay("c11500").ab("obj_param1", "2").ab("obj_param2", "1"));
            }
        }
        if (HorizontalTabView.iu(i) && dnVar != null) {
            String str = (String) dnVar.bTF;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity2 = this.bWW.bWH;
                    k.showToast(frsActivity2.getPageContext().getPageActivity(), t.j.book_plugin_not_install_tip);
                    return;
                }
                bi vx = bi.vx();
                frsActivity3 = this.bWW.bWH;
                vx.c(frsActivity3.getPageContext(), new String[]{str});
                return;
            }
            return;
        }
        if (i == 1) {
            aVar3 = this.bWW.bWJ;
            aVar3.adp();
        } else {
            aVar = this.bWW.bWJ;
            aVar.adq();
        }
        dgVar = this.bWW.bWK;
        if (dgVar != null) {
            aVar2 = this.bWW.bWJ;
            if (aVar2.ado() != 4 || i != 1) {
                dgVar2 = this.bWW.bWK;
                dgVar2.a(i, i2, dnVar);
                return;
            }
            dgVar3 = this.bWW.bWK;
            dgVar3.a(2, i2, dnVar);
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dg
    public void aaf() {
    }
}
