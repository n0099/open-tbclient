package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupInfoByGid;
/* loaded from: classes.dex */
class be extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(LiveRoomSettingActivity liveRoomSettingActivity, int i) {
        super(i);
        this.a = liveRoomSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bi biVar;
        bh bhVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bh bhVar2;
        bi biVar5;
        String str;
        String str2;
        bh bhVar3;
        String str3;
        bh bhVar4;
        bi biVar6;
        String str4;
        biVar = this.a.e;
        biVar.m();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.u.neterror);
        } else if (socketResponsedMessage.getCmd() == 107008) {
            bhVar = this.a.f;
            if (bhVar.e() == socketResponsedMessage.getOrginalMessage() && (socketResponsedMessage instanceof ResponseLiveGroupInfoByGid)) {
                ResponseLiveGroupInfoByGid responseLiveGroupInfoByGid = (ResponseLiveGroupInfoByGid) socketResponsedMessage;
                if (responseLiveGroupInfoByGid.getError() == 0) {
                    biVar2 = this.a.e;
                    biVar2.b(responseLiveGroupInfoByGid.getName());
                    biVar3 = this.a.e;
                    biVar3.c(responseLiveGroupInfoByGid.getIntro());
                    biVar4 = this.a.e;
                    biVar4.a(responseLiveGroupInfoByGid.getPortrait());
                    bhVar2 = this.a.f;
                    bhVar2.a(responseLiveGroupInfoByGid.getPortraitId());
                    biVar5 = this.a.e;
                    biVar5.b(responseLiveGroupInfoByGid.getBlackListCount());
                    str = this.a.h;
                    if (!TextUtils.isEmpty(str)) {
                        str2 = this.a.g;
                        if (!TextUtils.isEmpty(str2)) {
                            bhVar3 = this.a.f;
                            str3 = this.a.h;
                            bhVar3.a(str3);
                            bhVar4 = this.a.f;
                            bhVar4.a(true);
                            biVar6 = this.a.e;
                            str4 = this.a.g;
                            biVar6.a(str4);
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
