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
class i implements com.baidu.tieba.tbadkCore.f.b {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.f.b
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.j jVar, WriteData writeData, AntiData antiData) {
        y yVar;
        y yVar2;
        WriteImagesInfo writeImagesInfo;
        y yVar3;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        FriendFeedThreadData friendFeedThreadData;
        FriendFeedThreadData friendFeedThreadData2;
        FriendFeedThreadData friendFeedThreadData3;
        y yVar4;
        this.aAU.stopVoice();
        yVar = this.aAU.aAB;
        yVar.bD(z);
        yVar2 = this.aAU.aAB;
        writeImagesInfo = this.aAU.apq;
        yVar2.a(writeImagesInfo, true);
        if (z) {
            yVar3 = this.aAU.aAB;
            yVar3.Fj();
            TbadkApplication.getInst().resetPbRecorder();
            aVar = this.aAU.aAK;
            aVar.EV();
            aVar2 = this.aAU.aAK;
            aVar2.c((WriteData) null);
            aVar3 = this.aAU.aAK;
            aVar3.ey(false);
            this.aAU.a(antiData, str);
            friendFeedThreadData = this.aAU.aAJ;
            al.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.aAU.aAJ;
            friendFeedThreadData3 = this.aAU.aAJ;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            yVar4 = this.aAU.aAB;
            yVar4.Fm();
        } else if (jVar != null && writeData != null && jVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(jVar.getVcode_md5());
                writeData.setVcodeUrl(jVar.getVcode_pic_url());
                if (jVar.rD().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aAU.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aAU.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aAU.a(antiData, str);
        } else {
            this.aAU.a(antiData, str);
        }
    }
}
