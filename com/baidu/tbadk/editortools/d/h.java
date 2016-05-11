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
    final /* synthetic */ e arM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.arM = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        a.d dVar;
        a.d dVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        String str;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        if (writeData == null) {
            aVar2 = this.arM.aru;
            writeData2 = aVar2.aVa();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && oVar != null && !TextUtils.isEmpty(oVar.wF())) {
                writeData2.setVcodeMD5(oVar.getVcode_md5());
                writeData2.setVcodeUrl(oVar.getVcode_pic_url());
                if (oVar.wF().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity2 = this.arM.arz;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity2.getActivity(), 12006, writeData2, false)));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity = this.arM.arz;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity.getActivity(), writeData2, 12006)));
                }
            }
        } else {
            this.arM.bC(true);
            aVar = this.arM.aru;
            WriteData aVa = aVar.aVa();
            this.arM.resetData();
            str = this.arM.mThreadId;
            ae.c(str, (WriteData) null);
            if (aVa != null) {
                if (aVa != null && aVa.getType() == 2) {
                    ae.a(aVa.getThreadId(), this.arM);
                }
            } else {
                return;
            }
        }
        dVar = this.arM.arD;
        if (dVar != null) {
            dVar2 = this.arM.arD;
            dVar2.callback(z, postWriteCallBackData, oVar, writeData2, antiData);
        }
    }
}
