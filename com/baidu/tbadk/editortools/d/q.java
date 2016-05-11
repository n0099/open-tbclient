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
    final /* synthetic */ p arZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.arZ = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        a.d dVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        a aVar4;
        a.d dVar2;
        dVar = this.arZ.arY;
        if (dVar != null) {
            dVar2 = this.arZ.arY;
            dVar2.callback(z, postWriteCallBackData, oVar, writeData, antiData);
        }
        if (z) {
            this.arZ.arp = null;
            this.arZ.arU = null;
            this.arZ.bC(true);
            this.arZ.Cj();
        }
        int i = -1;
        String str = "";
        if (postWriteCallBackData != null) {
            i = postWriteCallBackData.getErrorCode();
            str = postWriteCallBackData.getErrorString();
        }
        if (z) {
            aVar = this.arZ.aru;
            WriteData aVa = aVar.aVa();
            aVar2 = this.arZ.aru;
            aVar2.d((WriteData) null);
            aVar3 = this.arZ.aru;
            aVar3.jC(false);
            this.arZ.arq = null;
            if (aVa != null && aVa != null && aVa.getType() == 2) {
                aVar4 = this.arZ.arW;
                aVar4.BA();
            }
        } else if (i == 230277 || i == 230278 || i == 340016 || i == 1990032 || AntiHelper.pw(i)) {
            this.arZ.l(i, str);
        } else if (oVar != null && writeData != null && !StringUtils.isNull(oVar.getVcode_pic_url())) {
            writeData.setVcodeMD5(oVar.getVcode_md5());
            writeData.setVcodeUrl(oVar.getVcode_pic_url());
            if (oVar.wF().equals("4")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(this.arZ.Cf().getPageActivity(), 12006, writeData, false)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(this.arZ.Cf().getPageActivity(), writeData, 12006)));
            }
        } else {
            this.arZ.Cf().showToast(str);
        }
    }
}
