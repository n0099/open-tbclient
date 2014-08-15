package com.baidu.tbadk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.d {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.d
    public boolean a() {
        return !h.a().a("is_exit_app_not_start_websocket", false);
    }
}
