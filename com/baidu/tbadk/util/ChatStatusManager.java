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
        public boolean f13015a;

        /* renamed from: b  reason: collision with root package name */
        public String f13016b;
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

    public String getCurId(int i2) {
        a aVar = this.mStatus.get(i2);
        return aVar != null ? aVar.f13016b : "";
    }

    public boolean getIsOpen(int i2) {
        a aVar = this.mStatus.get(i2);
        if (aVar != null) {
            return aVar.f13015a;
        }
        return false;
    }

    public void remove(int i2) {
        this.mStatus.delete(i2);
    }

    public void setCurId(int i2, String str) {
        a aVar = this.mStatus.get(i2);
        if (aVar != null) {
            aVar.f13016b = str;
            return;
        }
        a aVar2 = new a();
        aVar2.f13016b = str;
        this.mStatus.put(i2, aVar2);
    }

    public void setIsOpen(int i2, boolean z) {
        a aVar = this.mStatus.get(i2);
        if (aVar != null) {
            aVar.f13015a = z;
            return;
        }
        a aVar2 = new a();
        aVar2.f13015a = z;
        this.mStatus.put(i2, aVar2);
    }
}
