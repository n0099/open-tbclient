package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.f.c {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.c
    public void a(boolean z, com.baidu.tieba.tbadkCore.f.f fVar, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        bp bpVar;
        bp bpVar2;
        WriteImagesInfo writeImagesInfo;
        bp bpVar3;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tbadk.core.data.x xVar;
        com.baidu.tbadk.core.data.x xVar2;
        com.baidu.tbadk.core.data.x xVar3;
        bp bpVar4;
        this.aDW.hideProgressBar();
        this.aDW.stopVoice();
        bpVar = this.aDW.aCY;
        bpVar.bG(z);
        bpVar2 = this.aDW.aCY;
        writeImagesInfo = this.aDW.writeImagesInfo;
        bpVar2.a(writeImagesInfo, true);
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (z) {
            bpVar3 = this.aDW.aCY;
            bpVar3.FH();
            TbadkCoreApplication.m255getInst().resetPbRecorder();
            aVar = this.aDW.aBM;
            aVar.Ft();
            aVar2 = this.aDW.aBM;
            aVar2.c((WriteData) null);
            aVar3 = this.aDW.aBM;
            aVar3.eF(false);
            writeImagesInfo2 = this.aDW.baobaoImagesInfo;
            writeImagesInfo2.clear();
            writeData2 = this.aDW.aDs;
            writeData2.setIsBaobao(false);
            this.aDW.a(antiData, fVar);
            xVar = this.aDW.aDt;
            com.baidu.tieba.tbadkCore.al.b(xVar.getTid(), (WriteData) null);
            xVar2 = this.aDW.aDt;
            xVar3 = this.aDW.aDt;
            xVar2.setReply_num(xVar3.getReply_num() + 1);
            bpVar4 = this.aDW.aCY;
            bpVar4.GT();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rQ().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aDW.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aDW.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aDW.a(antiData, str);
        } else {
            this.aDW.a(antiData, str);
        }
    }
}
