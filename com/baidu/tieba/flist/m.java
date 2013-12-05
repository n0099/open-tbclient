package com.baidu.tieba.flist;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.model.ax;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class m extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumInfoData[] f1307a;
    final /* synthetic */ ForumListActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
        this.b = forumListActivity;
        this.f1307a = forumInfoDataArr;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ax axVar;
        ax axVar2;
        int i;
        int i2;
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        ax axVar3;
        axVar = this.b.q;
        if (axVar.getErrorCode() == 22) {
            this.b.showToast(this.b.getString(R.string.had_liked_forum));
        } else if (obj != null) {
            axVar2 = this.b.q;
            if (axVar2.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.b;
                axVar3 = this.b.q;
                forumListActivity.showToast(axVar3.getErrorString());
            } else if (((com.baidu.tieba.data.af) obj).b() == 1) {
                this.b.showToast(this.b.getString(R.string.like_success));
                i = this.b.p;
                if (i == 0) {
                    sVar3 = this.b.D;
                    sVar3.notifyDataSetChanged();
                    TiebaApplication h = TiebaApplication.h();
                    ForumInfoData[] forumInfoDataArr = this.f1307a;
                    sVar4 = this.b.D;
                    h.f(forumInfoDataArr[sVar4.f1313a].forum_name);
                    return;
                }
                i2 = this.b.p;
                if (i2 == 1) {
                    sVar = this.b.E;
                    sVar.notifyDataSetChanged();
                    TiebaApplication h2 = TiebaApplication.h();
                    ForumInfoData[] forumInfoDataArr2 = this.f1307a;
                    sVar2 = this.b.E;
                    h2.f(forumInfoDataArr2[sVar2.f1313a].forum_name);
                }
            }
        }
    }
}
