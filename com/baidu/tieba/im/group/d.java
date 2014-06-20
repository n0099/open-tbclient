package com.baidu.tieba.im.group;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.chat.bv;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        if (socketResponsedMessage.getCmd() == 103008) {
            if (socketResponsedMessage instanceof ResponseUserPermissionMessage) {
                try {
                    ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                    if (responseUserPermissionMessage.getError() > 0) {
                        this.a.b(responseUserPermissionMessage.getErrorString());
                    } else {
                        GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                        if (groupPermData != null) {
                            if (groupPermData.isCreatePersonal()) {
                                CreateGroupStepActivity.a(this.a.getActivity(), 2, 0, 1011, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                            } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                                this.a.b(groupPermData.getCreatePersonalTip());
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else if (socketResponsedMessage.getCmd() == 106101) {
            baseFragmentActivity = this.a.g;
            baseFragmentActivity.b();
            if (!(socketResponsedMessage instanceof ResponseEnterChatRoomMessage)) {
                this.a.a(y.neterror);
                return;
            }
            ResponseEnterChatRoomMessage responseEnterChatRoomMessage = (ResponseEnterChatRoomMessage) socketResponsedMessage;
            if (responseEnterChatRoomMessage.getError() != 0) {
                if (responseEnterChatRoomMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseEnterChatRoomMessage.getErrorString())) {
                        this.a.b(responseEnterChatRoomMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.a.a(y.neterror);
                return;
            }
            RandChatRoomData randChatRoomData = responseEnterChatRoomMessage.getRandChatRoomData();
            if (randChatRoomData != null && randChatRoomData.e() > 0) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(String.valueOf(randChatRoomData.d()));
                imMessageCenterPojo.setPulled_msgId(bv.b(randChatRoomData.k()));
                imMessageCenterPojo.setCustomGroupType(3);
                imMessageCenterPojo.setGroup_name("聊天室");
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setIs_hidden(1);
                com.baidu.tieba.im.e.i.a(imMessageCenterPojo);
                baseFragmentActivity2 = this.a.g;
                WaittingActivity.a(baseFragmentActivity2, randChatRoomData, 0);
            }
        }
    }
}
