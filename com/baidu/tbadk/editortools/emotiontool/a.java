package com.baidu.tbadk.editortools.emotiontool;
/* loaded from: classes.dex */
public abstract class a implements Comparable<a> {

    /* renamed from: com.baidu.tbadk.editortools.emotiontool.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057a {
        void a(c cVar);
    }

    public abstract void a(InterfaceC0057a interfaceC0057a);

    public abstract int getIndex();

    protected abstract void register();

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        register();
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
