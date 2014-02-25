package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.im.c<Boolean> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, String str2, long j) {
        this.a = str;
        this.c = str2;
        this.d = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        GroupSettingItemData a = v.a(this.a, this.c);
        if (a != null && a.isAlreadyApply()) {
            if (System.currentTimeMillis() - a.getLastApplyTimeStamp() <= this.d) {
                return false;
            }
        }
        return true;
    }
}
