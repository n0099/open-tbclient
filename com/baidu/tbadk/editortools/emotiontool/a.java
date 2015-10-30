package com.baidu.tbadk.editortools.emotiontool;
/* loaded from: classes.dex */
public abstract class a implements Comparable<a> {

    /* renamed from: com.baidu.tbadk.editortools.emotiontool.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0046a {
        void a(t tVar);
    }

    protected abstract void AG();

    public abstract void a(InterfaceC0046a interfaceC0046a);

    public abstract int getIndex();

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        AG();
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
