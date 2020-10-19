package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d hPf = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> hPg;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d ckZ() {
        d dVar;
        synchronized (d.class) {
            dVar = hPf;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.hPg;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0564a interfaceC0564a) {
        if (this.hPg == null || this.hPg.isEmpty()) {
            this.hPg = new LinkedList<>();
            if (TbFaceManager.bwK().bvx() > 0) {
                c cVar = new c();
                this.hPg.add(cVar);
                if (interfaceC0564a != null) {
                    interfaceC0564a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hPg.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0564a != null) {
                interfaceC0564a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.hPg == null || this.hPg.size() == 0;
    }
}
