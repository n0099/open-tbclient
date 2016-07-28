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
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.d {
    final /* synthetic */ e atr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.atr = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        a.d dVar;
        a.d dVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        String str;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        if (writeData == null) {
            aVar2 = this.atr.asZ;
            writeData2 = aVar2.bbo();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && pVar != null && !TextUtils.isEmpty(pVar.wJ())) {
                writeData2.setVcodeMD5(pVar.getVcode_md5());
                writeData2.setVcodeUrl(pVar.getVcode_pic_url());
                writeData2.setVcodeExtra(pVar.wK());
                if (com.baidu.tbadk.k.a.gz(pVar.wJ())) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity3 = this.atr.ate;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity3.getActivity(), 12006, writeData2, false, pVar.wJ())));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity2 = this.atr.ate;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity2.getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager3 = MessageManager.getInstance();
                baseActivity = this.atr.ate;
                messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(baseActivity.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            }
        } else {
            this.atr.bE(true);
            aVar = this.atr.asZ;
            WriteData bbo = aVar.bbo();
            this.atr.resetData();
            str = this.atr.mThreadId;
            af.c(str, (WriteData) null);
            if (bbo != null) {
                if (bbo != null && bbo.getType() == 2) {
                    af.a(bbo.getThreadId(), this.atr);
                }
            } else {
                return;
            }
        }
        dVar = this.atr.ati;
        if (dVar != null) {
            dVar2 = this.atr.ati;
            dVar2.callback(z, postWriteCallBackData, pVar, writeData2, antiData);
        }
    }
}
