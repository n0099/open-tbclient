package com.baidu.tieba.flist;

import com.baidu.tieba.aj;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.model.ag;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.h {
    final /* synthetic */ ForumListActivity avY;
    private final /* synthetic */ ForumInfoData[] avZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
        this.avY = forumListActivity;
        this.avZ = forumInfoDataArr;
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
        agVar = this.avY.avA;
        if (agVar.getErrorCode() == 22) {
            this.avY.showToast(this.avY.getString(com.baidu.tieba.y.had_liked_forum));
        } else if (obj != null) {
            agVar2 = this.avY.avA;
            if (agVar2.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.avY;
                agVar3 = this.avY.avA;
                forumListActivity.showToast(agVar3.getErrorString());
            } else if (((com.baidu.tieba.data.aa) obj).isLike() == 1) {
                this.avY.showToast(this.avY.getString(com.baidu.tieba.y.like_success));
                i = this.avY.avz;
                if (i != 0) {
                    i2 = this.avY.avz;
                    if (i2 == 1) {
                        pVar = this.avY.avM;
                        pVar.notifyDataSetChanged();
                        aj wm = aj.wm();
                        ForumInfoData[] forumInfoDataArr = this.avZ;
                        pVar2 = this.avY.avM;
                        wm.dW(forumInfoDataArr[pVar2.awb].forum_name);
                        return;
                    }
                    return;
                }
                pVar3 = this.avY.avL;
                pVar3.notifyDataSetChanged();
                aj wm2 = aj.wm();
                ForumInfoData[] forumInfoDataArr2 = this.avZ;
                pVar4 = this.avY.avL;
                wm2.dW(forumInfoDataArr2[pVar4.awb].forum_name);
            }
        }
    }
}
