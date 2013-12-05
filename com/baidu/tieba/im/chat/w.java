package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u f1609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.f1609a = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.u.b(TiebaApplication.B(), this.f1609a.c()));
    }
}
