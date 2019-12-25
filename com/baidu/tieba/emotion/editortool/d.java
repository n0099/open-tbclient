package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d fNu = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> fNv;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d buQ() {
        d dVar;
        synchronized (d.class) {
            dVar = fNu;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.fNv;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0377a interfaceC0377a) {
        if (this.fNv == null || this.fNv.isEmpty()) {
            this.fNv = new LinkedList<>();
            if (TbFaceManager.aMY().aLP() > 0) {
                c cVar = new c();
                this.fNv.add(cVar);
                if (interfaceC0377a != null) {
                    interfaceC0377a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fNv.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0377a != null) {
                interfaceC0377a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.fNv == null || this.fNv.size() == 0;
    }
}
