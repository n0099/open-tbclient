package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d fTn = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> fTo;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bxz() {
        d dVar;
        synchronized (d.class) {
            dVar = fTn;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.fTo;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0389a interfaceC0389a) {
        if (this.fTo == null || this.fTo.isEmpty()) {
            this.fTo = new LinkedList<>();
            if (TbFaceManager.aPQ().aOH() > 0) {
                c cVar = new c();
                this.fTo.add(cVar);
                if (interfaceC0389a != null) {
                    interfaceC0389a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fTo.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0389a != null) {
                interfaceC0389a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.fTo == null || this.fTo.size() == 0;
    }
}
