package com.baidu.tbadk.editortool;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class a extends ae {
    private final String a;

    public a(x xVar) {
        this.a = xVar.getGroupId();
        c(1);
        b(4);
    }

    public boolean a(x xVar, c cVar) {
        if (xVar instanceof AdsEmotionGroupData) {
            aa aaVar = new aa(TbadkApplication.m252getInst().getApp());
            aaVar.b(true);
            aaVar.b(((AdsEmotionGroupData) xVar).getColorCoverUrl(), new b(this, cVar));
            if (b()) {
                cVar.a(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a a() {
        return super.j();
    }

    public boolean b() {
        return j() != null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String a(int i) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean a(String str) {
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType c() {
        return EmotionGroupType.PROMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a b(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a c(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String e() {
        return this.a;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String f() {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int g() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int h() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean i() {
        return false;
    }
}
