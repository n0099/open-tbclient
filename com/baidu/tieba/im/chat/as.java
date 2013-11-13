package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class as extends SingleRunnable<GroupSettingItemData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1512a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(int i) {
        this.f1512a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public GroupSettingItemData b() {
        return com.baidu.tieba.im.groupInfo.v.a(TiebaApplication.A(), String.valueOf(this.f1512a));
    }
}
