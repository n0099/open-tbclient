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
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.d {
    final /* synthetic */ d ase;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.ase = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        a.d dVar;
        a.d dVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        String str;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData3;
        com.baidu.tieba.tbadkCore.writeModel.a aVar4;
        if (writeData == null) {
            aVar4 = this.ase.arO;
            writeData2 = aVar4.ard();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && lVar != null && !TextUtils.isEmpty(lVar.wC())) {
                writeData2.setVcodeMD5(lVar.getVcode_md5());
                writeData2.setVcodeUrl(lVar.getVcode_pic_url());
                if (lVar.wC().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity2 = this.ase.arT;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity2.getActivity(), 12006, writeData2, false)));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity = this.ase.arT;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity.getActivity(), writeData2, 12006)));
                }
            }
        } else {
            this.ase.bb(true);
            aVar = this.ase.arO;
            WriteData ard = aVar.ard();
            aVar2 = this.ase.arO;
            aVar2.c((WriteData) null);
            aVar3 = this.ase.arO;
            aVar3.fB(false);
            this.ase.arK = null;
            this.ase.arX = null;
            str = this.ase.mThreadId;
            ac.c(str, (WriteData) null);
            writeImagesInfo = this.ase.baobaoImagesInfo;
            writeImagesInfo.clear();
            writeData3 = this.ase.arL;
            writeData3.setIsBaobao(false);
            if (ard != null) {
                if (ard != null && ard.getType() == 2) {
                    ac.a(ard.getThreadId(), this.ase);
                }
                if (postWriteCallBackData != null && ard != null && ard.getVideoInfo() != null) {
                    XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), ard.getForumId(), ard.getVideoInfo().getVideoUrl(), ard.getForumName());
                }
            } else {
                return;
            }
        }
        dVar = this.ase.arY;
        if (dVar != null) {
            dVar2 = this.ase.arY;
            dVar2.a(z, postWriteCallBackData, lVar, writeData2, antiData);
        }
    }
}
