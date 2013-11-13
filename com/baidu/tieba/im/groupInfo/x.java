package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1705a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, String str2, long j) {
        this.f1705a = str;
        this.b = str2;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        GroupSettingItemData a2 = v.a(this.f1705a, this.b);
        if (a2 != null && a2.isAlreadyApply()) {
            if (System.currentTimeMillis() - a2.getLastApplyTimeStamp() <= this.c) {
                return false;
            }
        }
        return true;
    }
}
