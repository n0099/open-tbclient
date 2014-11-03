package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class a extends ad {
    private final String groupId;

    public a(x xVar) {
        this.groupId = xVar.getGroupId();
        cK(1);
        cJ(4);
    }

    public boolean a(x xVar, c cVar) {
        if (xVar instanceof AdsEmotionGroupData) {
            com.baidu.adp.lib.f.d.ef().a(((AdsEmotionGroupData) xVar).getColorCoverUrl(), 10, new b(this, cVar), null);
            if (rs()) {
                cVar.a(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a rr() {
        return super.rR();
    }

    public boolean rs() {
        return rR() != null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String cG(int i) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean cY(String str) {
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public EmotionGroupType rt() {
        return EmotionGroupType.PROMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a cZ(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a da(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getEmotionsCount() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String getGroupName() {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean ru() {
        return false;
    }
}
