package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.model.as {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        bu buVar;
        bu buVar2;
        WriteImagesInfo writeImagesInfo;
        bu buVar3;
        com.baidu.tieba.model.ar arVar;
        com.baidu.tieba.model.ar arVar2;
        com.baidu.tieba.model.ar arVar3;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        com.baidu.tbadk.core.data.q qVar;
        com.baidu.tbadk.core.data.q qVar2;
        com.baidu.tbadk.core.data.q qVar3;
        bu buVar4;
        this.aBk.hideProgressBar();
        this.aBk.EA();
        buVar = this.aBk.aAv;
        buVar.bQ(z);
        buVar2 = this.aBk.aAv;
        writeImagesInfo = this.aBk.writeImagesInfo;
        buVar2.a(writeImagesInfo, true);
        if (z) {
            buVar3 = this.aBk.aAv;
            buVar3.EP();
            com.baidu.tieba.pb.main.bs.WZ().reset();
            arVar = this.aBk.ayz;
            arVar.EC();
            arVar2 = this.aBk.ayz;
            arVar2.b((WriteData) null);
            arVar3 = this.aBk.ayz;
            arVar3.dI(false);
            writeImagesInfo2 = this.aBk.baobaoImagesInfo;
            writeImagesInfo2.clear();
            writeData2 = this.aBk.aAM;
            writeData2.setIsBaobao(false);
            this.aBk.a(antiData, str);
            qVar = this.aBk.aAN;
            com.baidu.tieba.util.l.b(qVar.getTid(), (WriteData) null);
            qVar2 = this.aBk.aAN;
            qVar3 = this.aBk.aAN;
            qVar2.setReply_num(qVar3.getReply_num() + 1);
            buVar4 = this.aBk.aAv;
            buVar4.Gp();
        } else if (fVar != null && writeData != null && fVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(fVar.getVcode_md5());
                writeData.setVcodeUrl(fVar.getVcode_pic_url());
                if (fVar.oA().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aBk, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aBk, writeData, 12006)));
                    return;
                }
            }
            this.aBk.a(antiData, str);
        } else {
            this.aBk.a(antiData, str);
        }
    }
}
