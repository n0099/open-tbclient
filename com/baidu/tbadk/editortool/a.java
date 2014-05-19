package com.baidu.tbadk.editortool;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public class a extends ag {
    private final String a;

    public a(y yVar) {
        this.a = yVar.getGroupId();
        c(1);
        b(4);
    }

    public boolean a(y yVar, c cVar) {
        if (yVar instanceof AdsEmotionGroupData) {
            ab abVar = new ab(TbadkApplication.m252getInst().getApp());
            abVar.d(true);
            abVar.b(((AdsEmotionGroupData) yVar).getColorCoverUrl(), new b(this, cVar));
            if (b()) {
                cVar.a(this);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public com.baidu.adp.widget.a.a a() {
        return super.i();
    }

    public boolean b() {
        return i() != null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public String a(int i) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public boolean a(String str) {
        return false;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public EmotionGroupType c() {
        return EmotionGroupType.PROMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public com.baidu.adp.widget.a.a b(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public com.baidu.adp.widget.a.a c(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public String e() {
        return this.a;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public String f() {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public int g() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public int h() {
        return 0;
    }
}
