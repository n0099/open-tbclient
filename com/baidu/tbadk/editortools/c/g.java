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
    final /* synthetic */ d asm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.asm = dVar;
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
            aVar2 = this.asm.arW;
            writeData2 = aVar2.axO();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && lVar != null && !TextUtils.isEmpty(lVar.ws())) {
                writeData2.setVcodeMD5(lVar.getVcode_md5());
                writeData2.setVcodeUrl(lVar.getVcode_pic_url());
                if (lVar.ws().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity2 = this.asm.asb;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity2.getActivity(), 12006, writeData2, false)));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity = this.asm.asb;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity.getActivity(), writeData2, 12006)));
                }
            }
        } else {
            this.asm.bg(true);
            aVar = this.asm.arW;
            WriteData axO = aVar.axO();
            this.asm.resetData();
            str = this.asm.mThreadId;
            ad.c(str, (WriteData) null);
            if (axO != null) {
                if (axO != null && axO.getType() == 2) {
                    ad.a(axO.getThreadId(), this.asm);
                }
                if (postWriteCallBackData != null && axO != null && axO.getVideoInfo() != null) {
                    XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), axO.getForumId(), axO.getVideoInfo().getVideoUrl(), axO.getForumName());
                }
            } else {
                return;
            }
        }
        dVar = this.asm.asg;
        if (dVar != null) {
            dVar2 = this.asm.asg;
            dVar2.a(z, postWriteCallBackData, lVar, writeData2, antiData);
        }
    }
}
