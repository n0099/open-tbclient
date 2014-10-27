package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
public abstract class e implements Comparable<e> {
    public abstract void a(f fVar);

    public abstract int getIndex();

    protected abstract void op();

    /* JADX INFO: Access modifiers changed from: protected */
    public e() {
        op();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        if (eVar == null) {
            return 1;
        }
        return getIndex() - eVar.getIndex();
    }
}
