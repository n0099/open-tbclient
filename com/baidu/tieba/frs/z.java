package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements c.b {
    final /* synthetic */ FrsActivity bzl;
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity, com.baidu.tbadk.core.data.bg bgVar) {
        this.bzl = frsActivity;
        this.bzo = bgVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        String str;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        boolean z3;
        cVar.dismiss();
        switch (i) {
            case 0:
                str3 = this.bzl.mThreadId;
                if (str3 != null) {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bzl.getPageContext().getPageActivity());
                    com.baidu.tbadk.core.data.bg bgVar = this.bzo;
                    String str4 = this.bzl.bxY;
                    z3 = this.bzl.bye;
                    PbActivityConfig createFromThreadCfg = pbActivityConfig.createFromThreadCfg(bgVar, str4, null, 18003, true, false, z3);
                    createFromThreadCfg.setVideo_source("frs");
                    this.bzl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                    break;
                }
                break;
            case 1:
                FrsActivity frsActivity = this.bzl;
                str2 = this.bzl.mThreadId;
                com.baidu.tbadk.core.data.bg bgVar2 = this.bzo;
                z2 = this.bzl.bye;
                com.baidu.tieba.frs.utils.t.a(frsActivity, str2, bgVar2, z2);
                break;
            case 2:
                FrsActivity frsActivity2 = this.bzl;
                str = this.bzl.mThreadId;
                com.baidu.tbadk.core.data.bg bgVar3 = this.bzo;
                z = this.bzl.bye;
                com.baidu.tieba.frs.utils.t.b(frsActivity2, str, bgVar3, z);
                break;
        }
        com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
        if (readThreadHistory != null && this.bzo != null && !readThreadHistory.qv(this.bzo.getId())) {
            readThreadHistory.qu(this.bzo.getId());
        }
        this.bzl.byg.Xj();
    }
}
