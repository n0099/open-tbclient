package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class ae {
    private static ae a;
    private volatile String b = "";
    private AtomicBoolean c = new AtomicBoolean(false);
    private ConcurrentHashMap<String, ImMessageCenterPojo> d = new ConcurrentHashMap<>();

    private ae() {
    }

    public static synchronized ae a() {
        ae aeVar;
        synchronized (ae.class) {
            if (a == null) {
                a = new ae();
            }
            aeVar = a;
        }
        return aeVar;
    }

    public synchronized void a(com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> aVar) {
        if (Thread.currentThread().getId() != com.baidu.tieba.im.i.a) {
            com.baidu.adp.lib.g.e.a("!!!!!!!!!!!!!!!获取缓存不是在主线程里面执行了！");
            if (com.baidu.tieba.data.h.u()) {
                new RuntimeException().printStackTrace();
            }
        }
        if (aVar != null) {
            d();
            if (this.c.get()) {
                aVar.a(this.d);
            } else {
                b(new af(this, aVar));
            }
        }
    }

    public synchronized ConcurrentHashMap<String, ImMessageCenterPojo> b() {
        d();
        return this.d;
    }

    private void b(com.baidu.tieba.im.a<LinkedList<ImMessageCenterPojo>> aVar) {
        d();
        com.baidu.tieba.im.m.a(new ag(this), aVar);
    }

    public static ImMessageCenterPojo a(CommonMsgPojo commonMsgPojo) {
        if (commonMsgPojo == null) {
            com.baidu.adp.lib.g.e.d("see init cmpojo is null");
            return null;
        }
        String A = TiebaApplication.A();
        if (TextUtils.isEmpty(A)) {
            com.baidu.adp.lib.g.e.d("see init not login:");
            return null;
        }
        com.baidu.adp.lib.g.e.d("see init private cmpojo:" + commonMsgPojo);
        String gid = commonMsgPojo.getGid();
        if (TextUtils.isEmpty(gid)) {
            com.baidu.adp.lib.g.e.a("see init private uid  is null uid:" + gid);
            return null;
        }
        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
        imMessageCenterPojo.setGid(gid);
        UserData userData = (UserData) new Gson().fromJson(commonMsgPojo.getUser_info(), (Class<Object>) UserData.class);
        if (userData == null) {
            com.baidu.adp.lib.g.e.d("see init private userinfo:" + commonMsgPojo.getUser_info());
            return null;
        }
        String toUid = commonMsgPojo.getToUid();
        if (!TextUtils.isEmpty(toUid) && toUid.equals(gid) && A.equals(gid)) {
            com.baidu.adp.lib.g.e.a("see init private : send msg to self");
            return null;
        }
        String uid = commonMsgPojo.getUid();
        if (A.equals(uid)) {
            UserData userData2 = (UserData) new Gson().fromJson(commonMsgPojo.getToUser_info(), (Class<Object>) UserData.class);
            if (userData2 != null) {
                imMessageCenterPojo.setGroup_name(userData2.getName());
                imMessageCenterPojo.setGroup_head(userData2.getPortrait());
            }
        } else {
            imMessageCenterPojo.setGroup_name(userData.getName());
            imMessageCenterPojo.setGroup_head(userData.getPortrait());
        }
        imMessageCenterPojo.setGroup_type(6);
        if (A.equals(uid)) {
            imMessageCenterPojo.setLast_content(com.baidu.tieba.im.d.d.g(commonMsgPojo.toChatMessage()));
        } else {
            imMessageCenterPojo.setLast_content(userData.getName() + ":" + com.baidu.tieba.im.d.d.g(commonMsgPojo.toChatMessage()));
        }
        imMessageCenterPojo.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
        com.baidu.adp.lib.g.e.d("see convert " + imMessageCenterPojo + "ori:" + commonMsgPojo);
        return imMessageCenterPojo;
    }

    private synchronized void d() {
        String A = TiebaApplication.A();
        if (TextUtils.isEmpty(A) || !A.equals(this.b)) {
            this.d.clear();
            this.b = A;
            this.c.set(false);
        }
    }

    public void c() {
        this.c.set(false);
        this.b = null;
        this.d.clear();
    }
}
