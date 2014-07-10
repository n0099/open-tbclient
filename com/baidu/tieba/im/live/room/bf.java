package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupInfoByGid;
/* loaded from: classes.dex */
class bf extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(LiveRoomSettingActivity liveRoomSettingActivity, int i) {
        super(i);
        this.a = liveRoomSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bj bjVar;
        bi biVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bi biVar2;
        bj bjVar5;
        String str;
        String str2;
        bi biVar3;
        String str3;
        bi biVar4;
        bj bjVar6;
        String str4;
        bjVar = this.a.e;
        bjVar.m();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107008) {
            biVar = this.a.f;
            if (biVar.e() == socketResponsedMessage.getOrginalMessage() && (socketResponsedMessage instanceof ResponseLiveGroupInfoByGid)) {
                ResponseLiveGroupInfoByGid responseLiveGroupInfoByGid = (ResponseLiveGroupInfoByGid) socketResponsedMessage;
                if (responseLiveGroupInfoByGid.getError() == 0) {
                    bjVar2 = this.a.e;
                    bjVar2.b(responseLiveGroupInfoByGid.getName());
                    bjVar3 = this.a.e;
                    bjVar3.c(responseLiveGroupInfoByGid.getIntro());
                    bjVar4 = this.a.e;
                    bjVar4.a(responseLiveGroupInfoByGid.getPortrait());
                    biVar2 = this.a.f;
                    biVar2.a(responseLiveGroupInfoByGid.getPortraitId());
                    bjVar5 = this.a.e;
                    bjVar5.b(responseLiveGroupInfoByGid.getBlackListCount());
                    str = this.a.h;
                    if (!TextUtils.isEmpty(str)) {
                        str2 = this.a.g;
                        if (!TextUtils.isEmpty(str2)) {
                            biVar3 = this.a.f;
                            str3 = this.a.h;
                            biVar3.a(str3);
                            biVar4 = this.a.f;
                            biVar4.a(true);
                            bjVar6 = this.a.e;
                            str4 = this.a.g;
                            bjVar6.a(str4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.a(responseLiveGroupInfoByGid.getError(), responseLiveGroupInfoByGid.getErrorString());
            }
        }
    }
}
