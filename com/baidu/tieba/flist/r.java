package com.baidu.tieba.flist;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class r extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1053a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, int i) {
        this.f1053a = pVar;
        this.b = i;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ForumListModel.Forum[] forumArr;
        com.baidu.tieba.g gVar;
        ForumListModel.Forum[] forumArr2;
        aq aqVar;
        aq aqVar2;
        com.baidu.tieba.g gVar2;
        com.baidu.tieba.g gVar3;
        ForumListModel.Forum[] forumArr3;
        com.baidu.tieba.g gVar4;
        com.baidu.tieba.g gVar5;
        ForumListModel.Forum[] forumArr4;
        com.baidu.tieba.g gVar6;
        aq aqVar3;
        ForumListModel.Forum[] forumArr5;
        com.baidu.tieba.g gVar7;
        com.baidu.tieba.g gVar8;
        forumArr = this.f1053a.h;
        if (forumArr != null) {
            forumArr2 = this.f1053a.h;
            if (forumArr2[this.b] != null) {
                aqVar = this.f1053a.f;
                if (aqVar.getErrorCode() != 22) {
                    aqVar2 = this.f1053a.f;
                    if (aqVar2.getErrorCode() != 0) {
                        gVar6 = this.f1053a.b;
                        aqVar3 = this.f1053a.f;
                        gVar6.a(aqVar3.getErrorString());
                    } else if (((ag) obj) == null) {
                        gVar2 = this.f1053a.b;
                        gVar3 = this.f1053a.b;
                        gVar2.a(gVar3.getString(R.string.neterror));
                    } else {
                        forumArr3 = this.f1053a.h;
                        forumArr3[this.b].is_like = 1;
                        gVar4 = this.f1053a.b;
                        gVar5 = this.f1053a.b;
                        gVar4.a(gVar5.getString(R.string.like_success));
                        this.f1053a.notifyDataSetChanged();
                        TiebaApplication g = TiebaApplication.g();
                        forumArr4 = this.f1053a.h;
                        g.e(forumArr4[this.b].forum_name);
                    }
                } else {
                    forumArr5 = this.f1053a.h;
                    forumArr5[this.b].is_like = 1;
                    gVar7 = this.f1053a.b;
                    gVar8 = this.f1053a.b;
                    gVar7.a(gVar8.getString(R.string.like_success));
                    this.f1053a.notifyDataSetChanged();
                }
            }
        }
        gVar = this.f1053a.b;
        gVar.findViewById(R.id.loading).setVisibility(4);
    }
}
