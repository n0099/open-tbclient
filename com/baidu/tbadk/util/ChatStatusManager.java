package com.baidu.tbadk.util;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class ChatStatusManager {
    public static final int GROUP_CHAT = 2;
    public static final int OFFICIALBAR_CHAT = 1;
    public static final int OFFICIAL_MERGE = 4;
    public static final int PERSONAL_CHAT = 0;
    public static final int STRANGER_MERGE = 5;
    public static final int UPDATES = 6;
    public static final int VALIDATE = 7;
    private static ChatStatusManager instance;
    private SparseArray<a> mStatus = new SparseArray<>();

    /* loaded from: classes.dex */
    public static class a {
        public String bit;
        public boolean isOpen;
    }

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
        a aVar = this.mStatus.get(i);
        if (aVar == null) {
            return false;
        }
        return aVar.isOpen;
    }

    public String getCurId(int i) {
        a aVar = this.mStatus.get(i);
        if (aVar == null) {
            return "";
        }
        return aVar.bit;
    }

    public void setIsOpen(int i, boolean z) {
        a aVar = this.mStatus.get(i);
        if (aVar != null) {
            aVar.isOpen = z;
            return;
        }
        a aVar2 = new a();
        aVar2.isOpen = z;
        this.mStatus.put(i, aVar2);
    }

    public void setCurId(int i, String str) {
        a aVar = this.mStatus.get(i);
        if (aVar != null) {
            aVar.bit = str;
            return;
        }
        a aVar2 = new a();
        aVar2.bit = str;
        this.mStatus.put(i, aVar2);
    }

    public void remove(int i) {
        this.mStatus.delete(i);
    }
}
