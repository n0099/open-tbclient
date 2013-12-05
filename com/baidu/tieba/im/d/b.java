package com.baidu.tieba.im.d;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.im.net.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f1640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f1640a = aVar;
    }

    @Override // com.baidu.tieba.im.net.a
    public boolean a(int i, String str) {
        this.f1640a.d();
        return false;
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(Map<String, String> map) {
        this.f1640a.c();
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(String str) {
    }
}
