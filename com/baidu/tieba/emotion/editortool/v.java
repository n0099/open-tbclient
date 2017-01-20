package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v bwu = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bwv;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v TU() {
        v vVar;
        synchronized (v.class) {
            vVar = bwu;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bwv;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0041a interfaceC0041a) {
        if (this.bwv == null || this.bwv.isEmpty()) {
            this.bwv = new LinkedList<>();
            if (TbFaceManager.DR().CK() > 0) {
                u uVar = new u();
                this.bwv.add(uVar);
                if (interfaceC0041a != null) {
                    interfaceC0041a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bwv.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0041a != null) {
                interfaceC0041a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void CJ() {
    }

    public boolean isEmpty() {
        return this.bwv == null || this.bwv.size() == 0;
    }
}
