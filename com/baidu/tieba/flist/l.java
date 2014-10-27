package com.baidu.tieba.flist;

import com.baidu.tieba.aj;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.model.ag;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.h {
    final /* synthetic */ ForumListActivity avP;
    private final /* synthetic */ ForumInfoData[] avQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
        this.avP = forumListActivity;
        this.avQ = forumInfoDataArr;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ag agVar;
        ag agVar2;
        int i;
        int i2;
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        ag agVar3;
        agVar = this.avP.avr;
        if (agVar.getErrorCode() == 22) {
            this.avP.showToast(this.avP.getString(com.baidu.tieba.y.had_liked_forum));
        } else if (obj != null) {
            agVar2 = this.avP.avr;
            if (agVar2.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.avP;
                agVar3 = this.avP.avr;
                forumListActivity.showToast(agVar3.getErrorString());
            } else if (((com.baidu.tieba.data.aa) obj).isLike() == 1) {
                this.avP.showToast(this.avP.getString(com.baidu.tieba.y.like_success));
                i = this.avP.avq;
                if (i != 0) {
                    i2 = this.avP.avq;
                    if (i2 == 1) {
                        pVar = this.avP.avD;
                        pVar.notifyDataSetChanged();
                        aj wk = aj.wk();
                        ForumInfoData[] forumInfoDataArr = this.avQ;
                        pVar2 = this.avP.avD;
                        wk.dW(forumInfoDataArr[pVar2.avS].forum_name);
                        return;
                    }
                    return;
                }
                pVar3 = this.avP.avC;
                pVar3.notifyDataSetChanged();
                aj wk2 = aj.wk();
                ForumInfoData[] forumInfoDataArr2 = this.avQ;
                pVar4 = this.avP.avC;
                wk2.dW(forumInfoDataArr2[pVar4.avS].forum_name);
            }
        }
    }
}
