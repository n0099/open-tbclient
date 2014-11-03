package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.coreExtra.live.LivePublisherSayMessage;
import com.baidu.tbadk.live.message.RequestLiveGroupOwnerGagMessage;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.ResponseJoinLiveGroupMessage;
import com.baidu.tieba.im.message.a;
import com.baidu.tieba.im.message.c;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.p;
import com.baidu.tieba.im.model.MsglistModel;
import java.util.ArrayList;
import java.util.List;
import protobuf.JoinLiveGroup.LikeUserInfo;
import protobuf.JoinLiveGroup.UserPermission;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public class LiveMsglistModel extends CommonGroupMsglistModel {
    public static final int MAX_LIKERS = 6;
    private final int MSG_COUNT_PER;
    public String authorId;
    public boolean mCanForenoticeThread;
    private CustomMessageListener mCustomMessageListener;
    public String mForumName;
    public LiveGroupInfo mGroupInfo;
    public String mGroupIntro;
    public String mGroupName;
    public boolean mIsBeMuted;
    public boolean mIsHost;
    public int mIsLike;
    public boolean mIsSubcribed;
    public List<MetaData> mLikeUserList;
    public int mLikers;
    public int mListeners;
    public String mPortrait;
    public String mPublisherPortrait;
    public int mStatus;
    public UserPermission mUser;

    /* loaded from: classes.dex */
    public final class LikeType {
        public static final int LIKE = 1;
        public static final int UNLIKE = 2;
    }

    /* loaded from: classes.dex */
    public final class LiveType {
        public static final int COMMING_SOON = 2;
        public static final int DELETE = 0;
        public static final int END = 6;
        public static final int NOT_START = 1;
        public static final int PAUSE = 5;
        public static final int SIMULATION_START = 4;
        public static final int START = 3;
    }

    /* loaded from: classes.dex */
    public final class SubcribType {
        public static final int SUBCRIBED = 1;
        public static final int UNSUBCRIBED = 2;
    }

    public void parseData(ResponseJoinLiveGroupMessage responseJoinLiveGroupMessage) {
        this.mGroupInfo = responseJoinLiveGroupMessage.getLiveGroupInfo();
        List<LikeUserInfo> likeUserList = responseJoinLiveGroupMessage.getLikeUserList();
        this.mLikeUserList = new ArrayList();
        if (likeUserList != null) {
            for (LikeUserInfo likeUserInfo : likeUserList) {
                MetaData metaData = new MetaData();
                metaData.setPortrait(likeUserInfo.portrait);
                metaData.setUserId(String.valueOf(likeUserInfo.userId));
                metaData.setUserName(likeUserInfo.userName);
                this.mLikeUserList.add(metaData);
            }
        }
        this.authorId = String.valueOf(this.mGroupInfo.authorId);
        this.mUser = responseJoinLiveGroupMessage.getUser();
        if (this.mUser != null) {
            this.mIsHost = this.mUser.isGroupOwner.intValue() == 1;
            if (this.mUser.isSubscribe.intValue() == 1) {
                this.mIsSubcribed = true;
            } else {
                this.mIsSubcribed = false;
            }
            this.mCanForenoticeThread = this.mUser.canForenoticeThread.intValue() == 1;
            this.mIsLike = this.mUser.isLike.intValue() == 1 ? 1 : 2;
        }
        this.mGroupName = this.mGroupInfo.name;
        this.mGroupIntro = this.mGroupInfo.intro;
        this.mPublisherPortrait = this.mGroupInfo.publisherPortrait;
        this.mPortrait = this.mGroupInfo.portrait;
        this.mIsBeMuted = this.mUser.isBanned.intValue() == 1;
        this.mListeners = this.mGroupInfo.listeners.intValue();
        this.mLikers = this.mGroupInfo.likers.intValue();
        if (this.mGroupInfo.status.intValue() == 3 || this.mGroupInfo.status.intValue() == 4 || this.mGroupInfo.status.intValue() == 6 || this.mGroupInfo.status.intValue() == 5) {
            this.mStatus = this.mGroupInfo.status.intValue();
        } else {
            this.mStatus = 1;
        }
        if (TextUtils.isEmpty(this.mForumName)) {
            this.mForumName = this.mGroupInfo.forumName;
        }
    }

    public LiveMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.MSG_COUNT_PER = 20;
        this.mIsSubcribed = false;
        this.mListeners = 0;
        this.mLikers = 0;
        this.mIsHost = false;
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.LiveMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2013007) {
                        List<ChatMessage> processServerMsg = LiveMsglistModel.this.processServerMsg(customResponsedMessage);
                        if (processServerMsg != null) {
                            sendNewestPubliserMsg(processServerMsg);
                        }
                    } else if (customResponsedMessage.getCmd() == 2001146) {
                        LiveMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001149) {
                        LiveMsglistModel.this.processHistory(customResponsedMessage);
                    }
                }
            }

            private void sendNewestPubliserMsg(List<ChatMessage> list) {
                if (list != null && !TextUtils.isEmpty(LiveMsglistModel.this.authorId)) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        ChatMessage chatMessage = list.get(size);
                        if (LiveMsglistModel.this.authorId.equals(chatMessage.getUserInfo().getUserId())) {
                            MessageManager.getInstance().dispatchResponsedMessage(new LivePublisherSayMessage(chatMessage));
                            return;
                        }
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 9;
    }

    public void initBundle(Intent intent, Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("forum_name")) {
                this.mForumName = bundle.getString("forum_name");
                return;
            }
            return;
        }
        this.mForumName = intent.getStringExtra("forum_name");
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(bt btVar) {
        if (this.mGroup == null) {
            return false;
        }
        c cVar = new c();
        cVar.limit = 20;
        cVar.beu = null;
        cVar.bev = null;
        cVar.id = new StringBuilder(String.valueOf(this.mGroup.getGroupId())).toString();
        super.sendMessage(new LoadGroupHistoryMessage(cVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2 = 0;
        if (this.mGroup != null) {
            c cVar = new c();
            cVar.limit = 20;
            if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.mDatas.getChatMessages().get(0).getMsgId();
                j2 = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            cVar.beu = String.valueOf(j);
            cVar.bev = String.valueOf(j2);
            cVar.id = new StringBuilder(String.valueOf(this.mGroup.getGroupId())).toString();
            super.sendMessage(new LoadGroupHistoryMessage(cVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mGroup == null) {
            return false;
        }
        a aVar = new a();
        aVar.id = new StringBuilder(String.valueOf(this.mGroup.getGroupId())).toString();
        super.sendMessage(new LoadGroupDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        p pVar = new p();
        if (this.mGroup == null || this.mGroup.getGroupId() == 0) {
            return false;
        }
        pVar.mId = String.valueOf(this.mGroup.getGroupId());
        pVar.mDraft = str;
        super.sendMessage(new GroupSaveDraftMessage(pVar));
        return true;
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2013007, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001146, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001149, this.mCustomMessageListener);
    }

    protected void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage genChatMessage() {
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        if (getGroup() == null) {
            return null;
        }
        groupChatMessage.setGroupId(String.valueOf(getGroup().getGroupId()));
        return groupChatMessage;
    }

    public void sendUserMuteMessage(String str, int i, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2).append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            StringBuilder sb2 = new StringBuilder();
            if (strArr2 != null && strArr2.length > 0) {
                for (String str3 : strArr2) {
                    sb2.append(str3).append(",");
                }
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            }
            RequestLiveGroupOwnerGagMessage requestLiveGroupOwnerGagMessage = new RequestLiveGroupOwnerGagMessage();
            requestLiveGroupOwnerGagMessage.setGroupId(com.baidu.adp.lib.g.c.f(str, 0));
            requestLiveGroupOwnerGagMessage.setType(i);
            requestLiveGroupOwnerGagMessage.setUserIds(sb.toString());
            requestLiveGroupOwnerGagMessage.setUserNames(sb2.toString());
            sendMessage(requestLiveGroupOwnerGagMessage);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected MsglistModel.CacheInfo getCacheInfo() {
        if (this.mGroup == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.customGroupType = 9;
        cacheInfo.id = String.valueOf(this.mGroup.getGroupId());
        return cacheInfo;
    }
}
