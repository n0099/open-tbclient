package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class bu extends com.baidu.tbadk.editortool.e {
    private LinkedList<com.baidu.tbadk.editortool.ad> Sr = new LinkedList<>();

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 2;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void a(com.baidu.tbadk.editortool.f fVar) {
        if (com.baidu.tbadk.core.util.s.bm()) {
            List<MyEmotionGroupData> eJ = d.CI().eJ(TbadkApplication.getCurrentAccount());
            this.Sr.clear();
            for (MyEmotionGroupData myEmotionGroupData : eJ) {
                EmotionGroupData db = com.baidu.tbadk.editortool.u.ry().db(myEmotionGroupData.getGroupId());
                if (db != null) {
                    com.baidu.tbadk.editortool.d dVar = new com.baidu.tbadk.editortool.d(db);
                    if (dVar.rR() != null) {
                        this.Sr.add(dVar);
                        if (fVar != null) {
                            fVar.a(dVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    protected void op() {
    }
}
