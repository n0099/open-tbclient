package com.baidu.tieba.flist;

import com.baidu.tieba.data.ak;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.ar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class g extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1041a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i) {
        this.f1041a = eVar;
        this.b = i;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ForumListModel.Forum[] forumArr;
        ForumListActivity forumListActivity;
        ForumListModel.Forum[] forumArr2;
        ForumListActivity forumListActivity2;
        ar arVar;
        ForumListActivity forumListActivity3;
        ar arVar2;
        ForumListModel.Forum[] forumArr3;
        ForumListActivity forumListActivity4;
        ForumListActivity forumListActivity5;
        ForumListActivity forumListActivity6;
        ForumListActivity forumListActivity7;
        ar arVar3;
        ForumListModel.Forum[] forumArr4;
        ForumListActivity forumListActivity8;
        ForumListActivity forumListActivity9;
        forumArr = this.f1041a.c;
        if (forumArr != null) {
            forumArr2 = this.f1041a.c;
            if (forumArr2[this.b] != null) {
                forumListActivity2 = this.f1041a.f1039a;
                arVar = forumListActivity2.m;
                if (arVar.getErrorCode() != 22) {
                    forumListActivity3 = this.f1041a.f1039a;
                    arVar2 = forumListActivity3.m;
                    if (arVar2.getErrorCode() != 0) {
                        forumListActivity6 = this.f1041a.f1039a;
                        forumListActivity7 = this.f1041a.f1039a;
                        arVar3 = forumListActivity7.m;
                        forumListActivity6.a(arVar3.getErrorString());
                    } else if (((ak) obj).b() == 1) {
                        forumArr3 = this.f1041a.c;
                        forumArr3[this.b].is_like = 1;
                        forumListActivity4 = this.f1041a.f1039a;
                        forumListActivity5 = this.f1041a.f1039a;
                        forumListActivity4.a(forumListActivity5.getString(R.string.like_success));
                        this.f1041a.notifyDataSetChanged();
                    }
                } else {
                    forumArr4 = this.f1041a.c;
                    forumArr4[this.b].is_like = 1;
                    forumListActivity8 = this.f1041a.f1039a;
                    forumListActivity9 = this.f1041a.f1039a;
                    forumListActivity8.a(forumListActivity9.getString(R.string.like_success));
                    this.f1041a.notifyDataSetChanged();
                }
            }
        }
        forumListActivity = this.f1041a.f1039a;
        forumListActivity.findViewById(R.id.loading).setVisibility(4);
    }
}
