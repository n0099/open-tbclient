package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.editortools.emotiontool.a {
    private static w bDt = new w();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bDu;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized w Vq() {
        w wVar;
        synchronized (w.class) {
            wVar = bDt;
        }
        return wVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bDu;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0039a interfaceC0039a) {
        if (this.bDu == null || this.bDu.isEmpty()) {
            this.bDu = new LinkedList<>();
            if (TbFaceManager.EI().DA() > 0) {
                v vVar = new v();
                this.bDu.add(vVar);
                if (interfaceC0039a != null) {
                    interfaceC0039a.a(vVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDu.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0039a != null) {
                interfaceC0039a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.bDu == null || this.bDu.size() == 0;
    }
}
