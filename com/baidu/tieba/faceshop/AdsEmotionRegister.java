package com.baidu.tieba.faceshop;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class AdsEmotionRegister extends com.baidu.tbadk.editortool.e {
    private LinkedList<com.baidu.tbadk.editortool.af> mAdsGroups;

    @Override // com.baidu.tbadk.editortool.e
    public int getIndex() {
        return 3;
    }

    @Override // com.baidu.tbadk.editortool.e
    public List<com.baidu.tbadk.editortool.af> getGroups() {
        return this.mAdsGroups;
    }

    @Override // com.baidu.tbadk.editortool.e
    public void getEmotions(com.baidu.tbadk.editortool.f fVar) {
        if (com.baidu.tbadk.core.util.w.a() && this.mAdsGroups != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mAdsGroups.size()) {
                    com.baidu.tbadk.editortool.a aVar = (com.baidu.tbadk.editortool.a) this.mAdsGroups.get(i2);
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
    public void register() {
        com.baidu.adp.framework.c.a().a(new a(this, 2001145));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setNewAdsEmotionGroups(List<com.baidu.tbadk.editortool.y> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                LinkedList<com.baidu.tbadk.editortool.af> linkedList = new LinkedList<>();
                boolean z = false;
                for (com.baidu.tbadk.editortool.y yVar : list) {
                    if (!TextUtils.isEmpty(yVar.getGroupId()) && yVar.IsValid()) {
                        com.baidu.tbadk.editortool.a aVar = new com.baidu.tbadk.editortool.a(yVar);
                        linkedList.add(aVar);
                        z = z || aVar.a(yVar, new b(this));
                    }
                }
                this.mAdsGroups = linkedList;
                if (z) {
                    com.baidu.tbadk.editortool.ab.a().b();
                }
            }
        }
        if (this.mAdsGroups != null) {
            this.mAdsGroups = null;
            com.baidu.tbadk.editortool.ab.a().b();
        }
    }

    @Override // com.baidu.tbadk.editortool.e
    public boolean isEmpty() {
        return this.mAdsGroups == null || this.mAdsGroups.size() == 0;
    }
}
