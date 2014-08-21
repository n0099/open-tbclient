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
        cv cvVar;
        cv cvVar2;
        WriteImagesInfo writeImagesInfo;
        cv cvVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        com.baidu.tbadk.core.data.n nVar3;
        cv cvVar4;
        this.a.K();
        cvVar = this.a.B;
        cvVar.h(z);
        cvVar2 = this.a.B;
        writeImagesInfo = this.a.ac;
        cvVar2.a(writeImagesInfo, true);
        if (z) {
            cvVar3 = this.a.B;
            cvVar3.U();
            com.baidu.tieba.pb.main.bp.a().f();
            arVar = this.a.ah;
            arVar.a();
            arVar2 = this.a.ah;
            arVar2.a((WriteData) null);
            arVar3 = this.a.ah;
            arVar3.a(false);
            writeImagesInfo2 = this.a.ad;
            writeImagesInfo2.clear();
            writeData2 = this.a.ae;
            writeData2.setIsBaobao(false);
            this.a.a(antiData, str);
            nVar = this.a.ag;
            com.baidu.tieba.util.m.b(nVar.i(), (WriteData) null);
            nVar2 = this.a.ag;
            nVar3 = this.a.ag;
            nVar2.a(nVar3.k() + 1);
            cvVar4 = this.a.B;
            cvVar4.z();
        } else if (eVar != null && writeData != null && eVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(eVar.a());
                writeData.setVcodeUrl(eVar.b());
                if (eVar.c().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.az(this.a, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ce(this.a, writeData, 12006)));
                    return;
                }
            }
            this.a.a(antiData, str);
        } else {
            this.a.a(antiData, str);
        }
    }
}
