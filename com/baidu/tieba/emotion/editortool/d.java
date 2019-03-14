package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eAO = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eAP;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d aVL() {
        d dVar;
        synchronized (d.class) {
            dVar = eAO;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eAP;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0236a interfaceC0236a) {
        if (this.eAP == null || this.eAP.isEmpty()) {
            this.eAP = new LinkedList<>();
            if (TbFaceManager.ano().amg() > 0) {
                c cVar = new c();
                this.eAP.add(cVar);
                if (interfaceC0236a != null) {
                    interfaceC0236a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAP.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0236a != null) {
                interfaceC0236a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.eAP == null || this.eAP.size() == 0;
    }
}
