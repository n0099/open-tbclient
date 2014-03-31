package com.baidu.tieba.faceshop;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class MyEmotionRegister extends com.baidu.tbadk.editortool.e {
    private LinkedList<com.baidu.tbadk.editortool.af> mGroups = new LinkedList<>();

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 2;
    }

    @Override // com.baidu.tbadk.editortool.e
    public List<com.baidu.tbadk.editortool.af> getGroups() {
        return this.mGroups;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void getEmotions(com.baidu.tbadk.editortool.f fVar) {
        if (com.baidu.tbadk.core.util.w.a()) {
            List<MyEmotionGroupData> a = c.a().a(TbadkApplication.E());
            this.mGroups.clear();
            for (MyEmotionGroupData myEmotionGroupData : a) {
                EmotionGroupData a2 = com.baidu.tbadk.editortool.v.a().a(myEmotionGroupData.getGroupId());
                if (a2 != null) {
                    com.baidu.tbadk.editortool.d dVar = new com.baidu.tbadk.editortool.d(a2);
                    if (dVar.i() != null) {
                        this.mGroups.add(dVar);
                        if (fVar != null) {
                            fVar.a(dVar);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public boolean isEmpty() {
        return this.mGroups == null || this.mGroups.size() == 0;
    }

    @Override // com.baidu.tbadk.editortool.e
    protected void register() {
    }
}
