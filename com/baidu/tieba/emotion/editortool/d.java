package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d cOP = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cOQ;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d anL() {
        d dVar;
        synchronized (d.class) {
            dVar = cOP;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cOQ;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0113a interfaceC0113a) {
        if (this.cOQ == null || this.cOQ.isEmpty()) {
            this.cOQ = new LinkedList<>();
            if (TbFaceManager.IU().HL() > 0) {
                c cVar = new c();
                this.cOQ.add(cVar);
                if (interfaceC0113a != null) {
                    interfaceC0113a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cOQ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0113a != null) {
                interfaceC0113a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.cOQ == null || this.cOQ.size() == 0;
    }
}
