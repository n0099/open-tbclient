package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d fQD = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> fQE;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bvS() {
        d dVar;
        synchronized (d.class) {
            dVar = fQD;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.fQE;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0379a interfaceC0379a) {
        if (this.fQE == null || this.fQE.isEmpty()) {
            this.fQE = new LinkedList<>();
            if (TbFaceManager.aNr().aMi() > 0) {
                c cVar = new c();
                this.fQE.add(cVar);
                if (interfaceC0379a != null) {
                    interfaceC0379a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fQE.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0379a != null) {
                interfaceC0379a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.fQE == null || this.fQE.size() == 0;
    }
}
