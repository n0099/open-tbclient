package com.baidu.tieba.flist;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.gson.GsonBuilder;
import com.baidu.gson.JsonParseException;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.flist.ForumListModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Void, Void, ForumListModel> {
    ForumListModel a;
    final /* synthetic */ u b;

    private x(u uVar) {
        this.b = uVar;
        this.a = new ForumListModel();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(Void... voidArr) {
        w wVar;
        boolean z;
        super.b((Object[]) voidArr);
        if (this.a != null) {
            wVar = this.b.c;
            int errorCode = this.a.getErrorCode();
            ForumListModel forumListModel = this.a;
            String errorString = this.a.getErrorString();
            z = this.b.f;
            wVar.a(true, errorCode, forumListModel, errorString, z);
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
                com.baidu.adp.lib.cache.s<String> m = com.baidu.tieba.b.a.a().m();
                if (m != null) {
                    StringBuilder append = new StringBuilder().append(TiebaApplication.A()).append("_");
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
            com.baidu.adp.lib.g.e.e("ForumListDetailModel", "ForumListTask", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ForumListModel forumListModel) {
        w wVar;
        Context context;
        boolean z;
        w wVar2;
        boolean z2;
        if (forumListModel == null || !forumListModel.isOk()) {
            wVar = this.b.c;
            context = this.b.a;
            String string = context.getString(R.string.neterror);
            z = this.b.f;
            wVar.a(false, 0, forumListModel, string, z);
            return;
        }
        wVar2 = this.b.c;
        int errorCode = forumListModel.getErrorCode();
        String errorString = forumListModel.getErrorString();
        z2 = this.b.f;
        wVar2.a(true, errorCode, forumListModel, errorString, z2);
    }
}
