package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d cQU = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cQV;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d aor() {
        d dVar;
        synchronized (d.class) {
            dVar = cQU;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cQV;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0112a interfaceC0112a) {
        if (this.cQV == null || this.cQV.isEmpty()) {
            this.cQV = new LinkedList<>();
            if (TbFaceManager.IC().Ht() > 0) {
                c cVar = new c();
                this.cQV.add(cVar);
                if (interfaceC0112a != null) {
                    interfaceC0112a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cQV.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0112a != null) {
                interfaceC0112a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.cQV == null || this.cQV.size() == 0;
    }
}
