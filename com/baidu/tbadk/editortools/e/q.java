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
    final /* synthetic */ p axh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.axh = pVar;
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
        dVar = this.axh.axg;
        if (dVar != null) {
            dVar2 = this.axh.axg;
            dVar2.callback(z, postWriteCallBackData, sVar, writeData, antiData);
        }
        if (z) {
            this.axh.awy = null;
            this.axh.axc = null;
            this.axh.bJ(true);
            this.axh.DQ();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            bVar = this.axh.awC;
            WriteData bia = bVar.bia();
            bVar2 = this.axh.awC;
            bVar2.d((WriteData) null);
            bVar3 = this.axh.awC;
            bVar3.lp(false);
            this.axh.awz = null;
            if (bia != null && bia != null && bia.getType() == 2) {
                aVar = this.axh.axe;
                aVar.Dn();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.sm(i)) {
            this.axh.k(i, str);
        } else if (sVar != null && writeData != null && !StringUtils.isNull(sVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(sVar.getVcode_md5());
            writeData.setVcodeUrl(sVar.getVcode_pic_url());
            writeData.setVcodeExtra(sVar.yd());
            if (com.baidu.tbadk.j.a.gG(sVar.yc())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.axh.xL().getPageActivity(), 12006, writeData, false, sVar.yc())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.axh.xL().getPageActivity(), writeData, 12006)));
            }
        } else if (postWriteCallBackData != null && i == 227001) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.axh.Gf;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
        } else {
            this.axh.xL().showToast(str);
        }
    }
}
