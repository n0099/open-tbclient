package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.im.message.ResponseIncrLiveGroupLikeMessage;
import com.baidu.tieba.im.model.LiveMsglistModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class ae extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LiveRoomChatView z;
        ArrayList arrayList;
        MetaData metaData;
        LiveRoomChatView z2;
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107108 && (socketResponsedMessage instanceof ResponseIncrLiveGroupLikeMessage)) {
            ResponseIncrLiveGroupLikeMessage responseIncrLiveGroupLikeMessage = (ResponseIncrLiveGroupLikeMessage) socketResponsedMessage;
            if (responseIncrLiveGroupLikeMessage.hasError()) {
                if (!TextUtils.isEmpty(responseIncrLiveGroupLikeMessage.getErrorString())) {
                    this.a.showToast(responseIncrLiveGroupLikeMessage.getErrorString());
                }
                this.a.x().g = responseIncrLiveGroupLikeMessage.mType != 1 ? 1 : 2;
                z2 = this.a.z();
                z2.a(this.a.x().d, this.a.x().i, this.a.x().g);
                return;
            }
            this.a.x().g = responseIncrLiveGroupLikeMessage.mType == 1 ? 1 : 2;
            if (this.a.x().c != null) {
                List<MetaData> list = this.a.x().d;
                String currentAccount = TbadkApplication.getCurrentAccount();
                if (list != null) {
                    Iterator<MetaData> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            metaData = null;
                            arrayList = list;
                            break;
                        }
                        metaData = it.next();
                        if (metaData.getUserId() != null && metaData.getUserId().equals(currentAccount)) {
                            arrayList = list;
                            break;
                        }
                    }
                } else {
                    arrayList = new ArrayList();
                    metaData = null;
                }
                if (this.a.x().g == 1) {
                    if (metaData == null) {
                        if (arrayList.size() >= 6) {
                            arrayList.remove(arrayList.size() - 1);
                        }
                        MetaData metaData2 = new MetaData();
                        metaData2.setName_show(this.a.x().c.userName);
                        metaData2.setPortrait(this.a.x().c.portrait);
                        metaData2.setUserId(currentAccount);
                        arrayList.add(0, metaData2);
                    }
                    this.a.x().i++;
                } else {
                    if (metaData != null) {
                        arrayList.remove(metaData);
                    }
                    if (this.a.x().i > 0) {
                        LiveMsglistModel x = this.a.x();
                        x.i--;
                    }
                }
                this.a.x().d = arrayList;
            }
            z = this.a.z();
            z.a(this.a.x().d, this.a.x().i, this.a.x().g);
        }
    }
}
