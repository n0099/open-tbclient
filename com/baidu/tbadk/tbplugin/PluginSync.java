package com.baidu.tbadk.tbplugin;
/* loaded from: classes.dex */
public interface PluginSync {

    /* loaded from: classes.dex */
    public enum Status {
        SYNCING,
        READY,
        INVALID;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Status[] valuesCustom() {
            Status[] valuesCustom = values();
            int length = valuesCustom.length;
            Status[] statusArr = new Status[length];
            System.arraycopy(valuesCustom, 0, statusArr, 0, length);
            return statusArr;
        }
    }

    PluginsConfig a();

    PluginsConfig a(r rVar);
}
