package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1763a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, String str2, long j) {
        this.f1763a = str;
        this.b = str2;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        GroupSettingItemData a2 = u.a(this.f1763a, this.b);
        if (a2 != null && a2.isAlreadyApply()) {
            if (System.currentTimeMillis() - a2.getLastApplyTimeStamp() <= this.c) {
                return false;
            }
        }
        return true;
    }
}
