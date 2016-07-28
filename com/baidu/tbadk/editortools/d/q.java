package com.baidu.tbadk.editortools.d;

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
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.d {
    final /* synthetic */ p atE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.atE = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        TbPageContext tbPageContext;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.atE.atD;
        if (dVar != null) {
            dVar2 = this.atE.atD;
            dVar2.callback(z, postWriteCallBackData, pVar, writeData, antiData);
        }
        if (z) {
            this.atE.asU = null;
            this.atE.atz = null;
            this.atE.bE(true);
            this.atE.Cr();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.atE.asZ;
            WriteData bbo = aVar.bbo();
            aVar2 = this.atE.asZ;
            aVar2.d((WriteData) null);
            aVar3 = this.atE.asZ;
            aVar3.kB(false);
            this.atE.asV = null;
            if (bbo != null && bbo != null && bbo.getType() == 2) {
                aVar4 = this.atE.atB;
                aVar4.BK();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.rg(i)) {
            this.atE.l(i, str);
        } else if (pVar != null && writeData != null && !StringUtils.isNull(pVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(pVar.getVcode_md5());
            writeData.setVcodeUrl(pVar.getVcode_pic_url());
            writeData.setVcodeExtra(pVar.wK());
            if (com.baidu.tbadk.k.a.gz(pVar.wJ())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.atE.Cn().getPageActivity(), 12006, writeData, false, pVar.wJ())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.atE.Cn().getPageActivity(), writeData, 12006)));
            }
        } else if (postWriteCallBackData != null && i == 227001) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.atE.DQ;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
        } else {
            this.atE.Cn().showToast(str);
        }
    }
}
