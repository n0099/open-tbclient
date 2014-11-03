package com.baidu.tbadk.util;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ChatStatusManager {
    public static final int GROUP_CHAT = 2;
    public static final int OFFICIALBAR_CHAT = 1;
    public static final int PERSONAL_CHAT = 0;
    public static final int SNAP_CHAT = 3;
    private static ChatStatusManager instance;
    private SparseArray<c> mStatus = new SparseArray<>();

    public static synchronized ChatStatusManager getInst() {
        ChatStatusManager chatStatusManager;
        synchronized (ChatStatusManager.class) {
            if (instance == null) {
                instance = new ChatStatusManager();
            }
            chatStatusManager = instance;
        }
        return chatStatusManager;
    }

    public boolean getIsOpen(int i) {
        c cVar = this.mStatus.get(i);
        if (cVar == null) {
            return false;
        }
        return cVar.isOpen;
    }

    public String getCurId(int i) {
        c cVar = this.mStatus.get(i);
        if (cVar == null) {
            return "";
        }
        return cVar.ZK;
    }

    public void setIsOpen(int i, boolean z) {
        c cVar = this.mStatus.get(i);
        if (cVar != null) {
            cVar.isOpen = z;
            return;
        }
        c cVar2 = new c();
        cVar2.isOpen = z;
        this.mStatus.put(i, cVar2);
    }

    public void setCurId(int i, String str) {
        c cVar = this.mStatus.get(i);
        if (cVar != null) {
            cVar.ZK = str;
            return;
        }
        c cVar2 = new c();
        cVar2.ZK = str;
        this.mStatus.put(i, cVar2);
    }

    public void remove(int i) {
        this.mStatus.delete(i);
    }
}
