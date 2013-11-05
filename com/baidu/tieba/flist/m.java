package com.baidu.tieba.flist;

import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.ba;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListModel.Forum[] f1197a;
    final /* synthetic */ ForumListActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumListActivity forumListActivity, ForumListModel.Forum[] forumArr) {
        this.b = forumListActivity;
        this.f1197a = forumArr;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ba baVar;
        int i;
        int i2;
        q qVar;
        q qVar2;
        q qVar3;
        q qVar4;
        ba baVar2;
        if (obj != null) {
            baVar = this.b.r;
            if (baVar.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.b;
                baVar2 = this.b.r;
                forumListActivity.a(baVar2.getErrorString());
            } else if (((ag) obj).b() == 1) {
                this.b.a(this.b.getString(R.string.like_success));
                i = this.b.q;
                if (i != 0) {
                    i2 = this.b.q;
                    if (i2 == 1) {
                        ForumListModel.Forum[] forumArr = this.f1197a;
                        qVar = this.b.D;
                        forumArr[qVar.f1201a].is_like = 1;
                        qVar2 = this.b.D;
                        qVar2.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                ForumListModel.Forum[] forumArr2 = this.f1197a;
                qVar3 = this.b.C;
                forumArr2[qVar3.f1201a].is_like = 1;
                qVar4 = this.b.C;
                qVar4.notifyDataSetChanged();
            }
        }
    }
}
