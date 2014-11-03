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
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.g gVar, WriteData writeData, AntiData antiData) {
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
        this.ayU.EC();
        yVar = this.ayU.ayz;
        yVar.bQ(z);
        yVar2 = this.ayU.ayz;
        writeImagesInfo = this.ayU.aib;
        yVar2.a(writeImagesInfo, true);
        if (z) {
            yVar3 = this.ayU.ayz;
            yVar3.ER();
            bs.Xc().reset();
            arVar = this.ayU.ayI;
            arVar.EE();
            arVar2 = this.ayU.ayI;
            arVar2.b((WriteData) null);
            arVar3 = this.ayU.ayI;
            arVar3.dI(false);
            this.ayU.a(antiData, str);
            friendFeedThreadData = this.ayU.ayH;
            com.baidu.tieba.util.l.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.ayU.ayH;
            friendFeedThreadData3 = this.ayU.ayH;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            yVar4 = this.ayU.ayz;
            yVar4.EU();
        } else if (gVar != null && writeData != null && gVar.getVcode_pic_url() != null) {
            if (!AntiHelper.e(antiData)) {
                writeData.setVcodeMD5(gVar.getVcode_md5());
                writeData.setVcodeUrl(gVar.getVcode_pic_url());
                if (gVar.oC().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.ayU, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.ayU, writeData, 12006)));
                    return;
                }
            }
            this.ayU.a(antiData, str);
        } else {
            this.ayU.a(antiData, str);
        }
    }
}
