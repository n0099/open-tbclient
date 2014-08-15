package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.RequestLiveGroupOwnerGagMessage;
import com.baidu.tieba.im.message.ResponseJoinLiveGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import java.util.ArrayList;
import java.util.List;
import protobuf.JoinLiveGroup.LikeUserInfo;
import protobuf.JoinLiveGroup.UserPermission;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
public class LiveMsglistModel extends CommonGroupMsglistModel {
    public LiveGroupInfo b;
    public UserPermission c;
    public List<MetaData> d;
    public String e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    private final int w;
    private CustomMessageListener x;

    public void a(ResponseJoinLiveGroupMessage responseJoinLiveGroupMessage) {
        this.b = responseJoinLiveGroupMessage.getLiveGroupInfo();
        List<LikeUserInfo> likeUserList = responseJoinLiveGroupMessage.getLikeUserList();
        this.d = new ArrayList();
        if (likeUserList != null) {
            for (LikeUserInfo likeUserInfo : likeUserList) {
                MetaData metaData = new MetaData();
                metaData.setPortrait(likeUserInfo.portrait);
                metaData.setUserId(String.valueOf(likeUserInfo.userId));
                metaData.setUserName(likeUserInfo.userName);
                this.d.add(metaData);
            }
        }
        this.o = String.valueOf(this.b.authorId);
        this.c = responseJoinLiveGroupMessage.getUser();
        if (this.c != null) {
            this.r = this.c.isGroupOwner.intValue() == 1;
            if (this.c.isSubscribe.intValue() == 1) {
                this.f = true;
            } else {
                this.f = false;
            }
            this.q = this.c.canForenoticeThread.intValue() == 1;
            this.g = this.c.isLike.intValue() == 1 ? 1 : 2;
        }
        this.j = this.b.name;
        this.k = this.b.intro;
        this.l = this.b.publisherPortrait;
        this.m = this.b.portrait;
        this.p = this.c.isBanned.intValue() == 1;
        this.h = this.b.listeners.intValue();
        this.i = this.b.likers.intValue();
        if (this.b.status.intValue() == 3 || this.b.status.intValue() == 4 || this.b.status.intValue() == 6 || this.b.status.intValue() == 5) {
            this.n = this.b.status.intValue();
        } else {
            this.n = 1;
        }
        if (TextUtils.isEmpty(this.e)) {
            this.e = this.b.forumName;
        }
    }

    public LiveMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.w = 20;
        this.f = false;
        this.h = 0;
        this.i = 0;
        this.r = false;
        this.x = new s(this, 0);
        m();
        this.v = 9;
    }

    public void a(Intent intent, Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME)) {
                this.e = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
                return;
            }
            return;
        }
        this.e = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(bt btVar) {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
        cVar.c = 20;
        cVar.a = null;
        cVar.b = null;
        cVar.d = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
        super.sendMessage(new LoadGroupHistoryMessage(cVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean d() {
        long j;
        long j2 = 0;
        if (this.a != null) {
            com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
            cVar.c = 20;
            if (this.s == null || this.s.getChatMessages() == null || this.s.getChatMessages().size() <= 0 || this.s.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.s.getChatMessages().get(0).getMsgId();
                j2 = this.s.getChatMessages().get(0).getRecordId();
            }
            cVar.a = String.valueOf(j);
            cVar.b = String.valueOf(j2);
            cVar.d = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
            super.sendMessage(new LoadGroupHistoryMessage(cVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean e() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.a aVar = new com.baidu.tieba.im.message.a();
        aVar.a = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
        super.sendMessage(new LoadGroupDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(String str) {
        com.baidu.tieba.im.message.q qVar = new com.baidu.tieba.im.message.q();
        if (this.a == null || this.a.getGroupId() == 0) {
            return false;
        }
        qVar.b = String.valueOf(this.a.getGroupId());
        qVar.a = str;
        super.sendMessage(new GroupSaveDraftMessage(qVar));
        return true;
    }

    private void m() {
        MessageManager.getInstance().registerListener(2013007, this.x);
        MessageManager.getInstance().registerListener(2001146, this.x);
        MessageManager.getInstance().registerListener(2001149, this.x);
    }

    protected void f() {
        MessageManager.getInstance().unRegisterListener(this.x);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage g() {
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        if (c() == null) {
            return null;
        }
        groupChatMessage.setGroupId(String.valueOf(c().getGroupId()));
        return groupChatMessage;
    }

    public void a(String str, int i, String[] strArr, String[] strArr2) {
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
            requestLiveGroupOwnerGagMessage.setGroupId(com.baidu.adp.lib.e.b.a(str, 0));
            requestLiveGroupOwnerGagMessage.setType(i);
            requestLiveGroupOwnerGagMessage.setUserIds(sb.toString());
            requestLiveGroupOwnerGagMessage.setUserNames(sb2.toString());
            sendMessage(requestLiveGroupOwnerGagMessage);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected aj h() {
        if (this.a == null) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.b = 9;
        ajVar.a = String.valueOf(this.a.getGroupId());
        return ajVar;
    }
}
