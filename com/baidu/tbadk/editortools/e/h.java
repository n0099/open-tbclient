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
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b.d {
    final /* synthetic */ e awr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.awr = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
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
            bVar2 = this.awr.avZ;
            writeData2 = bVar2.bbN();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.xQ())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.xR());
                if (com.baidu.tbadk.j.a.gB(qVar.xQ())) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity3 = this.awr.awe;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity3.getActivity(), 12006, writeData2, false, qVar.xQ())));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity2 = this.awr.awe;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity2.getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager3 = MessageManager.getInstance();
                baseActivity = this.awr.awe;
                messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(baseActivity.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            }
        } else {
            this.awr.bJ(true);
            bVar = this.awr.avZ;
            WriteData bbN = bVar.bbN();
            this.awr.resetData();
            str = this.awr.mThreadId;
            ac.c(str, (WriteData) null);
            if (bbN != null) {
                if (bbN != null && bbN.getType() == 2) {
                    ac.a(bbN.getThreadId(), this.awr);
                }
            } else {
                return;
            }
        }
        dVar = this.awr.awi;
        if (dVar != null) {
            dVar2 = this.awr.awi;
            dVar2.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
        }
    }
}
