package com.baidu.tbadk.editortools.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements b.d {
    final /* synthetic */ p awo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.awo = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        b.d dVar;
        TbPageContext tbPageContext;
        com.baidu.tieba.tbadkCore.writeModel.b bVar;
        com.baidu.tieba.tbadkCore.writeModel.b bVar2;
        com.baidu.tieba.tbadkCore.writeModel.b bVar3;
        a aVar;
        b.d dVar2;
        dVar = this.awo.awn;
        if (dVar != null) {
            dVar2 = this.awo.awn;
            dVar2.callback(z, postWriteCallBackData, sVar, writeData, antiData);
        }
        if (z) {
            this.awo.avE = null;
            this.awo.awj = null;
            this.awo.bF(true);
            this.awo.DM();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            bVar = this.awo.avJ;
            WriteData bfE = bVar.bfE();
            bVar2 = this.awo.avJ;
            bVar2.d((WriteData) null);
            bVar3 = this.awo.avJ;
            bVar3.kQ(false);
            this.awo.avF = null;
            if (bfE != null && bfE != null && bfE.getType() == 2) {
                aVar = this.awo.awl;
                aVar.Df();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.rU(i)) {
            this.awo.l(i, str);
        } else if (sVar != null && writeData != null && !StringUtils.isNull(sVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(sVar.getVcode_md5());
            writeData.setVcodeUrl(sVar.getVcode_pic_url());
            writeData.setVcodeExtra(sVar.xX());
            if (com.baidu.tbadk.j.a.gG(sVar.xW())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.awo.DI().getPageActivity(), 12006, writeData, false, sVar.xW())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.awo.DI().getPageActivity(), writeData, 12006)));
            }
        } else if (postWriteCallBackData != null && i == 227001) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.awo.Gd;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
        } else {
            this.awo.DI().showToast(str);
        }
    }
}
