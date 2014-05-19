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
        cs csVar;
        cs csVar2;
        WriteImagesInfo writeImagesInfo;
        cs csVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        com.baidu.tbadk.core.data.o oVar;
        com.baidu.tbadk.core.data.o oVar2;
        com.baidu.tbadk.core.data.o oVar3;
        cs csVar4;
        this.a.K();
        csVar = this.a.w;
        csVar.g(z);
        csVar2 = this.a.w;
        writeImagesInfo = this.a.Z;
        csVar2.a(writeImagesInfo, true);
        if (z) {
            csVar3 = this.a.w;
            csVar3.U();
            com.baidu.tieba.pb.main.bg.a().f();
            arVar = this.a.ac;
            arVar.a();
            arVar2 = this.a.ac;
            arVar2.a((WriteData) null);
            arVar3 = this.a.ac;
            arVar3.a(false);
            this.a.a(antiData, str);
            oVar = this.a.ab;
            com.baidu.tieba.util.m.b(oVar.l(), (WriteData) null);
            oVar2 = this.a.ab;
            oVar3 = this.a.ab;
            oVar2.b(oVar3.n() + 1);
            csVar4 = this.a.w;
            csVar4.z();
        } else if (fVar != null && writeData != null && fVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(fVar.a());
                writeData.setVcodeUrl(fVar.b());
                if (fVar.c().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ap(this.a, 12006, writeData, false)));
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
