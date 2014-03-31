package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ aa b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ long e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, String str, String str2, long j) {
        this.b = aaVar;
        this.c = str;
        this.d = str2;
        this.e = j;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        GroupSettingItemData b = this.b.b(this.c, this.d);
        if (b != null && b.isAlreadyApply()) {
            if (System.currentTimeMillis() - b.getLastApplyTimeStamp() <= this.e) {
                return false;
            }
        }
        return true;
    }
}
