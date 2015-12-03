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
    final /* synthetic */ p atd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.atd = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.atd.atc;
        if (dVar != null) {
            dVar2 = this.atd.atc;
            dVar2.a(z, postWriteCallBackData, nVar, writeData, antiData);
        }
        if (z) {
            this.atd.asu = null;
            this.atd.bp(true);
            this.atd.CB();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.atd.asz;
            WriteData aEl = aVar.aEl();
            aVar2 = this.atd.asz;
            aVar2.c((WriteData) null);
            aVar3 = this.atd.asz;
            aVar3.hn(false);
            this.atd.asv = null;
            if (aEl != null && aEl != null && aEl.getType() == 2) {
                aVar4 = this.atd.ata;
                aVar4.BT();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.mC(i)) {
            this.atd.t(i, str);
        } else if (nVar != null && writeData != null && !StringUtils.isNull(nVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(nVar.getVcode_md5());
            writeData.setVcodeUrl(nVar.getVcode_pic_url());
            if (nVar.xp().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.atd.Cx().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.atd.Cx().getPageActivity(), writeData, 12006)));
            }
        } else {
            this.atd.Cx().showToast(str);
        }
    }
}
