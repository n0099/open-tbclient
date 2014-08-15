package com.baidu.tieba.im.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ bc a;
    private String b;
    private ChatMessage c;
    private o d = new o();

    public bd(bc bcVar, String str, ChatMessage chatMessage) {
        this.a = bcVar;
        this.b = str;
        this.c = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        try {
            return this.d.a(this.b);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        be beVar;
        be beVar2;
        super.onPostExecute(str);
        beVar = this.a.b;
        if (beVar != null) {
            beVar2 = this.a.b;
            beVar2.a(str, this.c);
        }
    }
}
