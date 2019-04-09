package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eAA = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eAB;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d aVJ() {
        d dVar;
        synchronized (d.class) {
            dVar = eAA;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eAB;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0236a interfaceC0236a) {
        if (this.eAB == null || this.eAB.isEmpty()) {
            this.eAB = new LinkedList<>();
            if (TbFaceManager.anl().amd() > 0) {
                c cVar = new c();
                this.eAB.add(cVar);
                if (interfaceC0236a != null) {
                    interfaceC0236a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAB.iterator();
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
        return this.eAB == null || this.eAB.size() == 0;
    }
}
