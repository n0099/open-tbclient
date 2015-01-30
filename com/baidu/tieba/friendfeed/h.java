package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.al;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.tbadkCore.f.b {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.b
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        x xVar;
        x xVar2;
        WriteImagesInfo writeImagesInfo;
        x xVar3;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        FriendFeedThreadData friendFeedThreadData;
        FriendFeedThreadData friendFeedThreadData2;
        FriendFeedThreadData friendFeedThreadData3;
        x xVar4;
        this.aBV.stopVoice();
        xVar = this.aBV.aBD;
        xVar.bG(z);
        xVar2 = this.aBV.aBD;
        writeImagesInfo = this.aBV.aql;
        xVar2.a(writeImagesInfo, true);
        if (z) {
            xVar3 = this.aBV.aBD;
            xVar3.FH();
            TbadkApplication.getInst().resetPbRecorder();
            aVar = this.aBV.aBM;
            aVar.Ft();
            aVar2 = this.aBV.aBM;
            aVar2.c((WriteData) null);
            aVar3 = this.aBV.aBM;
            aVar3.eF(false);
            this.aBV.a(antiData, str);
            friendFeedThreadData = this.aBV.aBL;
            al.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.aBV.aBL;
            friendFeedThreadData3 = this.aBV.aBL;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            xVar4 = this.aBV.aBD;
            xVar4.FK();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rQ().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aBV.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aBV.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aBV.a(antiData, str);
        } else {
            this.aBV.a(antiData, str);
        }
    }
}
