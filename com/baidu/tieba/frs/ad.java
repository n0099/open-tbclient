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
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.g gVar, WriteData writeData, AntiData antiData) {
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
        this.aBu.hideProgressBar();
        this.aBu.EC();
        buVar = this.aBu.aAF;
        buVar.bQ(z);
        buVar2 = this.aBu.aAF;
        writeImagesInfo = this.aBu.writeImagesInfo;
        buVar2.a(writeImagesInfo, true);
        if (z) {
            buVar3 = this.aBu.aAF;
            buVar3.ER();
            com.baidu.tieba.pb.main.bs.Xc().reset();
            arVar = this.aBu.ayI;
            arVar.EE();
            arVar2 = this.aBu.ayI;
            arVar2.b((WriteData) null);
            arVar3 = this.aBu.ayI;
            arVar3.dI(false);
            writeImagesInfo2 = this.aBu.baobaoImagesInfo;
            writeImagesInfo2.clear();
            writeData2 = this.aBu.aAW;
            writeData2.setIsBaobao(false);
            this.aBu.a(antiData, str);
            qVar = this.aBu.aAX;
            com.baidu.tieba.util.l.b(qVar.getTid(), (WriteData) null);
            qVar2 = this.aBu.aAX;
            qVar3 = this.aBu.aAX;
            qVar2.setReply_num(qVar3.getReply_num() + 1);
            buVar4 = this.aBu.aAF;
            buVar4.Gr();
        } else if (gVar != null && writeData != null && gVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(gVar.getVcode_md5());
                writeData.setVcodeUrl(gVar.getVcode_pic_url());
                if (gVar.oC().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aBu, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aBu, writeData, 12006)));
                    return;
                }
            }
            this.aBu.a(antiData, str);
        } else {
            this.aBu.a(antiData, str);
        }
    }
}
