package com.baidu.tbadk.editortools.pb;

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
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements NewWriteModel.d {
    final /* synthetic */ n aBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aBg = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        NewWriteModel.d dVar;
        TbPageContext tbPageContext;
        NewWriteModel newWriteModel;
        NewWriteModel newWriteModel2;
        NewWriteModel newWriteModel3;
        DataModel dataModel;
        NewWriteModel.d dVar2;
        dVar = this.aBg.aBf;
        if (dVar != null) {
            dVar2 = this.aBg.aBf;
            dVar2.callback(z, postWriteCallBackData, qVar, writeData, antiData);
        }
        if (z) {
            this.aBg.aAx = null;
            this.aBg.aBb = null;
            this.aBg.bI(true);
            this.aBg.Di();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            newWriteModel = this.aBg.aAB;
            WriteData writeData2 = newWriteModel.getWriteData();
            newWriteModel2 = this.aBg.aAB;
            newWriteModel2.setWriteData(null);
            newWriteModel3 = this.aBg.aAB;
            newWriteModel3.lx(false);
            this.aBg.aAy = null;
            if (writeData2 != null && writeData2 != null && writeData2.getType() == 2) {
                dataModel = this.aBg.aBd;
                dataModel.CG();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.sr(i)) {
            this.aBg.m(i, str);
        } else if (qVar != null && writeData != null && !StringUtils.isNull(qVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(qVar.getVcode_md5());
            writeData.setVcodeUrl(qVar.getVcode_pic_url());
            writeData.setVcodeExtra(qVar.xO());
            if (com.baidu.tbadk.o.a.gq(qVar.xN())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.aBg.xw().getPageActivity(), 12006, writeData, false, qVar.xN())));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.aBg.xw().getPageActivity(), writeData, 12006)));
            }
        } else if (postWriteCallBackData != null && i == 227001) {
            MessageManager messageManager = MessageManager.getInstance();
            tbPageContext = this.aBg.aas;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(tbPageContext.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
        } else {
            this.aBg.xw().showToast(str);
        }
    }
}
