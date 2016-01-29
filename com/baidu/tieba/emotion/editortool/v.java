package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v aVE = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> aVF;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v Ly() {
        v vVar;
        synchronized (v.class) {
            vVar = aVE;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.aVF;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0049a interfaceC0049a) {
        if (this.aVF == null || this.aVF.isEmpty()) {
            this.aVF = new LinkedList<>();
            if (TbFaceManager.Ec().CR() > 0) {
                u uVar = new u();
                this.aVF.add(uVar);
                if (interfaceC0049a != null) {
                    interfaceC0049a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aVF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0049a != null) {
                interfaceC0049a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void CQ() {
    }

    public boolean isEmpty() {
        return this.aVF == null || this.aVF.size() == 0;
    }
}
