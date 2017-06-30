package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.editortools.emotiontool.a {
    private static y bSg = new y();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> bSh;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized y aal() {
        y yVar;
        synchronized (y.class) {
            yVar = bSg;
        }
        return yVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.bSh;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0045a interfaceC0045a) {
        if (this.bSh == null || this.bSh.isEmpty()) {
            this.bSh = new LinkedList<>();
            if (TbFaceManager.Ea().CT() > 0) {
                x xVar = new x();
                this.bSh.add(xVar);
                if (interfaceC0045a != null) {
                    interfaceC0045a.a(xVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bSh.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0045a != null) {
                interfaceC0045a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.bSh == null || this.bSh.size() == 0;
    }
}
