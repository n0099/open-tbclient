package com.baidu.tbadk.editortools.c;

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
    final /* synthetic */ p ara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.ara = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.ara.aqZ;
        if (dVar != null) {
            dVar2 = this.ara.aqZ;
            dVar2.a(z, postWriteCallBackData, lVar, writeData, antiData);
        }
        if (z) {
            this.ara.aqq = null;
            this.ara.bj(true);
            this.ara.BA();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.ara.aqv;
            WriteData ayT = aVar.ayT();
            aVar2 = this.ara.aqv;
            aVar2.c((WriteData) null);
            aVar3 = this.ara.aqv;
            aVar3.gC(false);
            this.ara.aqr = null;
            if (ayT != null && ayT != null && ayT.getType() == 2) {
                aVar4 = this.ara.aqX;
                aVar4.AU();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.lr(i)) {
            this.ara.s(i, str);
        } else if (lVar != null && writeData != null && !StringUtils.isNull(lVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.wu().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.ara.Bj().getActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.ara.Bj().getActivity(), writeData, 12006)));
            }
        } else {
            this.ara.Bj().showToast(str);
        }
    }
}
