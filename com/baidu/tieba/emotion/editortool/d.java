package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d gyE = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> gyF;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d bHq() {
        d dVar;
        synchronized (d.class) {
            dVar = gyE;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.gyF;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0420a interfaceC0420a) {
        if (this.gyF == null || this.gyF.isEmpty()) {
            this.gyF = new LinkedList<>();
            if (TbFaceManager.aYl().aXc() > 0) {
                c cVar = new c();
                this.gyF.add(cVar);
                if (interfaceC0420a != null) {
                    interfaceC0420a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.gyF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0420a != null) {
                interfaceC0420a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.gyF == null || this.gyF.size() == 0;
    }
}
