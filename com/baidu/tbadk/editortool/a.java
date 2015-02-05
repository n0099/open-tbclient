package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class a extends ae {
    private final String groupId;

    public a(x xVar) {
        this.groupId = xVar.getGroupId();
        dq(1);
        dp(4);
    }

    public boolean a(x xVar, c cVar) {
        if (xVar instanceof AdsEmotionGroupData) {
            com.baidu.adp.lib.f.d.ec().a(((AdsEmotionGroupData) xVar).getColorCoverUrl(), 10, new b(this, cVar), null);
            if (isReady()) {
                cVar.a(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a ve() {
        return super.vE();
    }

    public boolean isReady() {
        return vE() != null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String dl(int i) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean dR(String str) {
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType vf() {
        return EmotionGroupType.PROMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dS(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dT(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getEmotionsCount() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String getGroupName() {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean vg() {
        return false;
    }
}
