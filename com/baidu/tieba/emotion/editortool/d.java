package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d iGQ = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iGR;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cuU() {
        d dVar;
        synchronized (d.class) {
            dVar = iGQ;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.iGR;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        if (this.iGR == null || this.iGR.isEmpty()) {
            this.iGR = new LinkedList<>();
            if (TbFaceManager.bCO().bBz() > 0) {
                c cVar = new c();
                this.iGR.add(cVar);
                if (interfaceC0573a != null) {
                    interfaceC0573a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iGR.iterator();
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
        return this.iGR == null || this.iGR.size() == 0;
    }
}
