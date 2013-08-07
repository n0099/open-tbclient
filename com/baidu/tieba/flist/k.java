package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class k extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1045a;

    private k(ForumListActivity forumListActivity) {
        this.f1045a = forumListActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(ForumListActivity forumListActivity, k kVar) {
        this(forumListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1045a.f1034a.l.setEnabled(false);
        this.f1045a.f1034a.m.setText(this.f1045a.getString(R.string.flist_loading));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumListModel a(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        ForumListModel.RequestParams requestParams4;
        try {
            requestParams = this.f1045a.o;
            requestParams.recommend_type = 1;
            requestParams2 = this.f1045a.o;
            requestParams2.offset = 0;
            requestParams3 = this.f1045a.o;
            requestParams3.rn = 50;
            ForumListActivity forumListActivity = this.f1045a;
            requestParams4 = this.f1045a.o;
            return ForumListModel.fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        e eVar;
        int i;
        if (forumListModel != null && forumListModel.recommend_list_left != null) {
            eVar = this.f1045a.r;
            eVar.a(forumListModel.recommend_list_left.forum_list);
            this.f1045a.p = true;
            this.f1045a.f1034a.l.setEnabled(true);
            this.f1045a.f1034a.m.setText(this.f1045a.getString(R.string.flist_collapse_list));
            ImageView imageView = this.f1045a.f1034a.n;
            i = this.f1045a.f;
            imageView.setImageResource(i);
        }
    }
}
