package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class bq extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ bo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bo boVar) {
        this.b = boVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.aa.a().d(TbadkApplication.E(), this.b.b()));
    }
}
