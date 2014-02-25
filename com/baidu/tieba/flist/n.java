package com.baidu.tieba.flist;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.model.ar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class n extends com.baidu.adp.a.g {
    final /* synthetic */ ForumListActivity a;
    private final /* synthetic */ ForumInfoData[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
        this.a = forumListActivity;
        this.b = forumInfoDataArr;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ar arVar;
        ar arVar2;
        int i;
        int i2;
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        ar arVar3;
        arVar = this.a.q;
        if (arVar.getErrorCode() == 22) {
            this.a.showToast(this.a.getString(R.string.had_liked_forum));
        } else if (obj != null) {
            arVar2 = this.a.q;
            if (arVar2.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.a;
                arVar3 = this.a.q;
                forumListActivity.showToast(arVar3.getErrorString());
            } else if (((com.baidu.tieba.data.af) obj).c() == 1) {
                this.a.showToast(this.a.getString(R.string.like_success));
                i = this.a.p;
                if (i != 0) {
                    i2 = this.a.p;
                    if (i2 == 1) {
                        rVar = this.a.E;
                        rVar.notifyDataSetChanged();
                        TiebaApplication g = TiebaApplication.g();
                        ForumInfoData[] forumInfoDataArr = this.b;
                        rVar2 = this.a.E;
                        g.e(forumInfoDataArr[rVar2.a].forum_name);
                        return;
                    }
                    return;
                }
                rVar3 = this.a.D;
                rVar3.notifyDataSetChanged();
                TiebaApplication g2 = TiebaApplication.g();
                ForumInfoData[] forumInfoDataArr2 = this.b;
                rVar4 = this.a.D;
                g2.e(forumInfoDataArr2[rVar4.a].forum_name);
            }
        }
    }
}
