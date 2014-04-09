package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class ca extends com.baidu.tbadk.editortool.e {
    private LinkedList<com.baidu.tbadk.editortool.ag> a = new LinkedList<>();

    @Override // com.baidu.tbadk.editortool.e
    public final int a() {
        return 2;
    }

    @Override // com.baidu.tbadk.editortool.e
    public final void a(com.baidu.tbadk.editortool.f fVar) {
        if (com.baidu.tbadk.core.util.w.a()) {
            List<MyEmotionGroupData> a = d.a().a(TbadkApplication.E());
            this.a.clear();
            for (MyEmotionGroupData myEmotionGroupData : a) {
                EmotionGroupData a2 = com.baidu.tbadk.editortool.v.a().a(myEmotionGroupData.getGroupId());
                if (a2 != null) {
                    com.baidu.tbadk.editortool.d dVar = new com.baidu.tbadk.editortool.d(a2);
                    if (dVar.i() != null) {
                        this.a.add(dVar);
                        if (fVar != null) {
                            fVar.a(dVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    protected final void b() {
    }
}
