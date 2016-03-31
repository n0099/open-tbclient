package com.baidu.tbadk.editortools.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.d {
    final /* synthetic */ p awa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.awa = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.awa.avZ;
        if (dVar != null) {
            dVar2 = this.awa.avZ;
            dVar2.callback(z, postWriteCallBackData, nVar, writeData, antiData);
        }
        if (z) {
            this.awa.avq = null;
            this.awa.avV = null;
            this.awa.bw(true);
            this.awa.Eq();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.awa.avv;
            WriteData aUF = aVar.aUF();
            aVar2 = this.awa.avv;
            aVar2.d((WriteData) null);
            aVar3 = this.awa.avv;
            aVar3.iN(false);
            this.awa.avr = null;
            if (aUF != null && aUF != null && aUF.getType() == 2) {
                aVar4 = this.awa.avX;
                aVar4.DG();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.pB(i)) {
            this.awa.l(i, str);
        } else if (nVar != null && writeData != null && !StringUtils.isNull(nVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(nVar.getVcode_md5());
            writeData.setVcodeUrl(nVar.getVcode_pic_url());
            if (nVar.yM().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.awa.Em().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.awa.Em().getPageActivity(), writeData, 12006)));
            }
        } else {
            this.awa.Em().showToast(str);
        }
    }
}
