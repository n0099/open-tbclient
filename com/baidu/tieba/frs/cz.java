package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements com.baidu.tbadk.coreExtra.view.c {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.c
    public void a() {
        com.baidu.tbadk.core.data.f fVar;
        com.baidu.tbadk.core.data.f fVar2;
        com.baidu.tbadk.core.data.f fVar3;
        com.baidu.tbadk.core.data.f fVar4;
        com.baidu.tbadk.core.data.f fVar5;
        com.baidu.tbadk.core.data.f fVar6;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        BaseActivity baseActivity4;
        Pattern pattern;
        BaseActivity baseActivity5;
        BaseActivity baseActivity6;
        BaseActivity baseActivity7;
        BaseActivity baseActivity8;
        BaseActivity baseActivity9;
        BaseActivity baseActivity10;
        fVar = this.a.ai;
        String c = fVar.c();
        fVar2 = this.a.ai;
        if (fVar2 != null) {
            fVar3 = this.a.ai;
            if (fVar3.a() == 1) {
                baseActivity10 = this.a.g;
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.j(baseActivity10, c, false, "frs_banner")));
                return;
            }
            fVar4 = this.a.ai;
            if (fVar4.a() != 2) {
                fVar5 = this.a.ai;
                if (fVar5.a() == 3) {
                    baseActivity4 = this.a.g;
                    com.baidu.tbadk.browser.a.a(baseActivity4, c);
                    return;
                }
                fVar6 = this.a.ai;
                if (fVar6.a() == 4) {
                    baseActivity = this.a.g;
                    if (baseActivity instanceof BaseActivity) {
                        baseActivity2 = this.a.g;
                        baseActivity3 = this.a.g;
                        baseActivity2.sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(baseActivity3).a(c, "frs_banner")));
                    }
                }
            } else if (c.contains("tieba.baidu.com")) {
                pattern = ct.aj;
                Matcher matcher = pattern.matcher(c);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        baseActivity5 = this.a.g;
                        if (baseActivity5 instanceof BaseFragmentActivity) {
                            baseActivity9 = this.a.g;
                            ((BaseFragmentActivity) baseActivity5).a(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(baseActivity9).a(group, null, "frs_banner")));
                        } else {
                            baseActivity6 = this.a.g;
                            if (baseActivity6 instanceof BaseActivity) {
                                baseActivity7 = this.a.g;
                                baseActivity8 = this.a.g;
                                baseActivity7.sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(baseActivity8).a(group, null, "frs_banner")));
                            }
                        }
                    } catch (Exception e) {
                        BdLog.e(getClass().getName(), "onClick", e.toString());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.c
    public void b() {
        this.a.N();
    }
}
