package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v aPG = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> aPH;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v Jt() {
        v vVar;
        synchronized (v.class) {
            vVar = aPG;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.aPH;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0048a interfaceC0048a) {
        if (this.aPH == null || this.aPH.isEmpty()) {
            this.aPH = new LinkedList<>();
            if (TbFaceManager.CW().BL() > 0) {
                u uVar = new u();
                this.aPH.add(uVar);
                if (interfaceC0048a != null) {
                    interfaceC0048a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.aPH.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0048a != null) {
                interfaceC0048a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void BK() {
    }

    public boolean isEmpty() {
        return this.aPH == null || this.aPH.size() == 0;
    }
}
