package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class k extends BdAsyncTask {
    final /* synthetic */ ForumListActivity a;

    private k(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(ForumListActivity forumListActivity, k kVar) {
        this(forumListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.a.q.setEnabled(false);
        this.a.a.r.setText(this.a.getString(R.string.flist_loading));
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
            requestParams = this.a.o;
            requestParams.recommend_type = 2;
            requestParams2 = this.a.o;
            requestParams2.offset = 0;
            requestParams3 = this.a.o;
            requestParams3.rn = 50;
            ForumListActivity forumListActivity = this.a;
            requestParams4 = this.a.o;
            return ForumListModel.fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        f fVar;
        int i;
        if (forumListModel != null && forumListModel.recommend_list_right != null) {
            fVar = this.a.s;
            fVar.a(forumListModel.recommend_list_right.forum_list);
            this.a.q = true;
            this.a.a.q.setEnabled(true);
            this.a.a.r.setText(this.a.getString(R.string.flist_collapse_list));
            ImageView imageView = this.a.a.s;
            i = this.a.f;
            imageView.setImageResource(i);
        }
    }
}
