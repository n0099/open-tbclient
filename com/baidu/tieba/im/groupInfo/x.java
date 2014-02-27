package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, String str2, long j) {
        this.a = str;
        this.c = str2;
        this.d = j;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        GroupSettingItemData a = v.a(this.a, this.c);
        if (a != null && a.isAlreadyApply()) {
            if (System.currentTimeMillis() - a.getLastApplyTimeStamp() <= this.d) {
                return false;
            }
        }
        return true;
    }
}
