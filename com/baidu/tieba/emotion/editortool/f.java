package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f cbj = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> cbk;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f acx() {
        f fVar;
        synchronized (f.class) {
            fVar = cbj;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.cbk;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0057a interfaceC0057a) {
        if (this.cbk == null || this.cbk.isEmpty()) {
            this.cbk = new LinkedList<>();
            if (TbFaceManager.Eu().Di() > 0) {
                e eVar = new e();
                this.cbk.add(eVar);
                if (interfaceC0057a != null) {
                    interfaceC0057a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.cbk.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0057a != null) {
                interfaceC0057a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.cbk == null || this.cbk.size() == 0;
    }
}
