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
    final /* synthetic */ p asP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.asP = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.asP.asO;
        if (dVar != null) {
            dVar2 = this.asP.asO;
            dVar2.callback(z, postWriteCallBackData, pVar, writeData, antiData);
        }
        if (z) {
            this.asP.asf = null;
            this.asP.asK = null;
            this.asP.bB(true);
            this.asP.Cs();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.asP.ask;
            WriteData bdu = aVar.bdu();
            aVar2 = this.asP.ask;
            aVar2.d((WriteData) null);
            aVar3 = this.asP.ask;
            aVar3.kn(false);
            this.asP.asg = null;
            if (bdu != null && bdu != null && bdu.getType() == 2) {
                aVar4 = this.asP.asM;
                aVar4.BK();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.qL(i)) {
            this.asP.l(i, str);
        } else if (pVar != null && writeData != null && !StringUtils.isNull(pVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(pVar.getVcode_md5());
            writeData.setVcodeUrl(pVar.getVcode_pic_url());
            writeData.setVcodeExtra(pVar.wK());
            if (com.baidu.tbadk.k.a.gA(pVar.wJ())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.asP.Co().getPageActivity(), 12006, writeData, false, pVar.wJ())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.asP.Co().getPageActivity(), writeData, 12006)));
            }
        } else {
            this.asP.Co().showToast(str);
        }
    }
}
