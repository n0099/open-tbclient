package com.baidu.tieba.flist;

import com.baidu.tieba.data.ac;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class e extends com.baidu.adp.a.e {
    final /* synthetic */ ForumListActivity a;
    private final /* synthetic */ ForumListModel.Forum[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForumListActivity forumListActivity, ForumListModel.Forum[] forumArr) {
        this.a = forumListActivity;
        this.b = forumArr;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        aj ajVar;
        int i;
        int i2;
        int i3;
        f fVar;
        f fVar2;
        aj ajVar2;
        ajVar = this.a.m;
        if (ajVar.getErrorCode() != 0) {
            ForumListActivity forumListActivity = this.a;
            ajVar2 = this.a.m;
            forumListActivity.a(ajVar2.getErrorString());
            this.a.findViewById(R.id.loading).setVisibility(4);
            return;
        }
        if (((ac) obj).b() == 1) {
            ForumListModel.Forum[] forumArr = this.b;
            i = this.a.k;
            forumArr[i].is_like = 1;
            this.a.a(this.a.getString(R.string.like_success));
            i2 = this.a.l;
            if (i2 != 0) {
                i3 = this.a.l;
                if (i3 == 1) {
                    fVar = this.a.s;
                    fVar.notifyDataSetChanged();
                }
            } else {
                fVar2 = this.a.r;
                fVar2.notifyDataSetChanged();
            }
        }
        this.a.findViewById(R.id.loading).setVisibility(4);
    }
}
