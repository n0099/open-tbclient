package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ y b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ long e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, String str, String str2, long j) {
        this.b = yVar;
        this.c = str;
        this.d = str2;
        this.e = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        GroupSettingItemData b = this.b.b(this.c, this.d);
        if (b != null && b.isAlreadyApply()) {
            if (System.currentTimeMillis() - b.getLastApplyTimeStamp() <= this.e) {
                return false;
            }
        }
        return true;
    }
}
