package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends com.baidu.tieba.im.m<PersonalSettingItemData> {
    final /* synthetic */ k b;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, long j) {
        this.b = kVar;
        this.c = j;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ PersonalSettingItemData a() {
        return a.a().b(TbadkApplication.E(), String.valueOf(this.c));
    }
}
