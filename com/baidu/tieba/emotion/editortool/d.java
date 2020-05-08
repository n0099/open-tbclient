package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d gyK = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> gyL;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bHo() {
        d dVar;
        synchronized (d.class) {
            dVar = gyK;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.gyL;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0441a interfaceC0441a) {
        if (this.gyL == null || this.gyL.isEmpty()) {
            this.gyL = new LinkedList<>();
            if (TbFaceManager.aYj().aXa() > 0) {
                c cVar = new c();
                this.gyL.add(cVar);
                if (interfaceC0441a != null) {
                    interfaceC0441a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gyL.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0441a != null) {
                interfaceC0441a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.gyL == null || this.gyL.size() == 0;
    }
}
