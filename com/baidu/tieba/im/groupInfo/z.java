package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ y a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, String str, String str2, long j) {
        this.a = yVar;
        this.b = str;
        this.c = str2;
        this.d = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        GroupSettingItemData b = this.a.b(this.b, this.c);
        if (b != null && b.isAlreadyApply()) {
            if (System.currentTimeMillis() - b.getLastApplyTimeStamp() <= this.d) {
                return false;
            }
        }
        return true;
    }
}
