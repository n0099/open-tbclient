package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d fTW = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> fTX;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bxE() {
        d dVar;
        synchronized (d.class) {
            dVar = fTW;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.fTX;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0389a interfaceC0389a) {
        if (this.fTX == null || this.fTX.isEmpty()) {
            this.fTX = new LinkedList<>();
            if (TbFaceManager.aPU().aOL() > 0) {
                c cVar = new c();
                this.fTX.add(cVar);
                if (interfaceC0389a != null) {
                    interfaceC0389a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fTX.iterator();
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
        return this.fTX == null || this.fTX.size() == 0;
    }
}
