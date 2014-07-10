package com.baidu.tieba.friendfeed;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.at;
import com.baidu.tbadk.core.atomData.bu;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.pb.main.bq;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
class a implements ar {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
    }

    @Override // com.baidu.tieba.model.ar
    public void a(boolean z, String str, com.baidu.tbadk.coreExtra.data.f fVar, WriteData writeData, AntiData antiData) {
        t tVar;
        t tVar2;
        WriteImagesInfo writeImagesInfo;
        t tVar3;
        aq aqVar;
        aq aqVar2;
        aq aqVar3;
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
            bq.a().f();
            aqVar = this.a.j;
            aqVar.a();
            aqVar2 = this.a.j;
            aqVar2.a((WriteData) null);
            aqVar3 = this.a.j;
            aqVar3.a(false);
            this.a.a(antiData, str);
            friendFeedThreadData = this.a.i;
            com.baidu.tieba.util.m.b(friendFeedThreadData.getTid(), (WriteData) null);
            friendFeedThreadData2 = this.a.i;
            friendFeedThreadData3 = this.a.i;
            friendFeedThreadData2.setReply_num(friendFeedThreadData3.getReply_num() + 1);
            tVar4 = this.a.c;
            tVar4.f();
        } else if (fVar != null && writeData != null && fVar.b() != null) {
            if (!AntiHelper.c(antiData)) {
                writeData.setVcodeMD5(fVar.a());
                writeData.setVcodeUrl(fVar.b());
                if (fVar.c().equals("4")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new at(this.a, 12006, writeData, false)));
                    return;
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new bu(this.a, writeData, 12006)));
                    return;
                }
            }
            this.a.a(antiData, str);
        } else {
            this.a.a(antiData, str);
        }
    }
}
