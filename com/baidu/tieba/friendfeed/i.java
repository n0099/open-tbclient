package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.as;
import com.baidu.tieba.pb.main.bs;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class i implements as {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        y yVar;
        y yVar2;
        WriteImagesInfo writeImagesInfo;
        y yVar3;
        ar arVar;
        ar arVar2;
        ar arVar3;
        FriendFeedThreadData friendFeedThreadData;
        FriendFeedThreadData friendFeedThreadData2;
        FriendFeedThreadData friendFeedThreadData3;
        y yVar4;
        this.ayL.EA();
        yVar = this.ayL.ayq;
        yVar.bQ(z);
        yVar2 = this.ayL.ayq;
        writeImagesInfo = this.ayL.ahS;
        yVar2.a(writeImagesInfo, true);
        if (z) {
            yVar3 = this.ayL.ayq;
            yVar3.EP();
            bs.WZ().reset();
            arVar = this.ayL.ayz;
            arVar.EC();
            arVar2 = this.ayL.ayz;
            arVar2.b((WriteData) null);
            arVar3 = this.ayL.ayz;
            arVar3.dI(false);
            this.ayL.a(antiData, str);
            friendFeedThreadData = this.ayL.ayy;
            com.baidu.tieba.util.l.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.ayL.ayy;
            friendFeedThreadData3 = this.ayL.ayy;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            yVar4 = this.ayL.ayq;
            yVar4.ES();
        } else if (fVar != null && writeData != null && fVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(fVar.getVcode_md5());
                writeData.setVcodeUrl(fVar.getVcode_pic_url());
                if (fVar.oA().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.ayL, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.ayL, writeData, 12006)));
                    return;
                }
            }
            this.ayL.a(antiData, str);
        } else {
            this.ayL.a(antiData, str);
        }
    }
}
