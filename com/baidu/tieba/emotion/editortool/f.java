package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f doL = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> doM;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f aqd() {
        f fVar;
        synchronized (f.class) {
            fVar = doL;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.doM;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0105a interfaceC0105a) {
        if (this.doM == null || this.doM.isEmpty()) {
            this.doM = new LinkedList<>();
            if (TbFaceManager.Mw().Lp() > 0) {
                e eVar = new e();
                this.doM.add(eVar);
                if (interfaceC0105a != null) {
                    interfaceC0105a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.doM.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0105a != null) {
                interfaceC0105a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.doM == null || this.doM.size() == 0;
    }
}
