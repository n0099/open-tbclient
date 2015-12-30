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
    final /* synthetic */ p auH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.auH = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.auH.auG;
        if (dVar != null) {
            dVar2 = this.auH.auG;
            dVar2.a(z, postWriteCallBackData, nVar, writeData, antiData);
        }
        if (z) {
            this.auH.atY = null;
            this.auH.bp(true);
            this.auH.Cq();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.auH.aud;
            WriteData aGz = aVar.aGz();
            aVar2 = this.auH.aud;
            aVar2.c((WriteData) null);
            aVar3 = this.auH.aud;
            aVar3.hw(false);
            this.auH.atZ = null;
            if (aGz != null && aGz != null && aGz.getType() == 2) {
                aVar4 = this.auH.auE;
                aVar4.BI();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.ne(i)) {
            this.auH.t(i, str);
        } else if (nVar != null && writeData != null && !StringUtils.isNull(nVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(nVar.getVcode_md5());
            writeData.setVcodeUrl(nVar.getVcode_pic_url());
            if (nVar.wY().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.auH.Cm().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.auH.Cm().getPageActivity(), writeData, 12006)));
            }
        } else {
            this.auH.Cm().showToast(str);
        }
    }
}
