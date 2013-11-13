package com.baidu.tieba.flist;

import android.widget.ImageView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.flist.ForumListModel;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, ForumListModel> {

    /* renamed from: a  reason: collision with root package name */
    boolean f1259a;
    final /* synthetic */ ForumListActivity b;

    private q(ForumListActivity forumListActivity) {
        this.b = forumListActivity;
        this.f1259a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(ForumListActivity forumListActivity, g gVar) {
        this(forumListActivity);
    }

    public void a(boolean z) {
        this.f1259a = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.b.c.n.setEnabled(false);
        this.b.c.o.setText(this.b.getString(R.string.flist_loading));
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
            requestParams = this.b.A;
            requestParams.recommend_type = 2;
            requestParams2 = this.b.A;
            requestParams2.offset = 0;
            requestParams3 = this.b.A;
            i = this.b.o;
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
    public void a(ForumListModel forumListModel) {
        int i;
        int i2;
        int i3;
        int i4;
        ForumListModel.RequestParams requestParams;
        s sVar;
        s sVar2;
        int i5;
        int i6;
        int i7;
        if (forumListModel != null && forumListModel.recommend_list_right != null) {
            int min = Math.min(forumListModel.recommend_list_right.forum_list.length, this.b.b.forum_list.length);
            System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.b.b.forum_list, 0, min);
            sVar = this.b.E;
            sVar.a(min);
            sVar2 = this.b.E;
            sVar2.a(this.b.b.forum_list);
            i5 = this.b.o;
            if (i5 == 200) {
                this.b.c.o.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView = this.b.c.p;
                i7 = this.b.l;
                imageView.setImageResource(i7);
            } else {
                this.b.c.o.setText(this.b.getString(R.string.flist_collapse_list));
                ImageView imageView2 = this.b.c.p;
                i6 = this.b.m;
                imageView2.setImageResource(i6);
                this.b.C = true;
            }
        } else {
            this.b.showToast(this.b.getString(R.string.neterror));
            if (!this.f1259a) {
                i = this.b.o;
                if (i == 200) {
                    this.b.c.o.setText(this.b.getString(R.string.flist_expand_list));
                    ImageView imageView3 = this.b.c.p;
                    i3 = this.b.l;
                    imageView3.setImageResource(i3);
                } else {
                    this.b.c.o.setText(this.b.getString(R.string.flist_collapse_list));
                    ImageView imageView4 = this.b.c.p;
                    i2 = this.b.m;
                    imageView4.setImageResource(i2);
                }
            } else {
                this.b.c.o.setText(this.b.getString(R.string.flist_expand_list));
                ImageView imageView5 = this.b.c.p;
                i4 = this.b.l;
                imageView5.setImageResource(i4);
                requestParams = this.b.A;
                requestParams.rn = 200;
                this.b.o = 200;
            }
        }
        this.b.c.n.setEnabled(true);
        this.b.c.c();
    }
}
