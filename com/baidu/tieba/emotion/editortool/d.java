package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d gNF = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> gNG;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bNK() {
        d dVar;
        synchronized (d.class) {
            dVar = gNF;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.gNG;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0488a interfaceC0488a) {
        if (this.gNG == null || this.gNG.isEmpty()) {
            this.gNG = new LinkedList<>();
            if (TbFaceManager.bet().bdk() > 0) {
                c cVar = new c();
                this.gNG.add(cVar);
                if (interfaceC0488a != null) {
                    interfaceC0488a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gNG.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0488a != null) {
                interfaceC0488a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.gNG == null || this.gNG.size() == 0;
    }
}
