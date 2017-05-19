package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.editortools.emotiontool.a {
    private static w bFR = new w();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bFS;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized w VM() {
        w wVar;
        synchronized (w.class) {
            wVar = bFR;
        }
        return wVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bFS;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0043a interfaceC0043a) {
        if (this.bFS == null || this.bFS.isEmpty()) {
            this.bFS = new LinkedList<>();
            if (TbFaceManager.DM().CE() > 0) {
                v vVar = new v();
                this.bFS.add(vVar);
                if (interfaceC0043a != null) {
                    interfaceC0043a.a(vVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFS.iterator();
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
        return this.bFS == null || this.bFS.size() == 0;
    }
}
