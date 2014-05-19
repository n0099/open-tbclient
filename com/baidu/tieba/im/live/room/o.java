package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.GroupData;
/* loaded from: classes.dex */
class o implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ LiveRoomChatActivity a;
    private final /* synthetic */ GroupData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LiveRoomChatActivity liveRoomChatActivity, GroupData groupData) {
        this.a = liveRoomChatActivity;
        this.b = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.chat.h hVar;
        com.baidu.tieba.im.chat.h hVar2;
        com.baidu.tieba.im.chat.h hVar3;
        if (bool != null) {
            if (bool.booleanValue()) {
                hVar3 = this.a.d;
                hVar3.L();
            } else {
                hVar = this.a.d;
                hVar.M();
            }
            if (this.a.x() != null && this.b != null) {
                String name = this.b.getName();
                if (!TextUtils.isEmpty(name)) {
                    hVar2 = this.a.d;
                    hVar2.a(name, true);
                }
            }
        }
    }
}
