package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d fSY = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> fSZ;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bxw() {
        d dVar;
        synchronized (d.class) {
            dVar = fSY;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.fSZ;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0389a interfaceC0389a) {
        if (this.fSZ == null || this.fSZ.isEmpty()) {
            this.fSZ = new LinkedList<>();
            if (TbFaceManager.aPN().aOE() > 0) {
                c cVar = new c();
                this.fSZ.add(cVar);
                if (interfaceC0389a != null) {
                    interfaceC0389a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fSZ.iterator();
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
        return this.fSZ == null || this.fSZ.size() == 0;
    }
}
