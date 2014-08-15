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
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.e eVar, WriteData writeData, AntiData antiData) {
        cu cuVar;
        cu cuVar2;
        WriteImagesInfo writeImagesInfo;
        cu cuVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        com.baidu.tbadk.core.data.n nVar3;
        cu cuVar4;
        this.a.J();
        cuVar = this.a.z;
        cuVar.h(z);
        cuVar2 = this.a.z;
        writeImagesInfo = this.a.aa;
        cuVar2.a(writeImagesInfo, true);
        if (z) {
            cuVar3 = this.a.z;
            cuVar3.U();
            com.baidu.tieba.pb.main.bp.a().f();
            arVar = this.a.af;
            arVar.a();
            arVar2 = this.a.af;
            arVar2.a((WriteData) null);
            arVar3 = this.a.af;
            arVar3.a(false);
            writeImagesInfo2 = this.a.ab;
            writeImagesInfo2.clear();
            writeData2 = this.a.ac;
            writeData2.setIsBaobao(false);
            this.a.a(antiData, str);
            nVar = this.a.ae;
            com.baidu.tieba.util.m.b(nVar.i(), (WriteData) null);
            nVar2 = this.a.ae;
            nVar3 = this.a.ae;
            nVar2.a(nVar3.k() + 1);
            cuVar4 = this.a.z;
            cuVar4.z();
        } else if (eVar != null && writeData != null && eVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(eVar.a());
                writeData.setVcodeUrl(eVar.b());
                if (eVar.c().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ay(this.a, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cd(this.a, writeData, 12006)));
                    return;
                }
            }
            this.a.a(antiData, str);
        } else {
            this.a.a(antiData, str);
        }
    }
}
