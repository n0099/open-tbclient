package com.baidu.tbadk.editortools.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.d {
    final /* synthetic */ d atO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.atO = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        a.d dVar;
        a.d dVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        String str;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        if (writeData == null) {
            aVar2 = this.atO.aty;
            writeData2 = aVar2.avr();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && lVar != null && !TextUtils.isEmpty(lVar.wI())) {
                writeData2.setVcodeMD5(lVar.getVcode_md5());
                writeData2.setVcodeUrl(lVar.getVcode_pic_url());
                if (lVar.wI().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity2 = this.atO.atD;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity2.getActivity(), 12006, writeData2, false)));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity = this.atO.atD;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity.getActivity(), writeData2, 12006)));
                }
            }
        } else {
            this.atO.bi(true);
            aVar = this.atO.aty;
            WriteData avr = aVar.avr();
            this.atO.resetData();
            str = this.atO.mThreadId;
            ad.c(str, (WriteData) null);
            if (avr != null) {
                if (avr != null && avr.getType() == 2) {
                    ad.a(avr.getThreadId(), this.atO);
                }
                if (postWriteCallBackData != null && avr != null && avr.getVideoInfo() != null) {
                    XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), avr.getForumId(), avr.getVideoInfo().getVideoUrl(), avr.getForumName());
                }
            } else {
                return;
            }
        }
        dVar = this.atO.atI;
        if (dVar != null) {
            dVar2 = this.atO.atI;
            dVar2.a(z, postWriteCallBackData, lVar, writeData2, antiData);
        }
    }
}
