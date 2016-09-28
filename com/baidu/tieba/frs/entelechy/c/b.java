package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.r;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dg {
    final /* synthetic */ a bWQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bWQ = aVar;
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
            if (dnVar != null && (dnVar.bTy instanceof String)) {
                try {
                    uri = new URI((String) dnVar.bTy);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    ax axVar = new ax("c10079");
                    axVar.ab("obj_type", host);
                    TiebaStatic.log(axVar);
                }
            }
        } else {
            ax axVar2 = new ax("c10074");
            axVar2.s("obj_type", i);
            frsActivity = this.bWQ.bWH;
            axVar2.ab("fid", frsActivity.getForumId());
            TiebaStatic.log(axVar2);
            if (i == 99) {
                TiebaStatic.log(new ax("c11500").ab("obj_param1", "2").ab("obj_param2", "1"));
            }
        }
        if (HorizontalTabView.iz(i) && dnVar != null) {
            String str = (String) dnVar.bTy;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity2 = this.bWQ.bWH;
                    k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                    return;
                }
                bh vL = bh.vL();
                frsActivity3 = this.bWQ.bWH;
                vL.c(frsActivity3.getPageContext(), new String[]{str});
                return;
            }
            return;
        }
        if (i == 1) {
            aVar3 = this.bWQ.bWJ;
            aVar3.adD();
        } else {
            aVar = this.bWQ.bWJ;
            aVar.adE();
        }
        dgVar = this.bWQ.bWK;
        if (dgVar != null) {
            aVar2 = this.bWQ.bWJ;
            if (aVar2.adC() != 4 || i != 1) {
                dgVar2 = this.bWQ.bWK;
                dgVar2.a(i, i2, dnVar);
                return;
            }
            dgVar3 = this.bWQ.bWK;
            dgVar3.a(2, i2, dnVar);
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dg
    public void aat() {
    }
}
