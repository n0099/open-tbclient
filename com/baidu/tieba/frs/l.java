package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.model.as {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        ct ctVar;
        ct ctVar2;
        WriteImagesInfo writeImagesInfo;
        ct ctVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        com.baidu.tbadk.core.data.n nVar3;
        ct ctVar4;
        this.a.L();
        ctVar = this.a.w;
        ctVar.g(z);
        ctVar2 = this.a.w;
        writeImagesInfo = this.a.Y;
        ctVar2.a(writeImagesInfo, true);
        if (z) {
            ctVar3 = this.a.w;
            ctVar3.U();
            com.baidu.tieba.pb.main.bn.a().f();
            arVar = this.a.ab;
            arVar.a();
            arVar2 = this.a.ab;
            arVar2.a((WriteData) null);
            arVar3 = this.a.ab;
            arVar3.a(false);
            this.a.a(antiData, str);
            nVar = this.a.aa;
            com.baidu.tieba.util.m.b(nVar.q(), (WriteData) null);
            nVar2 = this.a.aa;
            nVar3 = this.a.aa;
            nVar2.b(nVar3.s() + 1);
            ctVar4 = this.a.w;
            ctVar4.z();
        } else if (fVar != null && writeData != null && fVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(fVar.a());
                writeData.setVcodeUrl(fVar.b());
                if (fVar.c().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ao(this.a, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bg(this.a, writeData, 12006)));
                    return;
                }
            }
            this.a.a(antiData, str);
        } else {
            this.a.a(antiData, str);
        }
    }
}
