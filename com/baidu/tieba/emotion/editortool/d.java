package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d dqi = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> dqj;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d avw() {
        d dVar;
        synchronized (d.class) {
            dVar = dqi;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.dqj;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0168a interfaceC0168a) {
        if (this.dqj == null || this.dqj.isEmpty()) {
            this.dqj = new LinkedList<>();
            if (TbFaceManager.Nu().Ml() > 0) {
                c cVar = new c();
                this.dqj.add(cVar);
                if (interfaceC0168a != null) {
                    interfaceC0168a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.dqj.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0168a != null) {
                interfaceC0168a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.dqj == null || this.dqj.size() == 0;
    }
}
