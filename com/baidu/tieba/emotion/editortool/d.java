package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d eVl = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> eVm;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d beY() {
        d dVar;
        synchronized (d.class) {
            dVar = eVl;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.eVm;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0253a interfaceC0253a) {
        if (this.eVm == null || this.eVm.isEmpty()) {
            this.eVm = new LinkedList<>();
            if (TbFaceManager.atx().aso() > 0) {
                c cVar = new c();
                this.eVm.add(cVar);
                if (interfaceC0253a != null) {
                    interfaceC0253a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.eVm.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0253a != null) {
                interfaceC0253a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.eVm == null || this.eVm.size() == 0;
    }
}
