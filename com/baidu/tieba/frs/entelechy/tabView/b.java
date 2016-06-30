package com.baidu.tieba.frs.entelechy.tabView;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.ds;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dl {
    final /* synthetic */ a bKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKa = aVar;
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a aVar;
        dl dlVar;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a aVar2;
        dl dlVar2;
        dl dlVar3;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a aVar3;
        FrsActivity frsActivity2;
        URI uri;
        if (i > 100) {
            if (dsVar != null && (dsVar.bHh instanceof String)) {
                try {
                    uri = new URI((String) dsVar.bHh);
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
            frsActivity = this.bKa.bJR;
            ayVar2.ab("fid", frsActivity.getForumId());
            TiebaStatic.log(ayVar2);
        }
        if (HorizontalTabView.hQ(i) && dsVar != null) {
            String str = (String) dsVar.bHh;
            if (!StringUtils.isNull(str)) {
                bi us = bi.us();
                frsActivity2 = this.bKa.bJR;
                us.c(frsActivity2.getPageContext(), new String[]{str});
                return;
            }
            return;
        }
        if (i == 1) {
            aVar3 = this.bKa.bJT;
            aVar3.Yj();
        } else {
            aVar = this.bKa.bJT;
            aVar.Yk();
        }
        dlVar = this.bKa.bJU;
        if (dlVar != null) {
            aVar2 = this.bKa.bJT;
            if (aVar2.Yi() != 4 || i != 1) {
                dlVar2 = this.bKa.bJU;
                dlVar2.a(i, i2, dsVar);
                return;
            }
            dlVar3 = this.bKa.bJU;
            dlVar3.a(2, i2, dsVar);
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dl
    public void UC() {
    }
}
