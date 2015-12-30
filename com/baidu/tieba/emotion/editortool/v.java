package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v aTy = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> aTz;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v JK() {
        v vVar;
        synchronized (v.class) {
            vVar = aTy;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.aTz;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0048a interfaceC0048a) {
        if (this.aTz == null || this.aTz.isEmpty()) {
            this.aTz = new LinkedList<>();
            if (TbFaceManager.CL().BA() > 0) {
                u uVar = new u();
                this.aTz.add(uVar);
                if (interfaceC0048a != null) {
                    interfaceC0048a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aTz.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0048a != null) {
                interfaceC0048a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void Bz() {
    }

    public boolean isEmpty() {
        return this.aTz == null || this.aTz.size() == 0;
    }
}
