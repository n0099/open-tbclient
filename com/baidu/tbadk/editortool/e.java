package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
public abstract class e implements Comparable<e> {
    public abstract int a();

    public abstract void a(f fVar);

    protected abstract void b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(e eVar) {
        e eVar2 = eVar;
        if (eVar2 == null) {
            return 1;
        }
        return a() - eVar2.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e() {
        b();
    }
}
