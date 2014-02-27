package com.baidu.tieba.im.model;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.ay;
import com.baidu.tieba.im.message.bc;
import com.baidu.tieba.im.randchat.WaitingTipView;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public final class ar extends com.baidu.adp.a.d {
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

    public final LinkedList<Pair<WaitingTipView.Type, Object[]>> a() {
        return this.b;
    }

    public ar(Activity activity) {
        this.a = activity;
        this.g[0] = this.a.getString(R.string.rand_chat_waiting_wait_time_no1);
        this.g[1] = this.a.getString(R.string.rand_chat_waiting_wait_time_no2);
    }

    public final String b() {
        return this.g[new Random().nextInt(2)];
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final boolean e() {
        return this.k;
    }

    public final void a(boolean z) {
        this.k = true;
    }

    public final RandChatRoomData f() {
        return this.c;
    }

    public final void a(RandChatRoomData randChatRoomData) {
        this.c = randChatRoomData;
    }

    public final int g() {
        return this.f;
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(Intent intent) {
        this.c = (RandChatRoomData) intent.getParcelableExtra("randChatRoomData");
        this.f = intent.getIntExtra("startCount", 0);
        this.e = this.c.f();
        this.d = this.c.e();
        this.h = this.c.a();
        this.i = this.c.b();
    }

    public final void b(RandChatRoomData randChatRoomData) {
        this.c = randChatRoomData;
        this.e = randChatRoomData.f();
        this.d = randChatRoomData.e();
        this.h = this.c.a();
        this.i = this.c.b();
    }

    public final void a(int i, boolean z, int i2) {
        com.baidu.tieba.im.messageCenter.d.a().a(new ay(i, z ? 1 : 0, i2));
    }

    public static void a(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.d.a().a(106102, gVar);
        com.baidu.tieba.im.messageCenter.d.a().a(106001, gVar);
        com.baidu.tieba.im.messageCenter.d.a().a(-119, gVar);
        com.baidu.tieba.im.messageCenter.d.a().a(106103, gVar);
    }

    public static void b(com.baidu.tieba.im.messageCenter.g gVar) {
        com.baidu.tieba.im.messageCenter.d.a().a(gVar);
        com.baidu.tieba.im.messageCenter.d.a().a(gVar);
        com.baidu.tieba.im.messageCenter.d.a().a(gVar);
        com.baidu.tieba.im.messageCenter.d.a().a(gVar);
    }

    public final void a(String str) {
        this.h = str;
    }

    public final void b(String str) {
        this.i = str;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final void a(int i, String str, String str2, boolean z) {
        this.j = z;
        if (this.j) {
            this.h = null;
            this.i = null;
        } else {
            this.h = str;
            this.i = str2;
        }
        com.baidu.tieba.im.messageCenter.d a = com.baidu.tieba.im.messageCenter.d.a();
        String str3 = this.h;
        String str4 = this.i;
        bc bcVar = new bc();
        bcVar.a(i);
        bcVar.a(str3);
        bcVar.b(str4);
        a.a(bcVar);
    }

    public final void b(int i) {
        com.baidu.tieba.im.messageCenter.d a = com.baidu.tieba.im.messageCenter.d.a();
        com.baidu.tieba.im.message.ae aeVar = new com.baidu.tieba.im.message.ae();
        aeVar.a(i);
        a.a(aeVar);
    }
}
