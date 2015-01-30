package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, String> {
    private String boS;
    private ChatMessage boT;
    private ac boU = new ac();
    final /* synthetic */ af boV;

    public ag(af afVar, String str, ChatMessage chatMessage) {
        this.boV = afVar;
        this.boS = str;
        this.boT = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public String doInBackground(Object... objArr) {
        try {
            return this.boU.hn(this.boS);
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
        ahVar = this.boV.boR;
        if (ahVar != null) {
            ahVar2 = this.boV.boR;
            ahVar2.a(str, this.boT);
        }
    }
}
