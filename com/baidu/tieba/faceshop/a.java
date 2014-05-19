package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.editortool.e {
    private LinkedList<com.baidu.tbadk.editortool.ag> a;

    @Override // com.baidu.tbadk.editortool.e
    public int a() {
        return 3;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(com.baidu.tbadk.editortool.f fVar) {
        if (com.baidu.tbadk.core.util.x.a() && this.a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.a.size()) {
                    com.baidu.tbadk.editortool.a aVar = (com.baidu.tbadk.editortool.a) this.a.get(i2);
                    if (aVar.b() && com.baidu.tbadk.editortool.v.a().a(aVar.e()) == null && fVar != null) {
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
    public void b() {
        MessageManager.getInstance().registerListener(new b(this, MessageTypes.CMD_ADS_EMOTION));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<com.baidu.tbadk.editortool.y> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                LinkedList<com.baidu.tbadk.editortool.ag> linkedList = new LinkedList<>();
                boolean z = false;
                for (com.baidu.tbadk.editortool.y yVar : list) {
                    if (!TextUtils.isEmpty(yVar.getGroupId()) && yVar.IsValid()) {
                        com.baidu.tbadk.editortool.a aVar = new com.baidu.tbadk.editortool.a(yVar);
                        linkedList.add(aVar);
                        z = z || aVar.a(yVar, new c(this));
                    }
                }
                this.a = linkedList;
                if (z) {
                    com.baidu.tbadk.editortool.ac.a().b();
                }
            }
        }
        if (this.a != null) {
            this.a = null;
            com.baidu.tbadk.editortool.ac.a().b();
        }
    }
}
