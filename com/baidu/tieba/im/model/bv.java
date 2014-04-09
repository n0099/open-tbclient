package com.baidu.tieba.im.model;

import android.content.Intent;
import android.util.Pair;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.randchat.WaitingTipView;
import java.util.LinkedList;
import java.util.Random;
/* loaded from: classes.dex */
public final class bv extends com.baidu.adp.a.e {
    private com.baidu.tbadk.a a;
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

    public bv(com.baidu.tbadk.a aVar) {
        this.a = aVar;
        this.g[0] = this.a.getString(com.baidu.tieba.im.j.rand_chat_waiting_wait_time_no1);
        this.g[1] = this.a.getString(com.baidu.tieba.im.j.rand_chat_waiting_wait_time_no2);
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

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
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
        this.a.sendMessage(new com.baidu.tieba.im.message.au(i, z ? 1 : 0, i2));
    }

    public final void a(com.baidu.adp.framework.c.g gVar) {
        this.a.registerListener(106102, gVar);
        this.a.registerListener(106001, gVar);
        this.a.registerListener(106103, gVar);
    }

    public final void a(com.baidu.adp.framework.c.a aVar) {
        this.a.registerListener(aVar);
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
        com.baidu.tbadk.a aVar = this.a;
        String str3 = this.h;
        String str4 = this.i;
        com.baidu.tieba.im.message.bb bbVar = new com.baidu.tieba.im.message.bb();
        bbVar.d(i);
        bbVar.a(str3);
        bbVar.b(str4);
        aVar.sendMessage(bbVar);
    }

    public final void b(int i) {
        com.baidu.tbadk.a aVar = this.a;
        com.baidu.tieba.im.message.z zVar = new com.baidu.tieba.im.message.z();
        zVar.d(i);
        aVar.sendMessage(zVar);
    }
}
