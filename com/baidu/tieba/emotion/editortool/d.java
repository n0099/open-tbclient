package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d dqV = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dqW;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d avU() {
        d dVar;
        synchronized (d.class) {
            dVar = dqV;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dqW;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0168a interfaceC0168a) {
        if (this.dqW == null || this.dqW.isEmpty()) {
            this.dqW = new LinkedList<>();
            if (TbFaceManager.NL().MC() > 0) {
                c cVar = new c();
                this.dqW.add(cVar);
                if (interfaceC0168a != null) {
                    interfaceC0168a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dqW.iterator();
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
        return this.dqW == null || this.dqW.size() == 0;
    }
}
