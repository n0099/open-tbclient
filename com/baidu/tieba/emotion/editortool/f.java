package com.baidu.tieba.emotion.editortool;

import com.baidu.tbadk.editortools.emotiontool.a;
import com.baidu.tbadk.imageManager.TbFaceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.editortools.emotiontool.a {
    private static f ccb = new f();
    private LinkedList<com.baidu.tbadk.editortools.emotiontool.c> ccc;

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public int getIndex() {
        return 1;
    }

    public static synchronized f acI() {
        f fVar;
        synchronized (f.class) {
            fVar = ccb;
        }
        return fVar;
    }

    public List<com.baidu.tbadk.editortools.emotiontool.c> getGroups() {
        return this.ccc;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void a(a.InterfaceC0056a interfaceC0056a) {
        if (this.ccc == null || this.ccc.isEmpty()) {
            this.ccc = new LinkedList<>();
            if (TbFaceManager.Eu().Di() > 0) {
                e eVar = new e();
                this.ccc.add(eVar);
                if (interfaceC0056a != null) {
                    interfaceC0056a.a(eVar);
                    return;
                }
                return;
            }
            return;
        }
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.ccc.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (interfaceC0056a != null) {
                interfaceC0056a.a(next);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.a
    public void register() {
    }

    public boolean isEmpty() {
        return this.ccc == null || this.ccc.size() == 0;
    }
}
