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
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.d {
    final /* synthetic */ e avn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.avn = eVar;
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
            aVar2 = this.avn.auV;
            writeData2 = aVar2.aND();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && nVar != null && !TextUtils.isEmpty(nVar.yl())) {
                writeData2.setVcodeMD5(nVar.getVcode_md5());
                writeData2.setVcodeUrl(nVar.getVcode_pic_url());
                if (nVar.yl().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity2 = this.avn.ava;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity2.getActivity(), 12006, writeData2, false)));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity = this.avn.ava;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity.getActivity(), writeData2, 12006)));
                }
            }
        } else {
            this.avn.br(true);
            aVar = this.avn.auV;
            WriteData aND = aVar.aND();
            this.avn.resetData();
            str = this.avn.mThreadId;
            ad.c(str, (WriteData) null);
            if (aND != null) {
                if (aND != null && aND.getType() == 2) {
                    ad.a(aND.getThreadId(), this.avn);
                }
            } else {
                return;
            }
        }
        dVar = this.avn.ave;
        if (dVar != null) {
            dVar2 = this.avn.ave;
            dVar2.a(z, postWriteCallBackData, nVar, writeData2, antiData);
        }
    }
}
