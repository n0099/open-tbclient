package com.baidu.tieba.flist;

import com.baidu.tieba.data.ac;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class h extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f819a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, int i) {
        this.f819a = fVar;
        this.b = i;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ForumListModel.Forum[] forumArr;
        ForumListActivity forumListActivity;
        ForumListModel.Forum[] forumArr2;
        ForumListActivity forumListActivity2;
        aj ajVar;
        ForumListActivity forumListActivity3;
        aj ajVar2;
        ForumListModel.Forum[] forumArr3;
        ForumListActivity forumListActivity4;
        ForumListActivity forumListActivity5;
        ForumListActivity forumListActivity6;
        ForumListActivity forumListActivity7;
        aj ajVar3;
        ForumListModel.Forum[] forumArr4;
        ForumListActivity forumListActivity8;
        ForumListActivity forumListActivity9;
        forumArr = this.f819a.c;
        if (forumArr != null) {
            forumArr2 = this.f819a.c;
            if (forumArr2[this.b] != null) {
                forumListActivity2 = this.f819a.f817a;
                ajVar = forumListActivity2.m;
                if (ajVar.getErrorCode() != 22) {
                    forumListActivity3 = this.f819a.f817a;
                    ajVar2 = forumListActivity3.m;
                    if (ajVar2.getErrorCode() != 0) {
                        forumListActivity6 = this.f819a.f817a;
                        forumListActivity7 = this.f819a.f817a;
                        ajVar3 = forumListActivity7.m;
                        forumListActivity6.a(ajVar3.getErrorString());
                    } else if (((ac) obj).b() == 1) {
                        forumArr3 = this.f819a.c;
                        forumArr3[this.b].is_like = 1;
                        forumListActivity4 = this.f819a.f817a;
                        forumListActivity5 = this.f819a.f817a;
                        forumListActivity4.a(forumListActivity5.getString(R.string.like_success));
                        this.f819a.notifyDataSetChanged();
                    }
                } else {
                    forumArr4 = this.f819a.c;
                    forumArr4[this.b].is_like = 1;
                    forumListActivity8 = this.f819a.f817a;
                    forumListActivity9 = this.f819a.f817a;
                    forumListActivity8.a(forumListActivity9.getString(R.string.like_success));
                    this.f819a.notifyDataSetChanged();
                }
            }
        }
        forumListActivity = this.f819a.f817a;
        forumListActivity.findViewById(R.id.loading).setVisibility(4);
    }
}
