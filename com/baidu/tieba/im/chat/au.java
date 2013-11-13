package com.baidu.tieba.im.chat;

import android.app.Activity;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class au implements com.baidu.tieba.im.a<GroupSettingItemData> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f1514a;
    final /* synthetic */ GroupData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(Activity activity, GroupData groupData) {
        this.f1514a = activity;
        this.b = groupData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(GroupSettingItemData groupSettingItemData) {
        if (groupSettingItemData != null) {
            MsglistActivity.b(this.f1514a, this.b, groupSettingItemData.isInGroup(), groupSettingItemData.isAcceptNotify());
        }
    }
}
