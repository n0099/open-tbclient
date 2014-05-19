package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.JsonParseException;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.flist.ForumListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, ForumListModel> {
    boolean a;
    final /* synthetic */ ForumListActivity b;

    private q(ForumListActivity forumListActivity) {
        this.b = forumListActivity;
        this.a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(ForumListActivity forumListActivity, q qVar) {
        this(forumListActivity);
    }

    public void a(boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.b.c.m.setEnabled(false);
        this.b.c.n.setText(this.b.getString(com.baidu.tieba.u.flist_loading));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ForumListModel doInBackground(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        int i;
        ForumListModel.RequestParams requestParams4;
        try {
            requestParams = this.b.A;
            requestParams.recommend_type = 1;
            requestParams2 = this.b.A;
            requestParams2.offset = 0;
            requestParams3 = this.b.A;
            i = this.b.n;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.b;
            requestParams4 = this.b.A;
            return ForumListModel.new_fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ForumListModel forumListModel) {
        int i;
        int i2;
        int i3;
        int i4;
        ForumListModel.RequestParams requestParams;
        r rVar;
        r rVar2;
        int i5;
        int i6;
        int i7;
        if (forumListModel != null && forumListModel.recommend_list_left != null) {
            int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.b.a.forum_list.length);
            System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.b.a.forum_list, 0, min);
            rVar = this.b.D;
            rVar.a(min);
            rVar2 = this.b.D;
            rVar2.a(this.b.a.forum_list);
            i5 = this.b.n;
            if (i5 == 200) {
                this.b.c.n.setText(this.b.getString(com.baidu.tieba.u.flist_expand_list));
                ImageView imageView = this.b.c.o;
                i7 = this.b.l;
                imageView.setImageResource(i7);
            } else {
                this.b.c.n.setText(this.b.getString(com.baidu.tieba.u.flist_collapse_list));
                ImageView imageView2 = this.b.c.o;
                i6 = this.b.m;
                imageView2.setImageResource(i6);
                this.b.B = true;
            }
        } else {
            this.b.showToast(this.b.getString(com.baidu.tieba.u.neterror));
            if (!this.a) {
                i = this.b.n;
                if (i == 200) {
                    this.b.c.n.setText(this.b.getString(com.baidu.tieba.u.flist_expand_list));
                    ImageView imageView3 = this.b.c.o;
                    i3 = this.b.l;
                    imageView3.setImageResource(i3);
                } else {
                    this.b.c.n.setText(this.b.getString(com.baidu.tieba.u.flist_collapse_list));
                    ImageView imageView4 = this.b.c.o;
                    i2 = this.b.m;
                    imageView4.setImageResource(i2);
                }
            } else {
                this.b.c.n.setText(this.b.getString(com.baidu.tieba.u.flist_expand_list));
                ImageView imageView5 = this.b.c.o;
                i4 = this.b.l;
                imageView5.setImageResource(i4);
                requestParams = this.b.A;
                requestParams.rn = Constants.MEDIA_INFO;
                this.b.n = Constants.MEDIA_INFO;
            }
        }
        this.b.c.m.setEnabled(true);
        this.b.c.c();
    }
}
