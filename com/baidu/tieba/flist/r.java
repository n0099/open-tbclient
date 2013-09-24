package com.baidu.tieba.flist;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.as;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class r extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1070a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, int i) {
        this.f1070a = pVar;
        this.b = i;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ForumListModel.Forum[] forumArr;
        com.baidu.tieba.j jVar;
        ForumListModel.Forum[] forumArr2;
        as asVar;
        as asVar2;
        com.baidu.tieba.j jVar2;
        com.baidu.tieba.j jVar3;
        ForumListModel.Forum[] forumArr3;
        com.baidu.tieba.j jVar4;
        com.baidu.tieba.j jVar5;
        ForumListModel.Forum[] forumArr4;
        com.baidu.tieba.j jVar6;
        as asVar3;
        ForumListModel.Forum[] forumArr5;
        com.baidu.tieba.j jVar7;
        com.baidu.tieba.j jVar8;
        forumArr = this.f1070a.j;
        if (forumArr != null) {
            forumArr2 = this.f1070a.j;
            if (forumArr2[this.b] != null) {
                asVar = this.f1070a.f;
                if (asVar.getErrorCode() != 22) {
                    asVar2 = this.f1070a.f;
                    if (asVar2.getErrorCode() != 0) {
                        jVar6 = this.f1070a.b;
                        asVar3 = this.f1070a.f;
                        jVar6.a(asVar3.getErrorString());
                    } else if (((ag) obj) == null) {
                        jVar2 = this.f1070a.b;
                        jVar3 = this.f1070a.b;
                        jVar2.a(jVar3.getString(R.string.neterror));
                    } else {
                        forumArr3 = this.f1070a.j;
                        forumArr3[this.b].is_like = 1;
                        jVar4 = this.f1070a.b;
                        jVar5 = this.f1070a.b;
                        jVar4.a(jVar5.getString(R.string.like_success));
                        this.f1070a.notifyDataSetChanged();
                        TiebaApplication g = TiebaApplication.g();
                        forumArr4 = this.f1070a.j;
                        g.e(forumArr4[this.b].forum_name);
                    }
                } else {
                    forumArr5 = this.f1070a.j;
                    forumArr5[this.b].is_like = 1;
                    jVar7 = this.f1070a.b;
                    jVar8 = this.f1070a.b;
                    jVar7.a(jVar8.getString(R.string.like_success));
                    this.f1070a.notifyDataSetChanged();
                }
            }
        }
        jVar = this.f1070a.b;
        jVar.findViewById(R.id.loading).setVisibility(4);
    }
}
