package com.baidu.tieba.im.model;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.data.UserData;
import com.baidu.tieba.im.message.as;
import com.baidu.tieba.im.message.aw;
import com.baidu.tieba.im.message.bh;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import protobuf.Im;
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.a.d {
    private Activity a;
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

    public ar(Activity activity) {
        this.a = activity;
        this.g[0] = this.a.getString(R.string.rand_chat_waiting_wait_time_no1);
        this.g[1] = this.a.getString(R.string.rand_chat_waiting_wait_time_no2);
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

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
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

    private as a(int i, int i2, int i3) {
        return new as(i, i2, i3);
    }

    public void a(int i, boolean z, int i2) {
        com.baidu.tieba.im.messageCenter.e.a().a(a(i, z ? 1 : 0, i2));
    }

    public void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(106102, gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(106001, gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(-119, gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(106103, gVar);
    }

    public void b(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
        com.baidu.tieba.im.messageCenter.e.a().a(gVar);
    }

    private aw a(int i, String str, String str2) {
        aw awVar = new aw();
        awVar.a(i);
        awVar.a(str);
        awVar.b(str2);
        return awVar;
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
        com.baidu.tieba.im.messageCenter.e.a().a(a(i, this.h, this.i));
    }

    private com.baidu.tieba.im.message.ab c(int i) {
        com.baidu.tieba.im.message.ab abVar = new com.baidu.tieba.im.message.ab();
        abVar.a(i);
        return abVar;
    }

    public void b(int i) {
        com.baidu.tieba.im.messageCenter.e.a().a(c(i));
    }

    public List<UserData> a(bh bhVar) {
        if (bhVar == null || bhVar.a() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Im.UserInfo userInfo : bhVar.a()) {
            UserData userData = new UserData();
            userData.setInTime(userInfo.getInTime());
            userData.setLastReplyTime(userInfo.getLastReplyTime());
            userData.setLat(String.valueOf(userInfo.getLat()));
            userData.setLng(String.valueOf(userInfo.getLng()));
            userData.setLoginTime(userInfo.getLoginTime());
            userData.setPortrait(userInfo.getPortrait());
            userData.setPosition(userInfo.getPosition());
            userData.setSex(userInfo.getSex());
            userData.setUserId(userInfo.getUserId());
            userData.setUserName(userInfo.getUserName());
            arrayList.add(userData);
        }
        return arrayList;
    }
}
