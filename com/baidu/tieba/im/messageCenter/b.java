package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.im.message.ResponseAddLiveGroupMessage;
import com.baidu.tbadk.im.message.ResponseLiveGroupInfoByGid;
import com.baidu.tbadk.im.message.ResponseUpdateLiveGroupMessage;
import com.baidu.tbadk.live.ResponseGetAccessTokenMessage;
import com.baidu.tbadk.live.message.ResponseDismissGroupMessage;
import com.baidu.tbadk.live.message.ResponseFrsLiveListMessage;
import com.baidu.tbadk.live.message.ResponseHotLiveListMessage;
import com.baidu.tbadk.live.message.ResponseLiveBlackMembersMessage;
import com.baidu.tbadk.live.message.ResponseLiveGroupHistoryMessage;
import com.baidu.tbadk.live.message.ResponseLiveGroupLikeListMessage;
import com.baidu.tbadk.live.message.ResponseLiveGroupOwnerGagMessage;
import com.baidu.tbadk.live.message.ResponseLiveRoomIntroMessage;
import com.baidu.tbadk.live.message.ResponseMyLiveListMessage;
import com.baidu.tbadk.live.message.ResponseOperateFrsLiveListMessage;
import com.baidu.tbadk.live.message.ResponseSubscribeLiveGroupMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponsePassFriendMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.im.d.a.l;
import com.baidu.tieba.im.d.a.m;
import com.baidu.tieba.im.d.a.n;
import com.baidu.tieba.im.d.a.o;
import com.baidu.tieba.im.d.a.p;
import com.baidu.tieba.im.d.a.q;
import com.baidu.tieba.im.d.a.r;
import com.baidu.tieba.im.d.a.s;
import com.baidu.tieba.im.d.a.t;
import com.baidu.tieba.im.d.a.u;
import com.baidu.tieba.im.d.a.v;
import com.baidu.tieba.im.d.a.w;
import com.baidu.tieba.im.d.a.x;
import com.baidu.tieba.im.groupInfo.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseJoinGroupMessage;
import com.baidu.tieba.im.memorycache.by;
import com.baidu.tieba.im.memorycache.ca;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitInviteMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseIncrLiveGroupLikeMessage;
import com.baidu.tieba.im.message.ResponseJoinLiveGroupMessage;
import com.baidu.tieba.im.message.ResponseMaskMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
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
import com.baidu.tieba.im.message.ResponseUpdateChatroomTopicMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUploadClientLogMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.SendForeNoticeResponseMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
/* loaded from: classes.dex */
public class b {
    public static boolean Qj() {
        Qk();
        Ql();
        Qm();
        return Qn();
    }

    public static boolean Qk() {
        c(103005, ResponseMembersMessage.class, false);
        c(103011, ResponseQueryGroupCountMessage.class, false);
        c(103004, ResponseGroupInfoMessage.class, false);
        c(103003, ResponseGroupsByUidMessage.class, false);
        c(103003, ResponseGroupsByUidMessage.class, false);
        c(202006, PushNotifyMessageDecoder.class, false);
        c(103110, ResponseJoinGroupMessage.class, false);
        c(202005, ResponseUploadClientLogMessage.class, false);
        c(103111, ResponseAddGroupUserMessage.class, false);
        c(202001, ResponseCommitGroupMessage.class, false);
        c(205001, ResponseCommitPersonalMessage.class, false);
        c(103006, ResponseGroupLevelMessage.class, false);
        c(103010, ResponseRequestGroupLocMessage.class, false);
        c(103112, ResponseRemoveMembersMessage.class, false);
        c(202101, ResponsePushCountMessage.class, false);
        c(103101, ResponseAddGroupMessage.class, false);
        c(103103, ResponseReportGroupMessage.class, false);
        c(103009, ResponseNearbyGroupsMessage.class, false);
        c(202004, ResponseDelSystemMessage.class, false);
        c(103104, ResponseDismissGroupMessage.class, false);
        c(205003, ResponseQueryUserInfoMessage.class, false);
        c(205002, ResponseCommitInviteMessage.class, false);
        c(104103, ResponseMaskMessage.class, false);
        c(104102, ResponseUpdateMaskInfoMessage.class, false);
        c(104103, ResponseGetMaskInfoMessage.class, false);
        c(104104, ResponseCheckUserMaskMessage.class, false);
        c(106101, ResponseEnterChatRoomMessage.class, false);
        c(106102, ResponseQuitChatRoomMessage.class, false);
        c(106001, ResponseChatRoomInfoMessage.class, false);
        c(106103, ResponseUpdateChatroomTopicMessage.class, false);
        c(103105, ResponseUpgradeMemberGroupMessage.class, false);
        c(103120, ResponseCreateGroupActivityMessage.class, false);
        c(103015, ResponseGetGroupActivityMessage.class, false);
        c(103121, ResponseDelGroupActivityMessage.class, false);
        c(208001, ResponseOfficialBarInfoMessage.class, false);
        c(208002, ResponseHistoryMessage.class, false);
        c(104001, ResponseSendPVTJMessage.class, false);
        c(107001, ResponseFrsLiveListMessage.class, false);
        c(107003, ResponseHotLiveListMessage.class, false);
        c(107107, SendForeNoticeResponseMessage.class, false);
        c(107109, ResponseLiveGroupOwnerGagMessage.class, false);
        c(107009, ResponseLiveBlackMembersMessage.class, false);
        c(107005, ResponseLiveGroupHistoryMessage.class, false);
        c(107110, ResponseOperateFrsLiveListMessage.class, false);
        c(202003, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c(103007, ResponseSearchGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c(103008, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c(103102, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        c(107101, ResponseAddLiveGroupMessage.class, false);
        c(107103, ResponseJoinLiveGroupMessage.class, false);
        c(107006, ResponseLiveGroupLikeListMessage.class, false);
        c(107201, ResponseGetAccessTokenMessage.class, false);
        c(107004, ResponseLiveRoomIntroMessage.class, false);
        c(107102, ResponseUpdateLiveGroupMessage.class, false);
        c(107105, ResponseSubscribeLiveGroupMessage.class, false);
        c(107002, ResponseMyLiveListMessage.class, false);
        c(107108, ResponseIncrLiveGroupLikeMessage.class, false);
        c(107008, ResponseLiveGroupInfoByGid.class, false);
        c(304100, ResponseAddFriendMessage.class, false);
        c(304102, ResponseDeleteFriendMessage.class, false);
        c(304101, ResponsePassFriendMessage.class, false);
        c(304103, ResponseApplyMessage.class, false);
        c(303006, ResponseOfficialBarMenuMessage.class, false);
        c(208003, ResponseSendOfficialBarMenuMessage.class, false);
        c(205101, ResponsePersonalLbsInfoMessage.class, false);
        c(205006, ResponsedPersonalMsgReadMessage.class, false);
        return true;
    }

    private static com.baidu.tbadk.task.b c(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.setResponsedClass(cls);
        bVar.f(z);
        bVar.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    private static boolean Ql() {
        b(2001102, com.baidu.tieba.im.d.a.h.class);
        b(2001106, t.class);
        b(2001211, w.class);
        b(2001212, v.class);
        b(2001213, x.class);
        b(2001146, com.baidu.tieba.im.d.a.e.class);
        b(2001147, p.class);
        b(2001148, com.baidu.tieba.im.d.a.j.class);
        b(2001149, com.baidu.tieba.im.d.a.g.class);
        b(2001150, r.class);
        b(2001151, o.class);
        b(2001127, com.baidu.tieba.im.d.a.d.class);
        b(2001114, u.class);
        b(2001115, s.class);
        b(2001152, com.baidu.tieba.im.d.a.f.class);
        b(2001153, q.class);
        b(2001154, com.baidu.tieba.im.d.a.k.class);
        b(2001155, l.class);
        b(2001156, m.class);
        b(2001214, com.baidu.tieba.im.d.a.i.class);
        b(2001165, com.baidu.tbadk.live.a.a.class);
        b(2001181, n.class);
        return true;
    }

    private static com.baidu.tbadk.task.a b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
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

    private static boolean Qm() {
        MessageManager.getInstance().addResponsedMessageRule(new c(202006));
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.c.k());
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.im.c.j());
        return true;
    }

    private static boolean Qn() {
        MessageManager.getInstance().addResponsedMessageRule(new by());
        MessageManager.getInstance().addResponsedMessageRule(new ca());
        return true;
    }
}
