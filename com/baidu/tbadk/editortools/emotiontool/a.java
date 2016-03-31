package com.baidu.tbadk.editortools.emotiontool;
/* loaded from: classes.dex */
public abstract class a implements Comparable<a> {

    /* renamed from: com.baidu.tbadk.editortools.emotiontool.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0049a {
        void a(c cVar);
    }

    protected abstract void Dy();

    public abstract void a(InterfaceC0049a interfaceC0049a);

    public abstract int getIndex();

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        Dy();
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
