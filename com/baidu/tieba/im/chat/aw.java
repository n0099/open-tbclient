package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aw extends SingleRunnable<GroupSettingItemData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(int i) {
        this.f1554a = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public GroupSettingItemData b() {
        return com.baidu.tieba.im.groupInfo.u.a(TiebaApplication.B(), String.valueOf(this.f1554a));
    }
}
