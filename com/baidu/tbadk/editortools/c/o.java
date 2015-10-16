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
public class o implements a.d {
    final /* synthetic */ n asw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.asw = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.asw.asv;
        if (dVar != null) {
            dVar2 = this.asw.asv;
            dVar2.a(z, postWriteCallBackData, lVar, writeData, antiData);
        }
        if (z) {
            this.asw.arR = null;
            this.asw.bg(true);
            this.asw.BK();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.asw.arW;
            WriteData axO = aVar.axO();
            aVar2 = this.asw.arW;
            aVar2.c((WriteData) null);
            aVar3 = this.asw.arW;
            aVar3.gw(false);
            this.asw.arS = null;
            if (axO != null && axO != null && axO.getType() == 2) {
                aVar4 = this.asw.ast;
                aVar4.Bk();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || AntiHelper.lc(i)) {
            this.asw.t(i, str);
        } else if (lVar != null && writeData != null && !StringUtils.isNull(lVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.ws().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.asw.Bv().getActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.asw.Bv().getActivity(), writeData, 12006)));
            }
        } else {
            this.asw.Bv().showToast(str);
        }
    }
}
