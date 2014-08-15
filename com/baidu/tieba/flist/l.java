package com.baidu.tieba.flist;

import com.baidu.tieba.ai;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.model.af;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.h {
    final /* synthetic */ ForumListActivity a;
    private final /* synthetic */ ForumInfoData[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
        this.a = forumListActivity;
        this.b = forumInfoDataArr;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        af afVar;
        af afVar2;
        int i;
        int i2;
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        af afVar3;
        afVar = this.a.p;
        if (afVar.getErrorCode() == 22) {
            this.a.showToast(this.a.getString(com.baidu.tieba.x.had_liked_forum));
        } else if (obj != null) {
            afVar2 = this.a.p;
            if (afVar2.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.a;
                afVar3 = this.a.p;
                forumListActivity.showToast(afVar3.getErrorString());
            } else if (((com.baidu.tieba.data.ab) obj).c() == 1) {
                this.a.showToast(this.a.getString(com.baidu.tieba.x.like_success));
                i = this.a.o;
                if (i != 0) {
                    i2 = this.a.o;
                    if (i2 == 1) {
                        pVar = this.a.B;
                        pVar.notifyDataSetChanged();
                        ai c = ai.c();
                        ForumInfoData[] forumInfoDataArr = this.b;
                        pVar2 = this.a.B;
                        c.d(forumInfoDataArr[pVar2.a].forum_name);
                        return;
                    }
                    return;
                }
                pVar3 = this.a.A;
                pVar3.notifyDataSetChanged();
                ai c2 = ai.c();
                ForumInfoData[] forumInfoDataArr2 = this.b;
                pVar4 = this.a.A;
                c2.d(forumInfoDataArr2[pVar4.a].forum_name);
            }
        }
    }
}
