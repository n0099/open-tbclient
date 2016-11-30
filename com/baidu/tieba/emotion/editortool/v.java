package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v bIE = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bIF;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v Yn() {
        v vVar;
        synchronized (v.class) {
            vVar = bIE;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bIF;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0041a interfaceC0041a) {
        if (this.bIF == null || this.bIF.isEmpty()) {
            this.bIF = new LinkedList<>();
            if (TbFaceManager.Eo().Dg() > 0) {
                u uVar = new u();
                this.bIF.add(uVar);
                if (interfaceC0041a != null) {
                    interfaceC0041a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bIF.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0041a != null) {
                interfaceC0041a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void Df() {
    }

    public boolean isEmpty() {
        return this.bIF == null || this.bIF.size() == 0;
    }
}
