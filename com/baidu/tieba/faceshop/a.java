package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.editortool.e {
    private LinkedList<com.baidu.tbadk.editortool.ad> asd;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 3;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(com.baidu.tbadk.editortool.f fVar) {
        if (com.baidu.tbadk.core.util.s.bm() && this.asd != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.asd.size()) {
                    com.baidu.tbadk.editortool.a aVar = (com.baidu.tbadk.editortool.a) this.asd.get(i2);
                    if (aVar.rq() && com.baidu.tbadk.editortool.u.rw().db(aVar.getGroupId()) == null && fVar != null) {
                        fVar.a(aVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public void op() {
        MessageManager.getInstance().registerListener(new b(this, 2001145));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void B(List<com.baidu.tbadk.editortool.x> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                LinkedList<com.baidu.tbadk.editortool.ad> linkedList = new LinkedList<>();
                boolean z = false;
                for (com.baidu.tbadk.editortool.x xVar : list) {
                    if (!TextUtils.isEmpty(xVar.getGroupId()) && xVar.IsValid()) {
                        com.baidu.tbadk.editortool.a aVar = new com.baidu.tbadk.editortool.a(xVar);
                        linkedList.add(aVar);
                        z = z || aVar.a(xVar, new c(this));
                    }
                }
                this.asd = linkedList;
                if (z) {
                    com.baidu.tbadk.editortool.aa.rz().rA();
                }
            }
        }
        if (this.asd != null) {
            this.asd = null;
            com.baidu.tbadk.editortool.aa.rz().rA();
        }
    }
}
