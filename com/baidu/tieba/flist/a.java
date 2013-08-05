package com.baidu.tieba.flist;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1037a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ForumListActivity forumListActivity) {
        this.f1037a = forumListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumListModel a(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        try {
            ForumListActivity forumListActivity = this.f1037a;
            requestParams = this.f1037a.o;
            return ForumListModel.fetch(forumListActivity, requestParams);
        } catch (JsonParseException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        if (forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null) {
            eVar = this.f1037a.r;
            eVar.a(forumListModel.recommend_list_left.forum_list);
            this.f1037a.f1036a.h.addFooterView(this.f1037a.f1036a.l);
            if (forumListModel.recommend_list_left.has_more == 1) {
                this.f1037a.f1036a.f1048a.setVisibility(0);
            } else {
                this.f1037a.f1036a.f1048a.setVisibility(8);
            }
            ListView listView = this.f1037a.f1036a.h;
            eVar2 = this.f1037a.r;
            listView.setAdapter((ListAdapter) eVar2);
            this.f1037a.f1036a.j.setText(forumListModel.forum_class[0]);
            eVar3 = this.f1037a.s;
            eVar3.a(forumListModel.recommend_list_right.forum_list);
            this.f1037a.f1036a.i.addFooterView(this.f1037a.f1036a.o);
            if (forumListModel.recommend_list_right.has_more == 1) {
                this.f1037a.f1036a.b.setVisibility(0);
            } else {
                this.f1037a.f1036a.b.setVisibility(8);
            }
            ListView listView2 = this.f1037a.f1036a.i;
            eVar4 = this.f1037a.s;
            listView2.setAdapter((ListAdapter) eVar4);
            this.f1037a.f1036a.k.setText(forumListModel.forum_class[1]);
            this.f1037a.findViewById(R.id.loading).setVisibility(8);
            this.f1037a.findViewById(R.id.item_root).setVisibility(0);
            return;
        }
        this.f1037a.finish();
    }
}
