package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, String> {
    private String boR;
    private ChatMessage boS;
    private ac boT = new ac();
    final /* synthetic */ af boU;

    public ag(af afVar, String str, ChatMessage chatMessage) {
        this.boU = afVar;
        this.boR = str;
        this.boS = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: w */
    public String doInBackground(Object... objArr) {
        try {
            return this.boT.hk(this.boR);
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
        ahVar = this.boU.boQ;
        if (ahVar != null) {
            ahVar2 = this.boU.boQ;
            ahVar2.a(str, this.boS);
        }
    }
}
