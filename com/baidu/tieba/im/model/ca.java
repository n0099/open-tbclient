package com.baidu.tieba.im.model;

import android.content.Intent;
import android.util.Pair;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.RequestChatRoomInfoMessage;
import com.baidu.tieba.im.message.RequestQuitChatRoomMessage;
import com.baidu.tieba.im.message.RequestUpdateChatroomTopicMessage;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.randchat.WaitingTipView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ca extends com.baidu.adp.base.d {
    private BaseActivity a;
    private RandChatRoomData c;
    private int d;
    private int e;
    private int f;
    private LinkedList<Pair<WaitingTipView.Type, Object[]>> b = new LinkedList<>();
    private String[] g = new String[2];
    private String h = null;
    private String i = null;
    private boolean j = false;
    private boolean k = false;

    public LinkedList<Pair<WaitingTipView.Type, Object[]>> a() {
        return this.b;
    }

    public ca(BaseActivity baseActivity) {
        this.a = baseActivity;
        this.g[0] = this.a.getString(com.baidu.tieba.u.rand_chat_waiting_wait_time_no1);
        this.g[1] = this.a.getString(com.baidu.tieba.u.rand_chat_waiting_wait_time_no2);
    }

    public String b() {
        return this.g[new Random().nextInt(2)];
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public boolean e() {
        return this.k;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public RandChatRoomData f() {
        return this.c;
    }

    public void a(RandChatRoomData randChatRoomData) {
        this.c = randChatRoomData;
    }

    public int g() {
        return this.f;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Intent intent) {
        this.c = (RandChatRoomData) intent.getParcelableExtra("randChatRoomData");
        this.f = intent.getIntExtra("startCount", 0);
        this.e = this.c.f();
        this.d = this.c.e();
        this.h = this.c.a();
        this.i = this.c.b();
    }

    public void b(RandChatRoomData randChatRoomData) {
        this.c = randChatRoomData;
        this.e = randChatRoomData.f();
        this.d = randChatRoomData.e();
        this.h = this.c.a();
        this.i = this.c.b();
    }

    private RequestQuitChatRoomMessage a(int i, int i2, int i3) {
        return new RequestQuitChatRoomMessage(i, i2, i3);
    }

    public void a(int i, boolean z, int i2) {
        this.a.sendMessage(a(i, z ? 1 : 0, i2));
    }

    public void a(com.baidu.adp.framework.listener.b bVar) {
        this.a.registerListener(MessageTypes.CMD_QUIT_CHAT_ROOM, bVar);
        this.a.registerListener(MessageTypes.CMD_QUERY_CHAT_ROOM_INFO, bVar);
        this.a.registerListener(MessageTypes.CMD_UPDATE_CHATROOM_TOPIC, bVar);
    }

    public void a(CustomMessageListener customMessageListener) {
        this.a.registerListener(customMessageListener);
    }

    private RequestUpdateChatroomTopicMessage a(int i, String str, String str2) {
        RequestUpdateChatroomTopicMessage requestUpdateChatroomTopicMessage = new RequestUpdateChatroomTopicMessage();
        requestUpdateChatroomTopicMessage.setGroupId(i);
        requestUpdateChatroomTopicMessage.setTitle(str);
        requestUpdateChatroomTopicMessage.setContent(str2);
        return requestUpdateChatroomTopicMessage;
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(String str) {
        this.i = str;
    }

    public String h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public void a(int i, String str, String str2, boolean z) {
        this.j = z;
        if (this.j) {
            this.h = null;
            this.i = null;
        } else {
            this.h = str;
            this.i = str2;
        }
        this.a.sendMessage(a(i, this.h, this.i));
    }

    private RequestChatRoomInfoMessage c(int i) {
        RequestChatRoomInfoMessage requestChatRoomInfoMessage = new RequestChatRoomInfoMessage();
        requestChatRoomInfoMessage.setGroupId(i);
        return requestChatRoomInfoMessage;
    }

    public void b(int i) {
        this.a.sendMessage(c(i));
    }

    public List<UserData> a(ResponseChatRoomInfoMessage responseChatRoomInfoMessage) {
        if (responseChatRoomInfoMessage == null || responseChatRoomInfoMessage.getUserList() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (UserInfo userInfo : responseChatRoomInfoMessage.getUserList()) {
            UserData userData = new UserData();
            userData.setInTime(userInfo.inTime.intValue());
            userData.setLastReplyTime(userInfo.lastReplyTime.intValue());
            userData.setLat(String.valueOf(userInfo.lat));
            userData.setLng(String.valueOf(userInfo.lng));
            userData.setLoginTime(userInfo.loginTime.intValue());
            userData.setPortrait(userInfo.portrait);
            userData.setPosition(userInfo.position);
            userData.setSex(userInfo.sex.intValue());
            userData.setUserIdLong(userInfo.userId.intValue());
            userData.setUserName(userInfo.userName);
            arrayList.add(userData);
        }
        return arrayList;
    }
}
