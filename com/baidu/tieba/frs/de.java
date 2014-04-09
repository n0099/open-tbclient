package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.HttpMessage;
/* loaded from: classes.dex */
public final class de extends com.baidu.adp.a.e {
    private static final String b = String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/zan/like";
    private static com.baidu.tbadk.c.b c;
    private dg a;
    private com.baidu.adp.framework.c.b d = new df(this, 1014000);

    static {
        com.baidu.tbadk.c.b bVar = new com.baidu.tbadk.c.b(1014000, b);
        c = bVar;
        bVar.a(PraiseResponseMessage.class);
        com.baidu.adp.framework.c.a().a(c);
    }

    public de(dg dgVar) {
        this.a = null;
        this.a = dgVar;
    }

    public final void a() {
        registerListener(this.d);
    }

    public static void a(String str, String str2, int i, String str3) {
        String str4;
        if (i == 1) {
            str4 = "unlike";
        } else {
            str4 = "like";
        }
        HttpMessage httpMessage = new HttpMessage(1014000);
        httpMessage.a("st_type", str4);
        httpMessage.a("action", str4);
        httpMessage.a("post_id", new StringBuilder(String.valueOf(str)).toString());
        httpMessage.a("thread_id", new StringBuilder(String.valueOf(str2)).toString());
        httpMessage.a("st_param", str3);
        httpMessage.b(1014000);
        com.baidu.adp.framework.c.a().a(httpMessage);
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
