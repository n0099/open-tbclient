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
public class h implements a.d {
    final /* synthetic */ e aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aqO = eVar;
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
            aVar2 = this.aqO.aqv;
            writeData2 = aVar2.ayT();
        } else {
            writeData2 = writeData;
        }
        if (!z) {
            if (writeData2 != null && lVar != null && !TextUtils.isEmpty(lVar.wu())) {
                writeData2.setVcodeMD5(lVar.getVcode_md5());
                writeData2.setVcodeUrl(lVar.getVcode_pic_url());
                if (lVar.wu().equals("4")) {
                    MessageManager messageManager = MessageManager.getInstance();
                    baseActivity2 = this.aqO.aqA;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(baseActivity2.getActivity(), 12006, writeData2, false)));
                } else {
                    MessageManager messageManager2 = MessageManager.getInstance();
                    baseActivity = this.aqO.aqA;
                    messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(baseActivity.getActivity(), writeData2, 12006)));
                }
            }
        } else {
            this.aqO.bj(true);
            aVar = this.aqO.aqv;
            WriteData ayT = aVar.ayT();
            this.aqO.resetData();
            str = this.aqO.mThreadId;
            ad.c(str, (WriteData) null);
            if (ayT != null) {
                if (ayT != null && ayT.getType() == 2) {
                    ad.a(ayT.getThreadId(), this.aqO);
                }
                if (postWriteCallBackData != null && ayT != null && ayT.getVideoInfo() != null) {
                    XiaoyingUtil.reportEvent(postWriteCallBackData.getThreadId(), postWriteCallBackData.getPostId(), ayT.getForumId(), ayT.getVideoInfo().getVideoUrl(), ayT.getForumName());
                }
            } else {
                return;
            }
        }
        dVar = this.aqO.aqF;
        if (dVar != null) {
            dVar2 = this.aqO.aqF;
            dVar2.a(z, postWriteCallBackData, lVar, writeData2, antiData);
        }
    }
}
