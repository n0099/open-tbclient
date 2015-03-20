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
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.d
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.k kVar, WriteData writeData, AntiData antiData) {
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
        this.aHM.stopVoice();
        yVar = this.aHM.aHt;
        yVar.bK(z);
        yVar2 = this.aHM.aHt;
        writeImagesInfo = this.aHM.aHD;
        yVar2.a(writeImagesInfo, true);
        if (z) {
            yVar3 = this.aHM.aHt;
            yVar3.Ja();
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
            aVar = this.aHM.aHC;
            aVar.IM();
            aVar2 = this.aHM.aHC;
            aVar2.c((WriteData) null);
            aVar3 = this.aHM.aHC;
            aVar3.eS(false);
            this.aHM.a(antiData, str);
            friendFeedThreadData = this.aHM.aHB;
            ao.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.aHM.aHB;
            friendFeedThreadData3 = this.aHM.aHB;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            yVar4 = this.aHM.aHt;
            yVar4.Jd();
        } else if (kVar != null && writeData != null && kVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(kVar.getVcode_md5());
                writeData.setVcodeUrl(kVar.getVcode_pic_url());
                if (kVar.uI().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.aHM.getPageContext().getPageActivity(), 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.aHM.getPageContext().getPageActivity(), writeData, 12006)));
                    return;
                }
            }
            this.aHM.a(antiData, str);
        } else {
            this.aHM.a(antiData, str);
        }
    }
}
