package com.baidu.tieba.friendFeed;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.ao;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.tbadkCore.writeModel.d {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.d
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        y yVar;
        y yVar2;
        WriteImagesInfo writeImagesInfo;
        y yVar3;
        com.baidu.tieba.tbadkCore.writeModel.a aVar;
        com.baidu.tieba.tbadkCore.writeModel.a aVar2;
        com.baidu.tieba.tbadkCore.writeModel.a aVar3;
        FriendFeedThreadData friendFeedThreadData;
        FriendFeedThreadData friendFeedThreadData2;
        FriendFeedThreadData friendFeedThreadData3;
        y yVar4;
        this.aHU.stopVoice();
        yVar = this.aHU.aHB;
        yVar.bK(z);
        yVar2 = this.aHU.aHB;
        writeImagesInfo = this.aHU.aHL;
        yVar2.a(writeImagesInfo, true);
        if (z) {
            yVar3 = this.aHU.aHB;
            yVar3.Jg();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            aVar = this.aHU.aHK;
            aVar.IS();
            aVar2 = this.aHU.aHK;
            aVar2.c((WriteData) null);
            aVar3 = this.aHU.aHK;
            aVar3.eQ(false);
            this.aHU.a(antiData, str);
            friendFeedThreadData = this.aHU.aHJ;
            ao.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.aHU.aHJ;
            friendFeedThreadData3 = this.aHU.aHJ;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            yVar4 = this.aHU.aHB;
            yVar4.Jj();
        } else if (lVar != null && writeData != null && lVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(lVar.getVcode_md5());
                writeData.setVcodeUrl(lVar.getVcode_pic_url());
                if (lVar.uL().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aHU.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aHU.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aHU.a(antiData, str);
        } else {
            this.aHU.a(antiData, str);
        }
    }
}
