package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
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
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        int i;
        e eVar;
        d dVar5;
        d dVar6;
        d dVar7;
        d dVar8;
        d dVar9;
        e eVar2;
        this.a.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107006 && (socketResponsedMessage instanceof ResponseLiveGroupLikeListMessage)) {
            dVar = this.a.c;
            dVar.g();
            ResponseLiveGroupLikeListMessage responseLiveGroupLikeListMessage = (ResponseLiveGroupLikeListMessage) socketResponsedMessage;
            if (responseLiveGroupLikeListMessage.hasError()) {
                dVar9 = this.a.c;
                if (dVar9.h()) {
                    eVar2 = this.a.b;
                    eVar2.a();
                } else if (!TextUtils.isEmpty(responseLiveGroupLikeListMessage.getErrorString())) {
                    this.a.showToast(responseLiveGroupLikeListMessage.getErrorString());
                }
            } else {
                dVar2 = this.a.c;
                if (dVar2.h()) {
                    dVar7 = this.a.c;
                    dVar7.b().clear();
                }
                if (responseLiveGroupLikeListMessage.getLiveList() != null && responseLiveGroupLikeListMessage.getLiveList().size() > 0) {
                    for (LikeUserInfo likeUserInfo : responseLiveGroupLikeListMessage.getLiveList()) {
                        dVar6 = this.a.c;
                        dVar6.b().add(likeUserInfo);
                    }
                }
                dVar3 = this.a.c;
                int size = dVar3.b().size();
                int likers = responseLiveGroupLikeListMessage.getLikers();
                int i2 = 1001;
                dVar4 = this.a.c;
                int a = dVar4.a();
                i = LiveGroupLikeListActivity.a;
                if (a > i) {
                    i2 = 1003;
                }
                if (size >= likers) {
                    i2 = 1002;
                }
                eVar = this.a.b;
                dVar5 = this.a.c;
                eVar.a(likers, dVar5.b(), i2, likers - size);
            }
            dVar8 = this.a.c;
            dVar8.a(responseLiveGroupLikeListMessage.getHasMore());
        }
    }
}
