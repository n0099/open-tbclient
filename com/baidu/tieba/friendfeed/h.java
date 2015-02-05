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
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
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
        this.aBS.stopVoice();
        xVar = this.aBS.aBA;
        xVar.bG(z);
        xVar2 = this.aBS.aBA;
        writeImagesInfo = this.aBS.aqi;
        xVar2.a(writeImagesInfo, true);
        if (z) {
            xVar3 = this.aBS.aBA;
            xVar3.FB();
            TbadkApplication.getInst().resetPbRecorder();
            aVar = this.aBS.aBJ;
            aVar.Fn();
            aVar2 = this.aBS.aBJ;
            aVar2.c((WriteData) null);
            aVar3 = this.aBS.aBJ;
            aVar3.eF(false);
            this.aBS.a(antiData, str);
            friendFeedThreadData = this.aBS.aBI;
            al.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.aBS.aBI;
            friendFeedThreadData3 = this.aBS.aBI;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            xVar4 = this.aBS.aBA;
            xVar4.FE();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rK().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aBS.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aBS.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aBS.a(antiData, str);
        } else {
            this.aBS.a(antiData, str);
        }
    }
}
