package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.editortools.emotiontool.a {
    private static v boH = new v();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> boI;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized v Sy() {
        v vVar;
        synchronized (v.class) {
            vVar = boH;
        }
        return vVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.boI;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0041a interfaceC0041a) {
        if (this.boI == null || this.boI.isEmpty()) {
            this.boI = new LinkedList<>();
            if (TbFaceManager.DW().CP() > 0) {
                u uVar = new u();
                this.boI.add(uVar);
                if (interfaceC0041a != null) {
                    interfaceC0041a.a(uVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.boI.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0041a != null) {
                interfaceC0041a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void CO() {
    }

    public boolean isEmpty() {
        return this.boI == null || this.boI.size() == 0;
    }
}
