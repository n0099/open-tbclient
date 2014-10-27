package com.baidu.tieba.im.db;

import com.baidu.tieba.im.chat.officialBar.ax;
import com.baidu.tieba.im.groupInfo.z;
/* loaded from: classes.dex */
public class b {
    private static b aVa = new b();

    public static b Mv() {
        return aVa;
    }

    private b() {
    }

    public synchronized void KB() {
        com.baidu.tieba.im.chat.personaltalk.c.KF().KB();
        ax.KA().KB();
        z.Pb().KB();
    }
}
