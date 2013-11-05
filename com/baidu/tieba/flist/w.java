package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.util.be;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<Void, Void, ForumListModel> {

    /* renamed from: a  reason: collision with root package name */
    ForumListModel f1205a;
    final /* synthetic */ t b;

    private w(t tVar) {
        this.b = tVar;
        this.f1205a = new ForumListModel();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(Void... voidArr) {
        v vVar;
        boolean z;
        super.b((Object[]) voidArr);
        if (this.f1205a != null) {
            vVar = this.b.c;
            int errorCode = this.f1205a.getErrorCode();
            ForumListModel forumListModel = this.f1205a;
            String errorString = this.f1205a.getErrorString();
            z = this.b.f;
            vVar.a(true, errorCode, forumListModel, errorString, z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public ForumListModel a(Void... voidArr) {
        boolean z;
        Context context;
        ForumListModel.RequestParams requestParams;
        String str;
        ForumListModel.RequestParams requestParams2;
        try {
            z = this.b.e;
            if (z) {
                com.baidu.adp.lib.cache.s<String> i = com.baidu.tieba.b.a.a().i();
                if (i != null) {
                    StringBuilder append = new StringBuilder().append(TiebaApplication.C()).append("_");
                    requestParams2 = this.b.b;
                    str = i.a(append.append(requestParams2.menu_name).append("_list").toString());
                } else {
                    str = null;
                }
                if (str != null) {
                    this.f1205a = (ForumListModel) new GsonBuilder().create().fromJson(str, (Class<Object>) ForumListModel.class);
                    if (this.f1205a != null) {
                        c((Object[]) new Void[0]);
                    }
                    this.b.f = true;
                }
            }
            this.b.e = false;
            context = this.b.f1204a;
            requestParams = this.b.b;
            return ForumListModel.new_fetch(context, requestParams);
        } catch (JsonParseException e) {
            be.e("ForumListDetailModel", "ForumListTask", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        v vVar;
        Context context;
        boolean z;
        v vVar2;
        boolean z2;
        if (forumListModel == null || !forumListModel.isOk()) {
            vVar = this.b.c;
            context = this.b.f1204a;
            String string = context.getString(R.string.neterror);
            z = this.b.f;
            vVar.a(false, 0, forumListModel, string, z);
            return;
        }
        vVar2 = this.b.c;
        int errorCode = forumListModel.getErrorCode();
        String errorString = forumListModel.getErrorString();
        z2 = this.b.f;
        vVar2.a(true, errorCode, forumListModel, errorString, z2);
    }
}
