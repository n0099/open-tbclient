package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d fTa = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> fTb;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bxy() {
        d dVar;
        synchronized (d.class) {
            dVar = fTa;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.fTb;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0389a interfaceC0389a) {
        if (this.fTb == null || this.fTb.isEmpty()) {
            this.fTb = new LinkedList<>();
            if (TbFaceManager.aPP().aOG() > 0) {
                c cVar = new c();
                this.fTb.add(cVar);
                if (interfaceC0389a != null) {
                    interfaceC0389a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.fTb.iterator();
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
        return this.fTb == null || this.fTb.size() == 0;
    }
}
