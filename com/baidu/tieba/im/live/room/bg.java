package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupInfoByGid;
/* loaded from: classes.dex */
class bg extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(LiveRoomSettingActivity liveRoomSettingActivity, int i) {
        super(i);
        this.a = liveRoomSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bk bkVar;
        bj bjVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bj bjVar2;
        bk bkVar5;
        String str;
        String str2;
        bj bjVar3;
        String str3;
        bj bjVar4;
        bk bkVar6;
        String str4;
        bkVar = this.a.e;
        bkVar.m();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage.getCmd() == 107008) {
            bjVar = this.a.f;
            if (bjVar.e() == socketResponsedMessage.getOrginalMessage() && (socketResponsedMessage instanceof ResponseLiveGroupInfoByGid)) {
                ResponseLiveGroupInfoByGid responseLiveGroupInfoByGid = (ResponseLiveGroupInfoByGid) socketResponsedMessage;
                if (responseLiveGroupInfoByGid.getError() == 0) {
                    bkVar2 = this.a.e;
                    bkVar2.b(responseLiveGroupInfoByGid.getName());
                    bkVar3 = this.a.e;
                    bkVar3.c(responseLiveGroupInfoByGid.getIntro());
                    bkVar4 = this.a.e;
                    bkVar4.a(responseLiveGroupInfoByGid.getPortrait());
                    bjVar2 = this.a.f;
                    bjVar2.a(responseLiveGroupInfoByGid.getPortraitId());
                    bkVar5 = this.a.e;
                    bkVar5.b(responseLiveGroupInfoByGid.getBlackListCount());
                    str = this.a.h;
                    if (!TextUtils.isEmpty(str)) {
                        str2 = this.a.g;
                        if (!TextUtils.isEmpty(str2)) {
                            bjVar3 = this.a.f;
                            str3 = this.a.h;
                            bjVar3.a(str3);
                            bjVar4 = this.a.f;
                            bjVar4.a(true);
                            bkVar6 = this.a.e;
                            str4 = this.a.g;
                            bkVar6.a(str4);
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
