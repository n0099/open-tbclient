package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class l extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f823a;

    private l(ForumListActivity forumListActivity) {
        this.f823a = forumListActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(ForumListActivity forumListActivity, l lVar) {
        this(forumListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f823a.f811a.n.setEnabled(false);
        this.f823a.f811a.o.setText(this.f823a.getString(R.string.flist_loading));
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
            requestParams = this.f823a.o;
            requestParams.recommend_type = 1;
            requestParams2 = this.f823a.o;
            requestParams2.offset = 0;
            requestParams3 = this.f823a.o;
            requestParams3.rn = 50;
            ForumListActivity forumListActivity = this.f823a;
            requestParams4 = this.f823a.o;
            return ForumListModel.fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        f fVar;
        int i;
        if (forumListModel != null && forumListModel.recommend_list_left != null) {
            fVar = this.f823a.r;
            fVar.a(forumListModel.recommend_list_left.forum_list);
            this.f823a.p = true;
            this.f823a.f811a.n.setEnabled(true);
            this.f823a.f811a.o.setText(this.f823a.getString(R.string.flist_collapse_list));
            ImageView imageView = this.f823a.f811a.p;
            i = this.f823a.f;
            imageView.setImageResource(i);
        }
    }
}
