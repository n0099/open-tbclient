package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v aWq = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> aWr;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v LV() {
        v vVar;
        synchronized (v.class) {
            vVar = aWq;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.aWr;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0040a interfaceC0040a) {
        if (this.aWr == null || this.aWr.isEmpty()) {
            this.aWr = new LinkedList<>();
            if (TbFaceManager.CG().Bt() > 0) {
                u uVar = new u();
                this.aWr.add(uVar);
                if (interfaceC0040a != null) {
                    interfaceC0040a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aWr.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0040a != null) {
                interfaceC0040a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void Bs() {
    }

    public boolean isEmpty() {
        return this.aWr == null || this.aWr.size() == 0;
    }
}
