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
    final /* synthetic */ n asv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.asv = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.asv.asu;
        if (dVar != null) {
            dVar2 = this.asv.asu;
            dVar2.a(z, postWriteCallBackData, lVar, writeData, antiData);
        }
        if (z) {
            this.asv.arQ = null;
            this.asv.bg(true);
            this.asv.BK();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.asv.arV;
            WriteData axE = aVar.axE();
            aVar2 = this.asv.arV;
            aVar2.c((WriteData) null);
            aVar3 = this.asv.arV;
            aVar3.gw(false);
            this.asv.arR = null;
            if (axE != null && axE != null && axE.getType() == 2) {
                aVar4 = this.asv.ass;
                aVar4.Bk();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || AntiHelper.la(i)) {
            this.asv.t(i, str);
        } else if (lVar != null && writeData != null && !StringUtils.isNull(lVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(lVar.getVcode_md5());
            writeData.setVcodeUrl(lVar.getVcode_pic_url());
            if (lVar.ws().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.asv.Bv().getActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.asv.Bv().getActivity(), writeData, 12006)));
            }
        } else {
            this.asv.Bv().showToast(str);
        }
    }
}
