package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, String str2, long j) {
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        GroupSettingItemData a = u.a(this.a, this.b);
        if (a != null && a.isAlreadyApply()) {
            if (System.currentTimeMillis() - a.getLastApplyTimeStamp() <= this.c) {
                return false;
            }
        }
        return true;
    }
}
