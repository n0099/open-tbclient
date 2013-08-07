package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class j extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1044a;

    private j(ForumListActivity forumListActivity) {
        this.f1044a = forumListActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ForumListActivity forumListActivity, j jVar) {
        this(forumListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1044a.f1034a.o.setEnabled(false);
        this.f1044a.f1034a.p.setText(this.f1044a.getString(R.string.flist_loading));
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
            requestParams = this.f1044a.o;
            requestParams.recommend_type = 2;
            requestParams2 = this.f1044a.o;
            requestParams2.offset = 0;
            requestParams3 = this.f1044a.o;
            requestParams3.rn = 50;
            ForumListActivity forumListActivity = this.f1044a;
            requestParams4 = this.f1044a.o;
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
        if (forumListModel != null && forumListModel.recommend_list_right != null) {
            eVar = this.f1044a.s;
            eVar.a(forumListModel.recommend_list_right.forum_list);
            this.f1044a.q = true;
            this.f1044a.f1034a.o.setEnabled(true);
            this.f1044a.f1034a.p.setText(this.f1044a.getString(R.string.flist_collapse_list));
            ImageView imageView = this.f1044a.f1034a.q;
            i = this.f1044a.f;
            imageView.setImageResource(i);
        }
    }
}
