package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
public abstract class e implements Comparable<e> {
    public abstract int a();

    public abstract void a(f fVar);

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public e() {
        b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        if (eVar == null) {
            return 1;
        }
        return a() - eVar.a();
    }
}
