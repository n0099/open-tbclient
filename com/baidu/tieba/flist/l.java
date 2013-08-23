package com.baidu.tieba.flist;

import com.baidu.tieba.data.ag;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1047a;
    private final /* synthetic */ ForumListModel.Forum[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumListActivity forumListActivity, ForumListModel.Forum[] forumArr) {
        this.f1047a = forumListActivity;
        this.b = forumArr;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        aq aqVar;
        int i;
        int i2;
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        aq aqVar2;
        if (obj != null) {
            aqVar = this.f1047a.q;
            if (aqVar.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.f1047a;
                aqVar2 = this.f1047a.q;
                forumListActivity.a(aqVar2.getErrorString());
            } else if (((ag) obj).b() == 1) {
                this.f1047a.a(this.f1047a.getString(R.string.like_success));
                i = this.f1047a.p;
                if (i != 0) {
                    i2 = this.f1047a.p;
                    if (i2 == 1) {
                        ForumListModel.Forum[] forumArr = this.b;
                        pVar = this.f1047a.B;
                        forumArr[pVar.f1051a].is_like = 1;
                        pVar2 = this.f1047a.B;
                        pVar2.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                ForumListModel.Forum[] forumArr2 = this.b;
                pVar3 = this.f1047a.A;
                forumArr2[pVar3.f1051a].is_like = 1;
                pVar4 = this.f1047a.A;
                pVar4.notifyDataSetChanged();
            }
        }
    }
}
