package com.baidu.tbadk.editortools.d;

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
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b.d {
    final /* synthetic */ e awy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.awy = eVar;
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
            bVar2 = this.awy.awg;
            writeData2 = bVar2.beT();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && sVar != null && !TextUtils.isEmpty(sVar.xT())) {
                writeData2.setVcodeMD5(sVar.getVcode_md5());
                writeData2.setVcodeUrl(sVar.getVcode_pic_url());
                writeData2.setVcodeExtra(sVar.xU());
                if (com.baidu.tbadk.k.a.gC(sVar.xT())) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity3 = this.awy.awl;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity3.getActivity(), 12006, writeData2, false, sVar.xT())));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity2 = this.awy.awl;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity2.getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager3 = MessageManager.getInstance();
                baseActivity = this.awy.awl;
                messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(baseActivity.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            }
        } else {
            this.awy.bG(true);
            bVar = this.awy.awg;
            WriteData beT = bVar.beT();
            this.awy.resetData();
            str = this.awy.mThreadId;
            ae.c(str, (WriteData) null);
            if (beT != null) {
                if (beT != null && beT.getType() == 2) {
                    ae.a(beT.getThreadId(), this.awy);
                }
            } else {
                return;
            }
        }
        dVar = this.awy.awp;
        if (dVar != null) {
            dVar2 = this.awy.awp;
            dVar2.callback(z, postWriteCallBackData, sVar, writeData2, antiData);
        }
    }
}
