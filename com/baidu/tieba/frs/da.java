package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements com.baidu.tbadk.coreExtra.view.c {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.c
    public void a() {
        com.baidu.tbadk.core.data.g gVar;
        com.baidu.tbadk.core.data.g gVar2;
        com.baidu.tbadk.core.data.g gVar3;
        com.baidu.tbadk.core.data.g gVar4;
        com.baidu.tbadk.core.data.g gVar5;
        com.baidu.tbadk.core.data.g gVar6;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        Pattern pattern;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        gVar = this.a.ah;
        String c = gVar.c();
        gVar2 = this.a.ah;
        if (gVar2 != null) {
            gVar3 = this.a.ah;
            if (gVar3.a() == 1) {
                frsActivity6 = this.a.i;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.o(frsActivity6, c, false, "frs_banner")));
                return;
            }
            gVar4 = this.a.ah;
            if (gVar4.a() != 2) {
                gVar5 = this.a.ah;
                if (gVar5.a() == 3) {
                    frsActivity3 = this.a.i;
                    com.baidu.tbadk.browser.a.a(frsActivity3, c);
                    return;
                }
                gVar6 = this.a.ah;
                if (gVar6.a() == 4) {
                    frsActivity = this.a.i;
                    frsActivity2 = this.a.i;
                    frsActivity.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(frsActivity2).a(c, "frs_banner")));
                }
            } else if (c.contains("tieba.baidu.com")) {
                pattern = cu.ai;
                Matcher matcher = pattern.matcher(c);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        frsActivity4 = this.a.i;
                        frsActivity5 = this.a.i;
                        frsActivity4.sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bb(frsActivity5).a(group, null, "frs_banner")));
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c
    public void b() {
        this.a.L();
    }
}
