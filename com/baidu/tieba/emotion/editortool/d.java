package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d dfE = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dfF;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d atw() {
        d dVar;
        synchronized (d.class) {
            dVar = dfE;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dfF;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0134a interfaceC0134a) {
        if (this.dfF == null || this.dfF.isEmpty()) {
            this.dfF = new LinkedList<>();
            if (TbFaceManager.Md().KU() > 0) {
                c cVar = new c();
                this.dfF.add(cVar);
                if (interfaceC0134a != null) {
                    interfaceC0134a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dfF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0134a != null) {
                interfaceC0134a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.dfF == null || this.dfF.size() == 0;
    }
}
