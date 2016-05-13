package com.baidu.tieba.frs.entelechy.tabView;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import java.net.URI;
import java.net.URISyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements fg {
    final /* synthetic */ a bps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bps = aVar;
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(fi fiVar) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.fg
    public void a(int i, int i2, fo foVar) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a aVar;
        fg fgVar;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a aVar2;
        fg fgVar2;
        fg fgVar3;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a aVar3;
        FrsActivity frsActivity2;
        URI uri;
        if (i > 100) {
            if (foVar != null && (foVar.bmS instanceof String)) {
                try {
                    uri = new URI((String) foVar.bmS);
                } catch (URISyntaxException e) {
                    BdLog.e(e);
                    uri = null;
                }
                if (uri != null) {
                    String host = uri.getHost();
                    aw awVar = new aw("c10079");
                    awVar.ac("obj_type", host);
                    TiebaStatic.log(awVar);
                }
            }
        } else {
            aw awVar2 = new aw("c10074");
            awVar2.s("obj_type", i);
            frsActivity = this.bps.bpj;
            awVar2.ac("fid", frsActivity.getForumId());
            TiebaStatic.log(awVar2);
        }
        if (HorizontalTabView.gL(i) && foVar != null) {
            String str = (String) foVar.bmS;
            if (!StringUtils.isNull(str)) {
                bg ut = bg.ut();
                frsActivity2 = this.bps.bpj;
                ut.c(frsActivity2.getPageContext(), new String[]{str});
                return;
            }
            return;
        }
        if (i == 1) {
            aVar3 = this.bps.bpl;
            aVar3.SI();
        } else {
            aVar = this.bps.bpl;
            aVar.SJ();
        }
        fgVar = this.bps.bpm;
        if (fgVar != null) {
            aVar2 = this.bps.bpl;
            if (aVar2.SH() != 4 || i != 1) {
                fgVar2 = this.bps.bpm;
                fgVar2.a(i, i2, foVar);
                return;
            }
            fgVar3 = this.bps.bpm;
            fgVar3.a(2, i2, foVar);
        }
    }

    @Override // com.baidu.tieba.frs.fg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fg
    public void Pa() {
    }
}
