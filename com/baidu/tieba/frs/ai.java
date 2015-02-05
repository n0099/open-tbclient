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
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.aDT = frsActivity;
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
        this.aDT.hideProgressBar();
        this.aDT.stopVoice();
        bpVar = this.aDT.aCV;
        bpVar.bG(z);
        bpVar2 = this.aDT.aCV;
        writeImagesInfo = this.aDT.writeImagesInfo;
        bpVar2.a(writeImagesInfo, true);
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (z) {
            bpVar3 = this.aDT.aCV;
            bpVar3.FB();
            TbadkCoreApplication.m255getInst().resetPbRecorder();
            aVar = this.aDT.aBJ;
            aVar.Fn();
            aVar2 = this.aDT.aBJ;
            aVar2.c((WriteData) null);
            aVar3 = this.aDT.aBJ;
            aVar3.eF(false);
            writeImagesInfo2 = this.aDT.baobaoImagesInfo;
            writeImagesInfo2.clear();
            writeData2 = this.aDT.aDp;
            writeData2.setIsBaobao(false);
            this.aDT.a(antiData, fVar);
            xVar = this.aDT.aDq;
            com.baidu.tieba.tbadkCore.al.b(xVar.getTid(), (WriteData) null);
            xVar2 = this.aDT.aDq;
            xVar3 = this.aDT.aDq;
            xVar2.setReply_num(xVar3.getReply_num() + 1);
            bpVar4 = this.aDT.aCV;
            bpVar4.GN();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rK().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aDT.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aDT.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aDT.a(antiData, str);
        } else {
            this.aDT.a(antiData, str);
        }
    }
}
