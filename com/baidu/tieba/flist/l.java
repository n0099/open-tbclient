package com.baidu.tieba.flist;

import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.as;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1064a;
    private final /* synthetic */ ForumListModel.Forum[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumListActivity forumListActivity, ForumListModel.Forum[] forumArr) {
        this.f1064a = forumListActivity;
        this.b = forumArr;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        as asVar;
        int i;
        int i2;
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        as asVar2;
        if (obj != null) {
            asVar = this.f1064a.r;
            if (asVar.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.f1064a;
                asVar2 = this.f1064a.r;
                forumListActivity.a(asVar2.getErrorString());
            } else if (((ag) obj).b() == 1) {
                this.f1064a.a(this.f1064a.getString(R.string.like_success));
                i = this.f1064a.q;
                if (i != 0) {
                    i2 = this.f1064a.q;
                    if (i2 == 1) {
                        ForumListModel.Forum[] forumArr = this.b;
                        pVar = this.f1064a.D;
                        forumArr[pVar.f1068a].is_like = 1;
                        pVar2 = this.f1064a.D;
                        pVar2.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                ForumListModel.Forum[] forumArr2 = this.b;
                pVar3 = this.f1064a.C;
                forumArr2[pVar3.f1068a].is_like = 1;
                pVar4 = this.f1064a.C;
                pVar4.notifyDataSetChanged();
            }
        }
    }
}
