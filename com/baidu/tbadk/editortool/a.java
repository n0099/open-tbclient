package com.baidu.tbadk.editortool;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public final class a extends af {
    private final String a;

    public a(y yVar) {
        this.a = yVar.getGroupId();
        c(1);
        b(4);
    }

    public final boolean a(y yVar, c cVar) {
        if (yVar instanceof AdsEmotionGroupData) {
            aa aaVar = new aa(TbadkApplication.j().b());
            aaVar.a(true);
            aaVar.b(((AdsEmotionGroupData) yVar).getColorCoverUrl(), new b(this, cVar));
            if (b()) {
                cVar.a();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final com.baidu.adp.widget.ImageView.b a() {
        return super.i();
    }

    public final boolean b() {
        return i() != null;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String a(int i) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final boolean a(String str) {
        return false;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final EmotionGroupType c() {
        return EmotionGroupType.PROMOTION;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final com.baidu.adp.widget.ImageView.b b(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final com.baidu.adp.widget.ImageView.b c(String str) {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String e() {
        return this.a;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String f() {
        return null;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int g() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int h() {
        return 0;
    }
}
