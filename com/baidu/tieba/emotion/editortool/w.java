package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.editortools.emotiontool.a {
    private static w bLG = new w();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bLH;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized w WP() {
        w wVar;
        synchronized (w.class) {
            wVar = bLG;
        }
        return wVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bLH;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0043a interfaceC0043a) {
        if (this.bLH == null || this.bLH.isEmpty()) {
            this.bLH = new LinkedList<>();
            if (TbFaceManager.DG().Cy() > 0) {
                v vVar = new v();
                this.bLH.add(vVar);
                if (interfaceC0043a != null) {
                    interfaceC0043a.a(vVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bLH.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0043a != null) {
                interfaceC0043a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.bLH == null || this.bLH.size() == 0;
    }
}
