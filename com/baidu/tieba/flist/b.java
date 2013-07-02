package com.baidu.tieba.flist;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b extends BdAsyncTask {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumListModel a(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        try {
            ForumListActivity forumListActivity = this.a;
            requestParams = this.a.o;
            return ForumListModel.fetch(forumListActivity, requestParams);
        } catch (JsonParseException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        if (forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null) {
            fVar = this.a.r;
            fVar.a(forumListModel.recommend_list_left.forum_list);
            this.a.a.j.addFooterView(this.a.a.n);
            if (forumListModel.recommend_list_left.has_more == 1) {
                this.a.a.a.setVisibility(0);
            } else {
                this.a.a.a.setVisibility(8);
            }
            ListView listView = this.a.a.j;
            fVar2 = this.a.r;
            listView.setAdapter((ListAdapter) fVar2);
            this.a.a.l.setText(forumListModel.forum_class[0]);
            fVar3 = this.a.s;
            fVar3.a(forumListModel.recommend_list_right.forum_list);
            this.a.a.k.addFooterView(this.a.a.q);
            if (forumListModel.recommend_list_right.has_more == 1) {
                this.a.a.b.setVisibility(0);
            } else {
                this.a.a.b.setVisibility(8);
            }
            ListView listView2 = this.a.a.k;
            fVar4 = this.a.s;
            listView2.setAdapter((ListAdapter) fVar4);
            this.a.a.m.setText(forumListModel.forum_class[1]);
            this.a.findViewById(R.id.loading).setVisibility(8);
            this.a.findViewById(R.id.root).setVisibility(0);
            return;
        }
        this.a.finish();
    }
}
