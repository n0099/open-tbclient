package com.baidu.tieba.flist;

import com.baidu.tieba.data.ak;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.ar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1040a;
    private final /* synthetic */ ForumListModel.Forum[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForumListActivity forumListActivity, ForumListModel.Forum[] forumArr) {
        this.f1040a = forumListActivity;
        this.b = forumArr;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ar arVar;
        int i;
        int i2;
        int i3;
        e eVar;
        e eVar2;
        ar arVar2;
        if (obj != null) {
            arVar = this.f1040a.m;
            if (arVar.getErrorCode() != 0) {
                ForumListActivity forumListActivity = this.f1040a;
                arVar2 = this.f1040a.m;
                forumListActivity.a(arVar2.getErrorString());
                this.f1040a.findViewById(R.id.loading).setVisibility(4);
                return;
            }
            if (((ak) obj).b() == 1) {
                ForumListModel.Forum[] forumArr = this.b;
                i = this.f1040a.k;
                forumArr[i].is_like = 1;
                this.f1040a.a(this.f1040a.getString(R.string.like_success));
                i2 = this.f1040a.l;
                if (i2 != 0) {
                    i3 = this.f1040a.l;
                    if (i3 == 1) {
                        eVar = this.f1040a.s;
                        eVar.notifyDataSetChanged();
                    }
                } else {
                    eVar2 = this.f1040a.r;
                    eVar2.notifyDataSetChanged();
                }
            }
            this.f1040a.findViewById(R.id.loading).setVisibility(4);
        }
    }
}
