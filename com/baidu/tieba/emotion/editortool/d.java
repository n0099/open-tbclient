package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d haB = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> haC;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bQP() {
        d dVar;
        synchronized (d.class) {
            dVar = haB;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.haC;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0494a interfaceC0494a) {
        if (this.haC == null || this.haC.isEmpty()) {
            this.haC = new LinkedList<>();
            if (TbFaceManager.bgy().bfo() > 0) {
                c cVar = new c();
                this.haC.add(cVar);
                if (interfaceC0494a != null) {
                    interfaceC0494a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.haC.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0494a != null) {
                interfaceC0494a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.haC == null || this.haC.size() == 0;
    }
}
