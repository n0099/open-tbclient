package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.r;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ce {
    final /* synthetic */ a cah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cah = aVar;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(cf cfVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, cm cmVar) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.entelechy.c.a.a aVar;
        ce ceVar;
        com.baidu.tieba.frs.entelechy.c.a.a aVar2;
        ce ceVar2;
        ce ceVar3;
        com.baidu.tieba.frs.entelechy.c.a.a aVar3;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        URI uri;
        if (i > 100) {
            if (cmVar != null && (cmVar.bVI instanceof String)) {
                try {
                    uri = new URI((String) cmVar.bVI);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    av avVar = new av("c10079");
                    avVar.ab("obj_type", host);
                    TiebaStatic.log(avVar);
                }
            }
        } else {
            av avVar2 = new av("c10074");
            avVar2.s("obj_type", i);
            frsActivity = this.cah.bZY;
            avVar2.ab("fid", frsActivity.getForumId());
            TiebaStatic.log(avVar2);
            if (i == 99) {
                av avVar3 = new av("c11500");
                avVar3.ab("obj_param1", "2").ab("obj_param2", "1");
                TiebaStatic.log(avVar3);
            }
        }
        if (HorizontalTabView.iE(i) && cmVar != null) {
            String str = (String) cmVar.bVI;
            if (!StringUtils.isNull(str)) {
                if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    frsActivity2 = this.cah.bZY;
                    k.showToast(frsActivity2.getPageContext().getPageActivity(), r.j.book_plugin_not_install_tip);
                    return;
                }
                bf vP = bf.vP();
                frsActivity3 = this.cah.bZY;
                vP.c(frsActivity3.getPageContext(), new String[]{str});
                return;
            }
            return;
        }
        if (i == 1) {
            aVar3 = this.cah.caa;
            aVar3.aeW();
        } else {
            aVar = this.cah.caa;
            aVar.aeX();
        }
        ceVar = this.cah.cab;
        if (ceVar != null) {
            aVar2 = this.cah.caa;
            if (aVar2.aeV() != 4 || i != 1) {
                ceVar2 = this.cah.cab;
                ceVar2.a(i, i2, cmVar);
                return;
            }
            ceVar3 = this.cah.cab;
            ceVar3.a(2, i2, cmVar);
        }
    }

    @Override // com.baidu.tieba.frs.ce
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ce
    public void abv() {
    }
}
