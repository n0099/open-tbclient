package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d cRv = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cRw;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d aok() {
        d dVar;
        synchronized (d.class) {
            dVar = cRv;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cRw;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0110a interfaceC0110a) {
        if (this.cRw == null || this.cRw.isEmpty()) {
            this.cRw = new LinkedList<>();
            if (TbFaceManager.IP().HG() > 0) {
                c cVar = new c();
                this.cRw.add(cVar);
                if (interfaceC0110a != null) {
                    interfaceC0110a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cRw.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0110a != null) {
                interfaceC0110a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.cRw == null || this.cRw.size() == 0;
    }
}
