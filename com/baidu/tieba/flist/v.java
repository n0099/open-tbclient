package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.util.av;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, ForumListModel> {

    /* renamed from: a  reason: collision with root package name */
    ForumListModel f1073a;
    final /* synthetic */ t b;

    private v(t tVar) {
        this.b = tVar;
        this.f1073a = new ForumListModel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(t tVar, v vVar) {
        this(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(Void... voidArr) {
        u uVar;
        boolean z;
        super.b((Object[]) voidArr);
        if (this.f1073a != null) {
            uVar = this.b.c;
            int errorCode = this.f1073a.getErrorCode();
            ForumListModel forumListModel = this.f1073a;
            String errorString = this.f1073a.getErrorString();
            z = this.b.f;
            uVar.a(true, errorCode, forumListModel, errorString, z);
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
                com.baidu.adp.lib.cache.q<String> h = com.baidu.tieba.b.a.a().h();
                if (h != null) {
                    StringBuilder append = new StringBuilder(String.valueOf(TiebaApplication.C())).append("_");
                    requestParams2 = this.b.b;
                    str = h.a(append.append(requestParams2.menu_name).append("_list").toString());
                } else {
                    str = null;
                }
                if (str != null) {
                    this.f1073a = (ForumListModel) new GsonBuilder().create().fromJson(str, (Class<Object>) ForumListModel.class);
                    if (this.f1073a != null) {
                        c((Object[]) new Void[0]);
                    }
                    this.b.f = true;
                }
            }
            this.b.e = false;
            context = this.b.f1072a;
            requestParams = this.b.b;
            return ForumListModel.new_fetch(context, requestParams);
        } catch (JsonParseException e) {
            av.e("ForumListDetailModel", "ForumListTask", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        u uVar;
        Context context;
        boolean z;
        u uVar2;
        boolean z2;
        if (forumListModel == null || !forumListModel.isOk()) {
            uVar = this.b.c;
            context = this.b.f1072a;
            String string = context.getString(R.string.neterror);
            z = this.b.f;
            uVar.a(false, 0, forumListModel, string, z);
            return;
        }
        uVar2 = this.b.c;
        int errorCode = forumListModel.getErrorCode();
        String errorString = forumListModel.getErrorString();
        z2 = this.b.f;
        uVar2.a(true, errorCode, forumListModel, errorString, z2);
    }
}
