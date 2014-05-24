package com.baidu.tieba.flist;

import com.baidu.tieba.ai;
import com.baidu.tieba.data.ForumInfoData;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.e {
    final /* synthetic */ ForumListActivity a;
    private final /* synthetic */ ForumInfoData[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
        this.a = forumListActivity;
        this.b = forumInfoDataArr;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        com.baidu.tieba.model.af afVar;
        com.baidu.tieba.model.af afVar2;
        int i;
        int i2;
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        com.baidu.tieba.model.af afVar3;
        afVar = this.a.q;
        if (afVar.getErrorCode() == 22) {
            this.a.showToast(this.a.getString(com.baidu.tieba.y.had_liked_forum));
        } else if (obj != null) {
            afVar2 = this.a.q;
            if (afVar2.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.a;
                afVar3 = this.a.q;
                forumListActivity.showToast(afVar3.getErrorString());
            } else if (((com.baidu.tieba.data.z) obj).c() == 1) {
                this.a.showToast(this.a.getString(com.baidu.tieba.y.like_success));
                i = this.a.p;
                if (i != 0) {
                    i2 = this.a.p;
                    if (i2 == 1) {
                        rVar = this.a.E;
                        rVar.notifyDataSetChanged();
                        ai c = ai.c();
                        ForumInfoData[] forumInfoDataArr = this.b;
                        rVar2 = this.a.E;
                        c.e(forumInfoDataArr[rVar2.a].forum_name);
                        return;
                    }
                    return;
                }
                rVar3 = this.a.D;
                rVar3.notifyDataSetChanged();
                ai c2 = ai.c();
                ForumInfoData[] forumInfoDataArr2 = this.b;
                rVar4 = this.a.D;
                c2.e(forumInfoDataArr2[rVar4.a].forum_name);
            }
        }
    }
}
