package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.model.ar {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.ar
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        ct ctVar;
        ct ctVar2;
        WriteImagesInfo writeImagesInfo;
        ct ctVar3;
        com.baidu.tieba.model.aq aqVar;
        com.baidu.tieba.model.aq aqVar2;
        com.baidu.tieba.model.aq aqVar3;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tbadk.core.data.m mVar;
        com.baidu.tbadk.core.data.m mVar2;
        com.baidu.tbadk.core.data.m mVar3;
        ct ctVar4;
        this.a.L();
        ctVar = this.a.v;
        ctVar.g(z);
        ctVar2 = this.a.v;
        writeImagesInfo = this.a.X;
        ctVar2.a(writeImagesInfo, true);
        if (z) {
            ctVar3 = this.a.v;
            ctVar3.T();
            com.baidu.tieba.pb.main.bq.a().f();
            aqVar = this.a.ac;
            aqVar.a();
            aqVar2 = this.a.ac;
            aqVar2.a((WriteData) null);
            aqVar3 = this.a.ac;
            aqVar3.a(false);
            writeImagesInfo2 = this.a.Y;
            writeImagesInfo2.clear();
            writeData2 = this.a.Z;
            writeData2.setIsBaobao(false);
            this.a.a(antiData, str);
            mVar = this.a.ab;
            com.baidu.tieba.util.m.b(mVar.q(), (WriteData) null);
            mVar2 = this.a.ab;
            mVar3 = this.a.ab;
            mVar2.b(mVar3.s() + 1);
            ctVar4 = this.a.v;
            ctVar4.y();
        } else if (fVar != null && writeData != null && fVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(fVar.a());
                writeData.setVcodeUrl(fVar.b());
                if (fVar.c().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.at(this.a, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bu(this.a, writeData, 12006)));
                    return;
                }
            }
            this.a.a(antiData, str);
        } else {
            this.a.a(antiData, str);
        }
    }
}
