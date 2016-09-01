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
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements b.d {
    final /* synthetic */ p awL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.awL = pVar;
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
        dVar = this.awL.awK;
        if (dVar != null) {
            dVar2 = this.awL.awK;
            dVar2.callback(z, postWriteCallBackData, sVar, writeData, antiData);
        }
        if (z) {
            this.awL.awb = null;
            this.awL.awG = null;
            this.awL.bG(true);
            this.awL.DM();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            bVar = this.awL.awg;
            WriteData beT = bVar.beT();
            bVar2 = this.awL.awg;
            bVar2.d((WriteData) null);
            bVar3 = this.awL.awg;
            bVar3.kN(false);
            this.awL.awc = null;
            if (beT != null && beT != null && beT.getType() == 2) {
                aVar = this.awL.awI;
                aVar.Df();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.rG(i)) {
            this.awL.l(i, str);
        } else if (sVar != null && writeData != null && !StringUtils.isNull(sVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(sVar.getVcode_md5());
            writeData.setVcodeUrl(sVar.getVcode_pic_url());
            writeData.setVcodeExtra(sVar.xU());
            if (com.baidu.tbadk.k.a.gC(sVar.xT())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.awL.DI().getPageActivity(), 12006, writeData, false, sVar.xT())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.awL.DI().getPageActivity(), writeData, 12006)));
            }
        } else if (postWriteCallBackData != null && i == 227001) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.awL.Gd;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
        } else {
            this.awL.DI().showToast(str);
        }
    }
}
