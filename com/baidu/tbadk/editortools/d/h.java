package com.baidu.tbadk.editortools.d;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.d {
    final /* synthetic */ e auv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.auv = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        a.d dVar;
        a.d dVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        String str;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        if (writeData == null) {
            aVar2 = this.auv.aud;
            writeData2 = aVar2.aGz();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && nVar != null && !TextUtils.isEmpty(nVar.wY())) {
                writeData2.setVcodeMD5(nVar.getVcode_md5());
                writeData2.setVcodeUrl(nVar.getVcode_pic_url());
                if (nVar.wY().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity2 = this.auv.aui;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity2.getActivity(), 12006, writeData2, false)));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity = this.auv.aui;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity.getActivity(), writeData2, 12006)));
                }
            }
        } else {
            this.auv.bp(true);
            aVar = this.auv.aud;
            WriteData aGz = aVar.aGz();
            this.auv.resetData();
            str = this.auv.mThreadId;
            ae.c(str, (WriteData) null);
            if (aGz != null) {
                if (aGz != null && aGz.getType() == 2) {
                    ae.a(aGz.getThreadId(), this.auv);
                }
            } else {
                return;
            }
        }
        dVar = this.auv.aum;
        if (dVar != null) {
            dVar2 = this.auv.aum;
            dVar2.a(z, postWriteCallBackData, nVar, writeData2, antiData);
        }
    }
}
