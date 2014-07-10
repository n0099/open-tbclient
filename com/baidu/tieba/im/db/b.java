package com.baidu.tieba.im.db;

import com.baidu.tieba.im.chat.officialBar.bd;
import com.baidu.tieba.im.groupInfo.y;
/* loaded from: classes.dex */
public class b {
    private static b a = new b();

    public static b a() {
        return a;
    }

    private b() {
    }

    public synchronized void b() {
        com.baidu.tbadk.coreExtra.messageCenter.e.a().b();
        com.baidu.tieba.im.chat.personaltalk.a.a().b();
        bd.a().b();
        y.a().b();
        com.baidu.tieba.im.b.e.b();
    }
}
