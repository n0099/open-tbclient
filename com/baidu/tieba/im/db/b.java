package com.baidu.tieba.im.db;

import com.baidu.tieba.im.chat.officialBar.ax;
import com.baidu.tieba.im.groupInfo.aa;
/* loaded from: classes.dex */
public class b {
    private static b aVo = new b();

    public static b Mz() {
        return aVo;
    }

    private b() {
    }

    public synchronized void KF() {
        com.baidu.tieba.im.chat.personaltalk.c.KJ().KF();
        ax.KE().KF();
        aa.Pe().KF();
    }
}
