package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
import com.baidu.tieba.im.c.a.l;
import com.baidu.tieba.im.c.a.m;
import com.baidu.tieba.im.c.a.n;
import com.baidu.tieba.im.c.a.o;
import com.baidu.tieba.im.c.a.p;
import com.baidu.tieba.im.c.a.q;
import com.baidu.tieba.im.c.a.r;
import com.baidu.tieba.im.c.a.s;
import com.baidu.tieba.im.c.a.t;
import com.baidu.tieba.im.c.a.u;
import com.baidu.tieba.im.c.a.v;
import com.baidu.tieba.im.c.a.w;
import com.baidu.tieba.im.c.a.x;
import com.baidu.tieba.im.c.a.y;
import com.baidu.tieba.im.c.a.z;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.groupInfo.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseJoinGroupMessage;
import com.baidu.tieba.im.live.ResponseGetAccessTokenMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddLiveGroupMessage;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseFrsLiveListMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseHotLiveListMessage;
import com.baidu.tieba.im.message.ResponseIncrLiveGroupLikeMessage;
import com.baidu.tieba.im.message.ResponseJoinLiveGroupMessage;
import com.baidu.tieba.im.message.ResponseLiveBlackMembersMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupHistoryMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupInfoByGid;
import com.baidu.tieba.im.message.ResponseLiveGroupLikeListMessage;
import com.baidu.tieba.im.message.ResponseLiveGroupOwnerGagMessage;
import com.baidu.tieba.im.message.ResponseLiveRoomIntroMessage;
import com.baidu.tieba.im.message.ResponseMaskMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseMyLiveListMessage;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseOperateFrsLiveListMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponsePushCountMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendPVTJMessage;
import com.baidu.tieba.im.message.ResponseSubscribeLiveGroupMessage;
import com.baidu.tieba.im.message.ResponseUpdateChatroomTopicMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpdateLiveGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.message.SendForeNoticeResponseMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
/* loaded from: classes.dex */
public class b {
    public static boolean a() {
        b();
        c();
        return d();
    }

    public static boolean b() {
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
        a(103101, ResponseAddGroupMessage.class, false);
        a(103103, ResponseReportGroupMessage.class, false);
        a(103009, ResponseNearbyGroupsMessage.class, false);
        a(202004, ResponseDelSystemMessage.class, false);
        a(103104, ResponseDismissGroupMessage.class, false);
        a(205003, ResponseQueryUserInfoMessage.class, false);
        a(205002, ResponseCommitInviteMessage.class, false);
        a(104103, ResponseMaskMessage.class, false);
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
        a(107001, ResponseFrsLiveListMessage.class, false);
        a(107003, ResponseHotLiveListMessage.class, false);
        a(107107, SendForeNoticeResponseMessage.class, false);
        a(107109, ResponseLiveGroupOwnerGagMessage.class, false);
        a(107009, ResponseLiveBlackMembersMessage.class, false);
        a(107005, ResponseLiveGroupHistoryMessage.class, false);
        a(107110, ResponseOperateFrsLiveListMessage.class, false);
        a(202003, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(103007, ResponseSearchGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(103008, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(103102, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(107101, ResponseAddLiveGroupMessage.class, false);
        a(107103, ResponseJoinLiveGroupMessage.class, false);
        a(107006, ResponseLiveGroupLikeListMessage.class, false);
        a(107201, ResponseGetAccessTokenMessage.class, false);
        a(107004, ResponseLiveRoomIntroMessage.class, false);
        a(107102, ResponseUpdateLiveGroupMessage.class, false);
        a(107105, ResponseSubscribeLiveGroupMessage.class, false);
        a(107002, ResponseMyLiveListMessage.class, false);
        a(107108, ResponseIncrLiveGroupLikeMessage.class, false);
        a(107008, ResponseLiveGroupInfoByGid.class, false);
        a(304100, ResponseAddFriendMessage.class, false);
        a(304102, ResponseDeleteFriendMessage.class, false);
        a(304101, ResponsePassFriendMessage.class, false);
        a(304103, ResponseApplyMessage.class, false);
        a(303006, ResponseOfficialBarMenuMessage.class, false);
        a(208003, ResponseSendOfficialBarMenuMessage.class, false);
        return true;
    }

    private static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        bVar.setParallel(com.baidu.tbadk.k.b());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    private static boolean c() {
        a(2001102, com.baidu.tieba.im.c.a.h.class);
        a(2001106, v.class);
        a(2001211, y.class);
        a(2001212, x.class);
        a(2001213, z.class);
        a(2001146, com.baidu.tieba.im.c.a.e.class);
        a(2001147, r.class);
        a(2001148, l.class);
        a(2001149, com.baidu.tieba.im.c.a.g.class);
        a(2001150, t.class);
        a(2001151, q.class);
        a(2001127, com.baidu.tieba.im.c.a.d.class);
        a(2001210, com.baidu.tieba.im.c.a.i.class);
        a(2001114, w.class);
        a(2001115, u.class);
        a(2001152, com.baidu.tieba.im.c.a.f.class);
        a(2001153, s.class);
        a(2001154, m.class);
        a(2001155, n.class);
        a(2001156, o.class);
        a(2001214, com.baidu.tieba.im.c.a.j.class);
        a(2001165, com.baidu.tieba.im.c.a.k.class);
        a(2001181, p.class);
        return true;
    }

    private static com.baidu.tbadk.task.a a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        try {
            com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(i, cls.newInstance());
            MessageManager.getInstance().registerTask(aVar);
            return aVar;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean d() {
        MessageManager.getInstance().addResponsedMessageRule(new c(202006));
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.b.k());
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.im.b.j());
        return true;
    }
}
