package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.flist.ForumListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends BdAsyncTask<Void, Void, ForumListModel> {
    ForumListModel a;
    final /* synthetic */ t b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ForumListModel a(Void... voidArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ForumListModel forumListModel) {
        u uVar;
        Context context;
        boolean z;
        u uVar2;
        boolean z2;
        ForumListModel forumListModel2 = forumListModel;
        if (forumListModel2 == null || !forumListModel2.isOk()) {
            uVar = this.b.c;
            context = this.b.a;
            String string = context.getString(com.baidu.tieba.a.k.neterror);
            z = this.b.f;
            uVar.a(false, 0, forumListModel2, string, z);
            return;
        }
        uVar2 = this.b.c;
        int errorCode = forumListModel2.getErrorCode();
        String errorString = forumListModel2.getErrorString();
        z2 = this.b.f;
        uVar2.a(true, errorCode, forumListModel2, errorString, z2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Void... voidArr) {
        u uVar;
        boolean z;
        super.b((Object[]) voidArr);
        if (this.a != null) {
            uVar = this.b.c;
            int errorCode = this.a.getErrorCode();
            ForumListModel forumListModel = this.a;
            String errorString = this.a.getErrorString();
            z = this.b.f;
            uVar.a(true, errorCode, forumListModel, errorString, z);
        }
    }

    private v(t tVar) {
        this.b = tVar;
        this.a = new ForumListModel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(t tVar, byte b) {
        this(tVar);
    }

    private ForumListModel a() {
        boolean z;
        Context context;
        ForumListModel.RequestParams requestParams;
        String str;
        ForumListModel.RequestParams requestParams2;
        try {
            z = this.b.e;
            if (z) {
                com.baidu.adp.lib.cache.s<String> m = com.baidu.tbadk.core.c.b.a().m();
                if (m != null) {
                    StringBuilder append = new StringBuilder(String.valueOf(TbadkApplication.E())).append("_");
                    requestParams2 = this.b.b;
                    str = m.a(append.append(requestParams2.menu_name).append("_list").toString());
                } else {
                    str = null;
                }
                if (str != null) {
                    this.a = (ForumListModel) new GsonBuilder().create().fromJson(str, (Class<Object>) ForumListModel.class);
                    if (this.a != null) {
                        c((Object[]) new Void[0]);
                    }
                    this.b.f = true;
                }
            }
            this.b.e = false;
            context = this.b.a;
            requestParams = this.b.b;
            return ForumListModel.new_fetch(context, requestParams);
        } catch (JsonParseException e) {
            com.baidu.adp.lib.util.f.e("ForumListDetailModel", "ForumListTask", e.getMessage());
            return null;
        }
    }
}
