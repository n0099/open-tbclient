package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.ResponseLiveGroupLikeListMessage;
import protobuf.QueryLiveGroupLikeList.LikeUserInfo;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveGroupLikeListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(LiveGroupLikeListActivity liveGroupLikeListActivity, int i) {
        super(i);
        this.a = liveGroupLikeListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        int i;
        f fVar;
        e eVar5;
        e eVar6;
        e eVar7;
        e eVar8;
        e eVar9;
        f fVar2;
        this.a.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107006 && (socketResponsedMessage instanceof ResponseLiveGroupLikeListMessage)) {
            eVar = this.a.c;
            eVar.g();
            ResponseLiveGroupLikeListMessage responseLiveGroupLikeListMessage = (ResponseLiveGroupLikeListMessage) socketResponsedMessage;
            if (responseLiveGroupLikeListMessage.hasError()) {
                eVar9 = this.a.c;
                if (eVar9.h()) {
                    fVar2 = this.a.b;
                    fVar2.a();
                } else if (!TextUtils.isEmpty(responseLiveGroupLikeListMessage.getErrorString())) {
                    this.a.showToast(responseLiveGroupLikeListMessage.getErrorString());
                }
            } else {
                eVar2 = this.a.c;
                if (eVar2.h()) {
                    eVar7 = this.a.c;
                    eVar7.b().clear();
                }
                if (responseLiveGroupLikeListMessage.getLiveList() != null && responseLiveGroupLikeListMessage.getLiveList().size() > 0) {
                    for (LikeUserInfo likeUserInfo : responseLiveGroupLikeListMessage.getLiveList()) {
                        eVar6 = this.a.c;
                        eVar6.b().add(likeUserInfo);
                    }
                }
                eVar3 = this.a.c;
                int size = eVar3.b().size();
                int likers = responseLiveGroupLikeListMessage.getLikers();
                int i2 = MessageTypes.CMD_UPDATE_CLIENT_INFO;
                eVar4 = this.a.c;
                int a = eVar4.a();
                i = LiveGroupLikeListActivity.a;
                if (a > i) {
                    i2 = MessageTypes.CMD_PING;
                }
                if (size >= likers) {
                    i2 = MessageTypes.CMD_GROUP_UPDATE;
                }
                fVar = this.a.b;
                eVar5 = this.a.c;
                fVar.a(likers, eVar5.b(), i2, likers - size);
            }
            eVar8 = this.a.c;
            eVar8.a(responseLiveGroupLikeListMessage.getHasMore());
        }
    }
}
