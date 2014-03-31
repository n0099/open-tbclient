package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
final class l implements com.baidu.tieba.model.as {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.as
    public final void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        cm cmVar;
        cm cmVar2;
        WriteImagesInfo writeImagesInfo;
        cm cmVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        com.baidu.tbadk.core.data.o oVar;
        com.baidu.tbadk.core.data.o oVar2;
        com.baidu.tbadk.core.data.o oVar3;
        cm cmVar4;
        this.a.r();
        cmVar = this.a.r;
        cmVar.h(z);
        cmVar2 = this.a.r;
        writeImagesInfo = this.a.S;
        cmVar2.a(writeImagesInfo, true);
        if (z) {
            cmVar3 = this.a.r;
            cmVar3.P();
            com.baidu.tieba.pb.main.bh.a().f();
            arVar = this.a.V;
            arVar.a();
            arVar2 = this.a.V;
            arVar2.a((WriteData) null);
            arVar3 = this.a.V;
            arVar3.a(false);
            FrsActivity.a(this.a, antiData, str);
            oVar = this.a.U;
            com.baidu.tieba.util.m.b(oVar.m(), (WriteData) null);
            oVar2 = this.a.U;
            oVar3 = this.a.U;
            oVar2.b(oVar3.o() + 1);
            cmVar4 = this.a.r;
            cmVar4.x();
        } else if (fVar == null || writeData == null || fVar.b() == null) {
            FrsActivity.a(this.a, antiData, str);
        } else if (AntiHelper.c(antiData)) {
            FrsActivity.a(this.a, antiData, str);
        } else {
            writeData.setVcodeMD5(fVar.a());
            writeData.setVcodeUrl(fVar.b());
            if (fVar.c().equals("4")) {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ac(this.a, 12006, writeData, false)));
            } else {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.au(this.a, writeData, 12006)));
            }
        }
    }
}
