package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at extends SingleRunnable<GroupSettingItemData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(int i) {
        this.f1420a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public GroupSettingItemData b() {
        return com.baidu.tieba.im.groupInfo.v.a(TiebaApplication.C(), String.valueOf(this.f1420a));
    }
}
