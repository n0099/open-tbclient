package com.baidu.tieba.im.chat;

import com.baidu.location.LocationClientOption;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax extends com.baidu.tieba.im.m<LinkedList<String>> {
    final /* synthetic */ x b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(x xVar, String str) {
        this.b = xVar;
        this.c = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ LinkedList<String> a() {
        return com.baidu.tieba.im.db.m.d().a(this.c, 2, (String) null, LocationClientOption.MIN_SCAN_SPAN);
    }
}
