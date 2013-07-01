package com.baidu.tieba.flist;

import com.baidu.tieba.data.ac;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aj;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class e extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f816a;
    private final /* synthetic */ ForumListModel.Forum[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForumListActivity forumListActivity, ForumListModel.Forum[] forumArr) {
        this.f816a = forumListActivity;
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
        ajVar = this.f816a.m;
        if (ajVar.getErrorCode() != 0) {
            ForumListActivity forumListActivity = this.f816a;
            ajVar2 = this.f816a.m;
            forumListActivity.a(ajVar2.getErrorString());
            this.f816a.findViewById(R.id.loading).setVisibility(4);
            return;
        }
        if (((ac) obj).b() == 1) {
            ForumListModel.Forum[] forumArr = this.b;
            i = this.f816a.k;
            forumArr[i].is_like = 1;
            this.f816a.a(this.f816a.getString(R.string.like_success));
            i2 = this.f816a.l;
            if (i2 != 0) {
                i3 = this.f816a.l;
                if (i3 == 1) {
                    fVar = this.f816a.s;
                    fVar.notifyDataSetChanged();
                }
            } else {
                fVar2 = this.f816a.r;
                fVar2.notifyDataSetChanged();
            }
        }
        this.f816a.findViewById(R.id.loading).setVisibility(4);
    }
}
