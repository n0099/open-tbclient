package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eWR = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eWS;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bfC() {
        d dVar;
        synchronized (d.class) {
            dVar = eWR;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eWS;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0262a interfaceC0262a) {
        if (this.eWS == null || this.eWS.isEmpty()) {
            this.eWS = new LinkedList<>();
            if (TbFaceManager.atJ().asA() > 0) {
                c cVar = new c();
                this.eWS.add(cVar);
                if (interfaceC0262a != null) {
                    interfaceC0262a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eWS.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0262a != null) {
                interfaceC0262a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.eWS == null || this.eWS.size() == 0;
    }
}
