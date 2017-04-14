package com.baidu.tbadk.editortools.pb;

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
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements NewWriteModel.d {
    final /* synthetic */ c aBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.aBg = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        BaseActivity baseActivity3;
        NewWriteModel.d dVar;
        NewWriteModel.d dVar2;
        NewWriteModel newWriteModel;
        String str;
        NewWriteModel newWriteModel2;
        if (writeData == null) {
            newWriteModel2 = this.aBg.aAP;
            writeData2 = newWriteModel2.getWriteData();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && qVar != null && !TextUtils.isEmpty(qVar.yG())) {
                writeData2.setVcodeMD5(qVar.getVcode_md5());
                writeData2.setVcodeUrl(qVar.getVcode_pic_url());
                writeData2.setVcodeExtra(qVar.yH());
                if (com.baidu.tbadk.o.a.gt(qVar.yG())) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity3 = this.aBg.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity3.getActivity(), 12006, writeData2, false, qVar.yG())));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity2 = this.aBg.mContext;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity2.getActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                MessageManager messageManager3 = MessageManager.getInstance();
                baseActivity = this.aBg.mContext;
                messageManager3.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(baseActivity.getActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
            }
        } else {
            this.aBg.bK(true);
            newWriteModel = this.aBg.aAP;
            WriteData writeData3 = newWriteModel.getWriteData();
            this.aBg.resetData();
            str = this.aBg.mThreadId;
            z.c(str, (WriteData) null);
            if (writeData3 != null) {
                if (writeData3 != null && writeData3.getType() == 2) {
                    z.a(writeData3.getThreadId(), this.aBg);
                }
            } else {
                return;
            }
        }
        dVar = this.aBg.aAX;
        if (dVar != null) {
            dVar2 = this.aBg.aAX;
            dVar2.callback(z, postWriteCallBackData, qVar, writeData2, antiData);
        }
    }
}
