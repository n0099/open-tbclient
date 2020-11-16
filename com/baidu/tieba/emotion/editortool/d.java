package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class d extends com.baidu.tbadk.editortools.emotiontool.a {
    private static d iir = new d();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> iis;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized d cqk() {
        d dVar;
        synchronized (d.class) {
            dVar = iir;
        }
        return dVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.iis;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0589a interfaceC0589a) {
        if (this.iis == null || this.iis.isEmpty()) {
            this.iis = new LinkedList<>();
            if (TbFaceManager.bAs().bzf() > 0) {
                c cVar = new c();
                this.iis.add(cVar);
                if (interfaceC0589a != null) {
                    interfaceC0589a.a(cVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.iis.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0589a != null) {
                interfaceC0589a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.iis == null || this.iis.size() == 0;
    }
}
