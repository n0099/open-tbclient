package com.baidu.tieba.flist;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f813a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ForumListActivity forumListActivity) {
        this.f813a = forumListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumListModel a(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        try {
            ForumListActivity forumListActivity = this.f813a;
            requestParams = this.f813a.o;
            return ForumListModel.fetch(forumListActivity, requestParams);
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
        f fVar2;
        f fVar3;
        f fVar4;
        if (forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null) {
            fVar = this.f813a.r;
            fVar.a(forumListModel.recommend_list_left.forum_list);
            this.f813a.f811a.j.addFooterView(this.f813a.f811a.n);
            if (forumListModel.recommend_list_left.has_more == 1) {
                this.f813a.f811a.f824a.setVisibility(0);
            } else {
                this.f813a.f811a.f824a.setVisibility(8);
            }
            ListView listView = this.f813a.f811a.j;
            fVar2 = this.f813a.r;
            listView.setAdapter((ListAdapter) fVar2);
            this.f813a.f811a.l.setText(forumListModel.forum_class[0]);
            fVar3 = this.f813a.s;
            fVar3.a(forumListModel.recommend_list_right.forum_list);
            this.f813a.f811a.k.addFooterView(this.f813a.f811a.q);
            if (forumListModel.recommend_list_right.has_more == 1) {
                this.f813a.f811a.b.setVisibility(0);
            } else {
                this.f813a.f811a.b.setVisibility(8);
            }
            ListView listView2 = this.f813a.f811a.k;
            fVar4 = this.f813a.s;
            listView2.setAdapter((ListAdapter) fVar4);
            this.f813a.f811a.m.setText(forumListModel.forum_class[1]);
            this.f813a.findViewById(R.id.loading).setVisibility(8);
            this.f813a.findViewById(R.id.root).setVisibility(0);
            return;
        }
        this.f813a.finish();
    }
}
