package com.baidu.tieba.im.live.room;

import android.content.Intent;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpdateLiveGroupMessage;
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
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L22;
     */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bj bjVar;
        bi biVar;
        bj bjVar2;
        bj bjVar3;
        String str;
        String str2;
        String str3;
        bjVar = this.a.e;
        bjVar.m();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107102) {
            biVar = this.a.f;
            if (biVar.f() == socketResponsedMessage.getOrginalMessage() && (socketResponsedMessage instanceof ResponseUpdateLiveGroupMessage)) {
                ResponseUpdateLiveGroupMessage responseUpdateLiveGroupMessage = (ResponseUpdateLiveGroupMessage) socketResponsedMessage;
                if (responseUpdateLiveGroupMessage.getError() == 0) {
                    this.a.showToast(com.baidu.tieba.y.group_update_success, false);
                    Intent intent = new Intent();
                    bjVar2 = this.a.e;
                    intent.putExtra("name", bjVar2.e());
                    bjVar3 = this.a.e;
                    intent.putExtra("intro", bjVar3.f());
                    str = this.a.g;
                    if (str == null) {
                        str3 = this.a.g;
                    }
                    str2 = this.a.g;
                    intent.putExtra("portraitId", str2);
                    this.a.setResult(10, intent);
                    this.a.finish();
                    return;
                }
                this.a.a(responseUpdateLiveGroupMessage.getError(), responseUpdateLiveGroupMessage.getErrorString());
            }
        }
    }
}
