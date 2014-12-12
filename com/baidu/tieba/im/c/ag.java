package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, String> {
    private String bnv;
    private ChatMessage bnw;
    private ac bnx = new ac();
    final /* synthetic */ af bny;

    public ag(af afVar, String str, ChatMessage chatMessage) {
        this.bny = afVar;
        this.bnv = str;
        this.bnw = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Object... objArr) {
        try {
            return this.bnx.hi(this.bnv);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        ah ahVar;
        ah ahVar2;
        super.onPostExecute((ag) str);
        ahVar = this.bny.bnu;
        if (ahVar != null) {
            ahVar2 = this.bny.bnu;
            ahVar2.a(str, this.bnw);
        }
    }
}
