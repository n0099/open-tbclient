package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eAz = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eAA;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d aVJ() {
        d dVar;
        synchronized (d.class) {
            dVar = eAz;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eAA;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0236a interfaceC0236a) {
        if (this.eAA == null || this.eAA.isEmpty()) {
            this.eAA = new LinkedList<>();
            if (TbFaceManager.anl().amd() > 0) {
                c cVar = new c();
                this.eAA.add(cVar);
                if (interfaceC0236a != null) {
                    interfaceC0236a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAA.iterator();
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
        return this.eAA == null || this.eAA.size() == 0;
    }
}
