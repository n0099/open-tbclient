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
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.c
    public void a(boolean z, com.baidu.tieba.tbadkCore.f.f fVar, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        bq bqVar;
        bq bqVar2;
        WriteImagesInfo writeImagesInfo;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tbadk.core.data.w wVar;
        com.baidu.tbadk.core.data.w wVar2;
        com.baidu.tbadk.core.data.w wVar3;
        bq bqVar4;
        this.aCV.hideProgressBar();
        this.aCV.stopVoice();
        bqVar = this.aCV.aBX;
        bqVar.bD(z);
        bqVar2 = this.aCV.aBX;
        writeImagesInfo = this.aCV.writeImagesInfo;
        bqVar2.a(writeImagesInfo, true);
        String str = "";
        if (fVar != null) {
            str = fVar.getErrorString();
        }
        if (z) {
            bqVar3 = this.aCV.aBX;
            bqVar3.Fj();
            TbadkCoreApplication.m255getInst().resetPbRecorder();
            aVar = this.aCV.aAK;
            aVar.EV();
            aVar2 = this.aCV.aAK;
            aVar2.c((WriteData) null);
            aVar3 = this.aCV.aAK;
            aVar3.ey(false);
            writeImagesInfo2 = this.aCV.baobaoImagesInfo;
            writeImagesInfo2.clear();
            writeData2 = this.aCV.aCr;
            writeData2.setIsBaobao(false);
            this.aCV.a(antiData, fVar);
            wVar = this.aCV.aCs;
            com.baidu.tieba.tbadkCore.al.b(wVar.getTid(), (WriteData) null);
            wVar2 = this.aCV.aCs;
            wVar3 = this.aCV.aCs;
            wVar2.setReply_num(wVar3.getReply_num() + 1);
            bqVar4 = this.aCV.aBX;
            bqVar4.Gw();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rD().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aCV.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aCV.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aCV.a(antiData, str);
        } else {
            this.aCV.a(antiData, str);
        }
    }
}
