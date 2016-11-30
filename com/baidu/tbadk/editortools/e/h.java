package com.baidu.tbadk.editortools.e;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b.d {
    final /* synthetic */ e awU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.awU = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        b.d dVar;
        b.d dVar2;
        com.baidu.tieba.tbadkCore.writeModel.b bVar;
        String str;
        com.baidu.tieba.tbadkCore.writeModel.b bVar2;
        if (writeData == null) {
            bVar2 = this.awU.awC;
            writeData2 = bVar2.bia();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.yc())) {
                writeData2.setVcodeMD5(sVar.getVcode_md5());
                writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                writeData2.setVcodeExtra(sVar.yd());
                if (com.baidu.tbadk.j.a.gG(sVar.yc())) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity3 = this.awU.awH;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity3.getActivity(), 12006, writeData2, false, sVar.yc())));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity2 = this.awU.awH;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity2.getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager3 = MessageManager.getInstance();
                baseActivity = this.awU.awH;
                messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(baseActivity.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            }
        } else {
            this.awU.bJ(true);
            bVar = this.awU.awC;
            WriteData bia = bVar.bia();
            this.awU.resetData();
            str = this.awU.mThreadId;
            ad.c(str, (WriteData) null);
            if (bia != null) {
                if (bia != null && bia.getType() == 2) {
                    ad.a(bia.getThreadId(), this.awU);
                }
            } else {
                return;
            }
        }
        dVar = this.awU.awL;
        if (dVar != null) {
            dVar2 = this.awU.awL;
            dVar2.callback(z, postWriteCallBackData, sVar, writeData2, antiData);
        }
    }
}
