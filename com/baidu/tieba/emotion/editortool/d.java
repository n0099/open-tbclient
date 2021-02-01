package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d iGC = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iGD;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cuN() {
        d dVar;
        synchronized (d.class) {
            dVar = iGC;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.iGD;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        if (this.iGD == null || this.iGD.isEmpty()) {
            this.iGD = new LinkedList<>();
            if (TbFaceManager.bCO().bBz() > 0) {
                c cVar = new c();
                this.iGD.add(cVar);
                if (interfaceC0573a != null) {
                    interfaceC0573a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iGD.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0573a != null) {
                interfaceC0573a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.iGD == null || this.iGD.size() == 0;
    }
}
