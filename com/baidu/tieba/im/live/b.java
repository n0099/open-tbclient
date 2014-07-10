package com.baidu.tieba.im.live;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ AccessTokenManager a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccessTokenManager accessTokenManager, String str) {
        this.a = accessTokenManager;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.getAccesssTokenInBackground(this.b);
    }
}
