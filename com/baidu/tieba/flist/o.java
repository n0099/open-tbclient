package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<Void, Void, ForumListModel> {

    /* renamed from: a  reason: collision with root package name */
    boolean f1067a;
    final /* synthetic */ ForumListActivity b;

    private o(ForumListActivity forumListActivity) {
        this.b = forumListActivity;
        this.f1067a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(ForumListActivity forumListActivity, o oVar) {
        this(forumListActivity);
    }

    public void a(boolean z) {
        this.f1067a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.b.c.l.setEnabled(false);
        this.b.c.m.setText(this.b.getString(R.string.flist_loading));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ForumListModel a(Void... voidArr) {
        ForumListModel.RequestParams requestParams;
        ForumListModel.RequestParams requestParams2;
        ForumListModel.RequestParams requestParams3;
        int i;
        ForumListModel.RequestParams requestParams4;
        try {
            requestParams = this.b.z;
            requestParams.recommend_type = 1;
            requestParams2 = this.b.z;
            requestParams2.offset = 0;
            requestParams3 = this.b.z;
            i = this.b.o;
            requestParams3.rn = i;
            ForumListActivity forumListActivity = this.b;
            requestParams4 = this.b.z;
            return ForumListModel.new_fetch(forumListActivity, requestParams4);
        } catch (JsonParseException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        int i;
        int i2;
        int i3;
        int i4;
        ForumListModel.RequestParams requestParams;
        p pVar;
        p pVar2;
        int i5;
        int i6;
        int i7;
        if (forumListModel != null && forumListModel.recommend_list_left != null) {
            int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.b.f1053a.forum_list.length);
            System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.b.f1053a.forum_list, 0, min);
            pVar = this.b.C;
            pVar.a(min);
            pVar2 = this.b.C;
            pVar2.a(this.b.f1053a.forum_list);
            i5 = this.b.o;
            if (i5 == 10) {
                this.b.c.m.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView = this.b.c.n;
                i7 = this.b.m;
                imageView.setImageResource(i7);
            } else {
                this.b.c.m.setText(this.b.getString(R.string.flist_collapse_list));
                ImageView imageView2 = this.b.c.n;
                i6 = this.b.n;
                imageView2.setImageResource(i6);
                this.b.A = true;
            }
        } else {
            this.b.a(this.b.getString(R.string.neterror));
            if (!this.f1067a) {
                i = this.b.o;
                if (i == 10) {
                    this.b.c.m.setText(this.b.getString(R.string.flist_expand_list));
                    ImageView imageView3 = this.b.c.n;
                    i3 = this.b.m;
                    imageView3.setImageResource(i3);
                } else {
                    this.b.c.m.setText(this.b.getString(R.string.flist_collapse_list));
                    ImageView imageView4 = this.b.c.n;
                    i2 = this.b.n;
                    imageView4.setImageResource(i2);
                }
            } else {
                this.b.c.m.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView5 = this.b.c.n;
                i4 = this.b.m;
                imageView5.setImageResource(i4);
                requestParams = this.b.z;
                requestParams.rn = 10;
                this.b.o = 10;
            }
        }
        this.b.c.l.setEnabled(true);
        this.b.c.c();
    }
}
