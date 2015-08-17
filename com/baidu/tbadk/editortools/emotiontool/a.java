package com.baidu.tbadk.editortools.emotiontool;
/* loaded from: classes.dex */
public abstract class a implements Comparable<a> {

    /* renamed from: com.baidu.tbadk.editortools.emotiontool.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a {
        void a(v vVar);
    }

    protected abstract void AJ();

    public abstract void a(InterfaceC0047a interfaceC0047a);

    public abstract int getIndex();

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        AJ();
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
