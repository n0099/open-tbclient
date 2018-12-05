package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d dnq = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dnr;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d auH() {
        d dVar;
        synchronized (d.class) {
            dVar = dnq;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dnr;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0168a interfaceC0168a) {
        if (this.dnr == null || this.dnr.isEmpty()) {
            this.dnr = new LinkedList<>();
            if (TbFaceManager.Nt().Mk() > 0) {
                c cVar = new c();
                this.dnr.add(cVar);
                if (interfaceC0168a != null) {
                    interfaceC0168a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dnr.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0168a != null) {
                interfaceC0168a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.dnr == null || this.dnr.size() == 0;
    }
}
