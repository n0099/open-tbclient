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
    final /* synthetic */ p awE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.awE = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        b.d dVar;
        TbPageContext tbPageContext;
        com.baidu.tieba.tbadkCore.writeModel.b bVar;
        com.baidu.tieba.tbadkCore.writeModel.b bVar2;
        com.baidu.tieba.tbadkCore.writeModel.b bVar3;
        a aVar;
        b.d dVar2;
        dVar = this.awE.awD;
        if (dVar != null) {
            dVar2 = this.awE.awD;
            dVar2.callback(z, postWriteCallBackData, qVar, writeData, antiData);
        }
        if (z) {
            this.awE.avV = null;
            this.awE.awz = null;
            this.awE.bJ(true);
            this.awE.Dy();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            bVar = this.awE.avZ;
            WriteData bbN = bVar.bbN();
            bVar2 = this.awE.avZ;
            bVar2.d((WriteData) null);
            bVar3 = this.awE.avZ;
            bVar3.la(false);
            this.awE.avW = null;
            if (bbN != null && bbN != null && bbN.getType() == 2) {
                aVar = this.awE.awB;
                aVar.CW();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.rp(i)) {
            this.awE.k(i, str);
        } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(qVar.getVcode_md5());
            writeData.setVcodeUrl(qVar.getVcode_pic_url());
            writeData.setVcodeExtra(qVar.xR());
            if (com.baidu.tbadk.j.a.gB(qVar.xQ())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.awE.xz().getPageActivity(), 12006, writeData, false, qVar.xQ())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.awE.xz().getPageActivity(), writeData, 12006)));
            }
        } else if (postWriteCallBackData != null && i == 227001) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.awE.Gf;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
        } else {
            this.awE.xz().showToast(str);
        }
    }
}
