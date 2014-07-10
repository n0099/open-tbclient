package com.baidu.tbadk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.adp.framework.client.socket.link.d {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // com.baidu.adp.framework.client.socket.link.d
    public boolean a() {
        return !i.a().a("is_exit_app_not_start_websocket", false);
    }
}
