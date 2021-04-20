package com.baidu.tbadk.util;

import android.util.SparseArray;
/* loaded from: classes3.dex */
public class ChatStatusManager {
    public static final int GROUP_CHAT = 2;
    public static final int OFFICIALBAR_CHAT = 1;
    public static final int OFFICIAL_MERGE = 4;
    public static final int PERSONAL_CHAT = 0;
    public static final int STRANGER_MERGE = 5;
    public static final int UPDATES = 6;
    public static final int VALIDATE = 7;
    public static ChatStatusManager instance;
    public SparseArray<a> mStatus = new SparseArray<>();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f13694a;

        /* renamed from: b  reason: collision with root package name */
        public String f13695b;
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

    public String getCurId(int i) {
        a aVar = this.mStatus.get(i);
        return aVar != null ? aVar.f13695b : "";
    }

    public boolean getIsOpen(int i) {
        a aVar = this.mStatus.get(i);
        if (aVar != null) {
            return aVar.f13694a;
        }
        return false;
    }

    public void remove(int i) {
        this.mStatus.delete(i);
    }

    public void setCurId(int i, String str) {
        a aVar = this.mStatus.get(i);
        if (aVar != null) {
            aVar.f13695b = str;
            return;
        }
        a aVar2 = new a();
        aVar2.f13695b = str;
        this.mStatus.put(i, aVar2);
    }

    public void setIsOpen(int i, boolean z) {
        a aVar = this.mStatus.get(i);
        if (aVar != null) {
            aVar.f13694a = z;
            return;
        }
        a aVar2 = new a();
        aVar2.f13694a = z;
        this.mStatus.put(i, aVar2);
    }
}
