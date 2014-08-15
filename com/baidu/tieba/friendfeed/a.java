package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ay;
import com.baidu.tbadk.core.atomData.cd;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.model.as;
import com.baidu.tieba.pb.main.bp;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class a implements as {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
    }

    @Override // com.baidu.tieba.model.as
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.e eVar, WriteData writeData, AntiData antiData) {
        t tVar;
        t tVar2;
        WriteImagesInfo writeImagesInfo;
        t tVar3;
        ar arVar;
        ar arVar2;
        ar arVar3;
        FriendFeedThreadData friendFeedThreadData;
        FriendFeedThreadData friendFeedThreadData2;
        FriendFeedThreadData friendFeedThreadData3;
        t tVar4;
        this.a.g();
        tVar = this.a.c;
        tVar.b(z);
        tVar2 = this.a.c;
        writeImagesInfo = this.a.k;
        tVar2.a(writeImagesInfo, true);
        if (z) {
            tVar3 = this.a.c;
            tVar3.a();
            bp.a().f();
            arVar = this.a.j;
            arVar.a();
            arVar2 = this.a.j;
            arVar2.a((WriteData) null);
            arVar3 = this.a.j;
            arVar3.a(false);
            this.a.a(antiData, str);
            friendFeedThreadData = this.a.i;
            com.baidu.tieba.util.m.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.a.i;
            friendFeedThreadData3 = this.a.i;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            tVar4 = this.a.c;
            tVar4.f();
        } else if (eVar != null && writeData != null && eVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(eVar.a());
                writeData.setVcodeUrl(eVar.b());
                if (eVar.c().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ay(this.a, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new cd(this.a, writeData, 12006)));
                    return;
                }
            }
            this.a.a(antiData, str);
        } else {
            this.a.a(antiData, str);
        }
    }
}
