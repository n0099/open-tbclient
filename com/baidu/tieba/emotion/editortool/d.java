package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d ihD = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> ihE;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cqH() {
        d dVar;
        synchronized (d.class) {
            dVar = ihD;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.ihE;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0590a interfaceC0590a) {
        if (this.ihE == null || this.ihE.isEmpty()) {
            this.ihE = new LinkedList<>();
            if (TbFaceManager.bBc().bzP() > 0) {
                c cVar = new c();
                this.ihE.add(cVar);
                if (interfaceC0590a != null) {
                    interfaceC0590a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ihE.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0590a != null) {
                interfaceC0590a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.ihE == null || this.ihE.size() == 0;
    }
}
