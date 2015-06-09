package com.baidu.tbadk.editortool;
/* loaded from: classes.dex */
public abstract class a implements Comparable<a> {
    public abstract void a(b bVar);

    public abstract int getIndex();

    protected abstract void zn();

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        zn();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(a aVar) {
        if (aVar == null) {
            return 1;
        }
        return getIndex() - aVar.getIndex();
    }
}
