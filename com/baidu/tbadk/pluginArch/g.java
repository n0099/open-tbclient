package com.baidu.tbadk.pluginArch;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements b {
    final /* synthetic */ d a;
    private String b;
    private b c;

    public g(d dVar, String str, b bVar) {
        this.a = dVar;
        this.b = null;
        this.c = null;
        this.b = str;
        this.c = bVar;
    }

    @Override // com.baidu.tbadk.pluginArch.b
    public void a(int i, String str) {
        this.a.a(i, str, this.b);
        if (this.c != null) {
            this.c.a(i, str);
        }
    }
}
