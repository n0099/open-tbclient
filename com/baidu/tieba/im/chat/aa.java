package com.baidu.tieba.im.chat;

import com.baidu.location.LocationClientOption;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa extends com.baidu.tieba.im.b<LinkedList<String>> {
    final /* synthetic */ q a;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(q qVar, String str) {
        this.a = qVar;
        this.c = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ LinkedList<String> a() {
        return com.baidu.tieba.im.db.b.a().a(this.c, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN);
    }
}
