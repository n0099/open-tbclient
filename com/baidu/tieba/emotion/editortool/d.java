package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eZD = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eZE;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bdw() {
        d dVar;
        synchronized (d.class) {
            dVar = eZD;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eZE;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0294a interfaceC0294a) {
        if (this.eZE == null || this.eZE.isEmpty()) {
            this.eZE = new LinkedList<>();
            if (TbFaceManager.avt().aum() > 0) {
                c cVar = new c();
                this.eZE.add(cVar);
                if (interfaceC0294a != null) {
                    interfaceC0294a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eZE.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0294a != null) {
                interfaceC0294a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.eZE == null || this.eZE.size() == 0;
    }
}
