package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.e.a.p;
import com.baidu.tieba.im.e.a.q;
import com.baidu.tieba.im.e.a.r;
import com.baidu.tieba.im.e.a.s;
import com.baidu.tieba.im.e.a.t;
import com.baidu.tieba.im.e.a.u;
import com.baidu.tieba.im.e.a.v;
import com.baidu.tieba.im.e.a.w;
import com.baidu.tieba.im.e.a.x;
import com.baidu.tieba.im.e.a.y;
import com.baidu.tieba.im.groupInfo.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseJoinGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
import com.baidu.tieba.im.message.ResponseMaskMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponsePeerInfo;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponsePushCountMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponseSendPVTJMessage;
import com.baidu.tieba.im.message.ResponseUpdateChatroomTopicMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
/* loaded from: classes.dex */
public final class a {
    public static boolean a() {
        a(103002, ResponseFrsGroupsMessage.class, false);
        a(103005, ResponseMembersMessage.class, false);
        a(103011, ResponseQueryGroupCountMessage.class, false);
        a(103004, ResponseGroupInfoMessage.class, false);
        a(103003, ResponseGroupsByUidMessage.class, false);
        a(103003, ResponseGroupsByUidMessage.class, false);
        a(202006, PushNotifyMessageDecoder.class, false);
        a(103110, ResponseJoinGroupMessage.class, false);
        a(103111, ResponseAddGroupUserMessage.class, false);
        a(202001, ResponseCommitGroupMessage.class, false);
        a(205001, ResponseCommitPersonalMessage.class, false);
        a(103006, ResponseGroupLevelMessage.class, false);
        a(103010, ResponseRequestGroupLocMessage.class, false);
        a(103112, ResponseRemoveMembersMessage.class, false);
        a(202101, ResponsePushCountMessage.class, false);
        a(103012, ResponseHotGroupsMessage.class, false);
        a(103101, ResponseAddGroupMessage.class, false);
        a(103103, ResponseReportGroupMessage.class, false);
        a(103009, ResponseNearbyGroupsMessage.class, false);
        a(202004, ResponseDelSystemMessage.class, false);
        a(103104, ResponseDismissGroupMessage.class, false);
        a(205003, ResponseQueryUserInfoMessage.class, false);
        a(205002, ResponseCommitInviteMessage.class, false);
        a(104103, ResponseMaskMessage.class, false);
        a(205004, ResponsePeerInfo.class, false);
        a(104102, ResponseUpdateMaskInfoMessage.class, false);
        a(104103, ResponseGetMaskInfoMessage.class, false);
        a(104104, ResponseCheckUserMaskMessage.class, false);
        a(106101, ResponseEnterChatRoomMessage.class, false);
        a(106102, ResponseQuitChatRoomMessage.class, false);
        a(106001, ResponseChatRoomInfoMessage.class, false);
        a(106103, ResponseUpdateChatroomTopicMessage.class, false);
        a(103105, ResponseUpgradeMemberGroupMessage.class, false);
        a(103120, ResponseCreateGroupActivityMessage.class, false);
        a(103015, ResponseGetGroupActivityMessage.class, false);
        a(103121, ResponseDelGroupActivityMessage.class, false);
        a(208001, ResponseOfficialBarInfoMessage.class, false);
        a(208002, ResponseHistoryMessage.class, false);
        a(104001, ResponseSendPVTJMessage.class, false);
        a(202003, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(103007, ResponseSearchGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(103008, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(103102, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(2001102, com.baidu.tieba.im.e.a.i.class);
        a(2001106, u.class);
        a(2001202, x.class);
        a(2001203, w.class);
        a(2001204, y.class);
        a(2001116, com.baidu.tieba.im.e.a.k.class);
        a(2001146, com.baidu.tieba.im.e.a.f.class);
        a(2001147, q.class);
        a(2001148, com.baidu.tieba.im.e.a.l.class);
        a(2001149, com.baidu.tieba.im.e.a.h.class);
        a(2001150, s.class);
        a(2001151, p.class);
        a(2001127, com.baidu.tieba.im.e.a.e.class);
        a(2001201, com.baidu.tieba.im.e.a.j.class);
        a(2001114, v.class);
        a(2001115, t.class);
        a(2001110, com.baidu.tieba.im.e.a.d.class);
        a(2001152, com.baidu.tieba.im.e.a.g.class);
        a(2001153, r.class);
        a(2001154, com.baidu.tieba.im.e.a.m.class);
        a(2001155, com.baidu.tieba.im.e.a.n.class);
        a(2001156, com.baidu.tieba.im.e.a.o.class);
        com.baidu.adp.framework.c.a().a(new b(202006));
        com.baidu.adp.framework.c.a().a(new com.baidu.tieba.im.c.l());
        com.baidu.adp.framework.c.a().a(new com.baidu.tieba.im.c.k());
        return true;
    }

    private static com.baidu.tbadk.c.c a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.c.c cVar = new com.baidu.tbadk.c.c(i);
        cVar.a(cls);
        cVar.b(false);
        com.baidu.adp.framework.c.a().a(cVar);
        return cVar;
    }

    private static com.baidu.tbadk.c.a a(int i, Class<? extends com.baidu.adp.framework.task.a<?>> cls) {
        try {
            com.baidu.tbadk.c.a aVar = new com.baidu.tbadk.c.a(i, cls.newInstance());
            com.baidu.adp.framework.c.a().a(aVar);
            return aVar;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
