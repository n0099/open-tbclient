package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d hsZ = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> hta;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cen() {
        d dVar;
        synchronized (d.class) {
            dVar = hsZ;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.hta;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0552a interfaceC0552a) {
        if (this.hta == null || this.hta.isEmpty()) {
            this.hta = new LinkedList<>();
            if (TbFaceManager.bsV().brK() > 0) {
                c cVar = new c();
                this.hta.add(cVar);
                if (interfaceC0552a != null) {
                    interfaceC0552a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.hta.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0552a != null) {
                interfaceC0552a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.hta == null || this.hta.size() == 0;
    }
}
