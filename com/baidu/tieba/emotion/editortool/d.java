package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eAS = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eAT;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d aVL() {
        d dVar;
        synchronized (d.class) {
            dVar = eAS;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eAT;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0202a interfaceC0202a) {
        if (this.eAT == null || this.eAT.isEmpty()) {
            this.eAT = new LinkedList<>();
            if (TbFaceManager.anp().amh() > 0) {
                c cVar = new c();
                this.eAT.add(cVar);
                if (interfaceC0202a != null) {
                    interfaceC0202a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eAT.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0202a != null) {
                interfaceC0202a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.eAT == null || this.eAT.size() == 0;
    }
}
