package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.e.a.aa;
import com.baidu.tieba.im.e.a.r;
import com.baidu.tieba.im.e.a.s;
import com.baidu.tieba.im.e.a.t;
import com.baidu.tieba.im.e.a.u;
import com.baidu.tieba.im.e.a.v;
import com.baidu.tieba.im.e.a.w;
import com.baidu.tieba.im.e.a.x;
import com.baidu.tieba.im.e.a.y;
import com.baidu.tieba.im.e.a.z;
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
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
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
import com.baidu.tieba.im.message.ResponseOperateFrsLiveListMessage;
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
        a(MessageTypes.CMD_REQUEST_GROUPS_BYFID, ResponseFrsGroupsMessage.class, false);
        a(MessageTypes.CMD_REQUEST_MEMBERS_BY_ID, ResponseMembersMessage.class, false);
        a(MessageTypes.CMD_QUERY_GROUP_COUNT, ResponseQueryGroupCountMessage.class, false);
        a(MessageTypes.CMD_REQUEST_GROUP_INFO_BY_ID, ResponseGroupInfoMessage.class, false);
        a(MessageTypes.CMD_QUERY_GROUP_BY_UID, ResponseGroupsByUidMessage.class, false);
        a(MessageTypes.CMD_QUERY_GROUP_BY_UID, ResponseGroupsByUidMessage.class, false);
        a(MessageTypes.CMD_PUSH_NOTIFY, PushNotifyMessageDecoder.class, false);
        a(MessageTypes.CMD_JOIN_GROUP, ResponseJoinGroupMessage.class, false);
        a(MessageTypes.CMD_ADD_GROUP_USER, ResponseAddGroupUserMessage.class, false);
        a(MessageTypes.CMD_GROUP_CHAT_MSG, ResponseCommitGroupMessage.class, false);
        a(MessageTypes.CMD_COMMIT_PERSONAL_MSG, ResponseCommitPersonalMessage.class, false);
        a(MessageTypes.CMD_REQUEST_GROUPLEVEL_BY_ID, ResponseGroupLevelMessage.class, false);
        a(MessageTypes.CMD_QUERY_GROUPLOC, ResponseRequestGroupLocMessage.class, false);
        a(MessageTypes.CMD_REMOVE_MEMBERS, ResponseRemoveMembersMessage.class, false);
        a(MessageTypes.CMD_PUSH_COUNT, ResponsePushCountMessage.class, false);
        a(MessageTypes.CMD_HOT_GROUPS, ResponseHotGroupsMessage.class, false);
        a(MessageTypes.CMD_ADD_GROUP, ResponseAddGroupMessage.class, false);
        a(MessageTypes.CMD_REPORT_GROUP, ResponseReportGroupMessage.class, false);
        a(MessageTypes.CMD_NEARBY_GROUP, ResponseNearbyGroupsMessage.class, false);
        a(MessageTypes.CMD_DELETE_GROUP_MSG, ResponseDelSystemMessage.class, false);
        a(MessageTypes.CMD_DISSMISS_GROUP, ResponseDismissGroupMessage.class, false);
        a(MessageTypes.CMD_QUERY_USER_INFO, ResponseQueryUserInfoMessage.class, false);
        a(MessageTypes.CMD_COMMIT_INVITE, ResponseCommitInviteMessage.class, false);
        a(MessageTypes.CMD_GET_MASK_INFO, ResponseMaskMessage.class, false);
        a(MessageTypes.CMD_GET_PEER_INFO, ResponsePeerInfo.class, false);
        a(MessageTypes.CMD_UPDATE_MASK_INFO, ResponseUpdateMaskInfoMessage.class, false);
        a(MessageTypes.CMD_GET_MASK_INFO, ResponseGetMaskInfoMessage.class, false);
        a(MessageTypes.CMD_CHECK_USER_MASK, ResponseCheckUserMaskMessage.class, false);
        a(MessageTypes.CMD_REQUEST_ENTER_CHAT_ROOM, ResponseEnterChatRoomMessage.class, false);
        a(MessageTypes.CMD_QUIT_CHAT_ROOM, ResponseQuitChatRoomMessage.class, false);
        a(MessageTypes.CMD_QUERY_CHAT_ROOM_INFO, ResponseChatRoomInfoMessage.class, false);
        a(MessageTypes.CMD_UPDATE_CHATROOM_TOPIC, ResponseUpdateChatroomTopicMessage.class, false);
        a(MessageTypes.CMD_UPGRADE_MEMBER_GROUP, ResponseUpgradeMemberGroupMessage.class, false);
        a(MessageTypes.CMD_CREATE_GROUP_ACTIVITY, ResponseCreateGroupActivityMessage.class, false);
        a(MessageTypes.CMD_GET_GROUP_ACTIVITY, ResponseGetGroupActivityMessage.class, false);
        a(MessageTypes.CMD_DEL_GROUP_ACTIVITY, ResponseDelGroupActivityMessage.class, false);
        a(MessageTypes.CMD_QUERY_OFFICIAL_BAR_INFO, ResponseOfficialBarInfoMessage.class, false);
        a(MessageTypes.CMD_QUERY_OFFICIAL_BAR_HISTORY, ResponseHistoryMessage.class, false);
        a(MessageTypes.CMD_SEND_PV_TJ, ResponseSendPVTJMessage.class, false);
        a(MessageTypes.CMD_REQUEST_LIVE_LIST_BY_FID, ResponseFrsLiveListMessage.class, false);
        a(MessageTypes.CMD_REQUEST_LIVE_LIST_ALL, ResponseHotLiveListMessage.class, false);
        a(MessageTypes.CMD_SEND_FORE_NOTICE, SendForeNoticeResponseMessage.class, false);
        a(MessageTypes.CMD_LIVE_GROUP_OWNER_GAG, ResponseLiveGroupOwnerGagMessage.class, false);
        a(MessageTypes.CMD_LIVE_BLACK_MEMBERS_LIST, ResponseLiveBlackMembersMessage.class, false);
        a(MessageTypes.CMD_LIVE_GROUP_HISTORY, ResponseLiveGroupHistoryMessage.class, false);
        a(MessageTypes.CMD_LIVE_OPERATE_FRSLIVE_LIST, ResponseOperateFrsLiveListMessage.class, false);
        a(MessageTypes.CMD_MESSAGE_SYNC, ResponsePullMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(MessageTypes.CMD_REQUEST_SEARCH_GROUP, ResponseSearchGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(MessageTypes.CMD_GET_USER_PERMISSION, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(MessageTypes.CMD_UPDATE_GROUP, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        a(MessageTypes.CMD_ADD_LIVE_GROUP, ResponseAddLiveGroupMessage.class, false);
        a(MessageTypes.CMD_JOIN_LIVE_GROUP, ResponseJoinLiveGroupMessage.class, false);
        a(MessageTypes.CMD_LIVE_LIKE_LIST, ResponseLiveGroupLikeListMessage.class, false);
        a(MessageTypes.CMD_GET_ACCESS_TOKEN, ResponseGetAccessTokenMessage.class, false);
        a(MessageTypes.CMD_QUERY_LIVE_ROOM_INTRO, ResponseLiveRoomIntroMessage.class, false);
        a(MessageTypes.CMD_UPDATE_LIVE_GROUP, ResponseUpdateLiveGroupMessage.class, false);
        a(MessageTypes.CMD_SUBSCRIBE_LIVE_GROUP, ResponseSubscribeLiveGroupMessage.class, false);
        a(MessageTypes.CMD_QUERY_MYLIVE, ResponseMyLiveListMessage.class, false);
        a(MessageTypes.CMD_INCR_LIVE_GROUP_LIKE, ResponseIncrLiveGroupLikeMessage.class, false);
        a(MessageTypes.CMD_GET_LIVE_GROUP_INFO, ResponseLiveGroupInfoByGid.class, false);
        return true;
    }

    private static com.baidu.tbadk.task.b a(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(i);
        bVar.a(cls);
        bVar.b(z);
        MessageManager.getInstance().registerTask(bVar);
        return bVar;
    }

    private static boolean c() {
        a(MessageTypes.CMD_REQUEST_GROUP_INFO_BY_ID_LOCAL, com.baidu.tieba.im.e.a.i.class);
        a(MessageTypes.CMD_REQUEST_GROUP_BY_UID_LOCAL, w.class);
        a(MessageTypes.CMD_CACHE_REQUEST_SEARCH_GROUP, z.class);
        a(MessageTypes.CMD_CACHE_CLEAR_REQUEST_SEARCH_GROUP, y.class);
        a(MessageTypes.CMD_CACHE_ORDER_REQUEST_SEARCH_GROUP, aa.class);
        a(MessageTypes.CMD_HOT_GROUPS_LOCAL, com.baidu.tieba.im.e.a.k.class);
        a(MessageTypes.CMD_LOAD_DRAFT_GROUP, com.baidu.tieba.im.e.a.f.class);
        a(MessageTypes.CMD_LOAD_DRAFT_PERSONAL, s.class);
        a(MessageTypes.CMD_LOAD_DRAFT_OFFICIAL, com.baidu.tieba.im.e.a.n.class);
        a(MessageTypes.CMD_LOAD_HISTORY_GROUP, com.baidu.tieba.im.e.a.h.class);
        a(MessageTypes.CMD_LOAD_HISTORY_PERSONAL, u.class);
        a(MessageTypes.CMD_LOAD_HISTORY_OFFICICAL, r.class);
        a(MessageTypes.CMD_REQUEST_GROUP_ACTIVITY_BY_ID_LOCAL, com.baidu.tieba.im.e.a.e.class);
        a(MessageTypes.CMD_CACHE_GROUPS_BY_FID, com.baidu.tieba.im.e.a.j.class);
        a(MessageTypes.CMD_REQUEST_GROUP_COUNT_LOCAL, x.class);
        a(MessageTypes.CMD_REQUEST_GROUP_BY_LOCATION_LOCAL, v.class);
        a(MessageTypes.CMD_GROUP_MARK_READED, com.baidu.tieba.im.e.a.d.class);
        a(MessageTypes.CMD_SAVE_DRAFT_GROUP, com.baidu.tieba.im.e.a.g.class);
        a(MessageTypes.CMD_SAVE_DRAFT_PERSONAL, t.class);
        a(MessageTypes.CMD_SAVE_DRAFT_OFFICIAL, com.baidu.tieba.im.e.a.o.class);
        a(MessageTypes.CMD_DEL_OFFICIAL_DB, com.baidu.tieba.im.e.a.p.class);
        a(MessageTypes.CMD_QUERY_OFFICIAL_LOCAL_HISTORY, com.baidu.tieba.im.e.a.q.class);
        a(MessageTypes.CMD_CACHE_LIVE_HOT_LIST_ALL, com.baidu.tieba.im.e.a.l.class);
        a(MessageTypes.CMD_QUERY_MYLIVE_LOCAL, com.baidu.tieba.im.e.a.m.class);
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
        MessageManager.getInstance().addResponsedMessageRule(new c(MessageTypes.CMD_PUSH_NOTIFY));
        MessageManager.getInstance().addResponsedMessageRule(new com.baidu.tieba.im.c.l());
        MessageManager.getInstance().addMessageRule(new com.baidu.tieba.im.c.k());
        return true;
    }
}
