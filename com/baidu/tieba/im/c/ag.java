package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, String> {
    private String bmP;
    private ChatMessage bmQ;
    private ac bmR = new ac();
    final /* synthetic */ af bmS;

    public ag(af afVar, String str, ChatMessage chatMessage) {
        this.bmS = afVar;
        this.bmP = str;
        this.bmQ = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public String doInBackground(Object... objArr) {
        try {
            return this.bmR.gP(this.bmP);
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
        ahVar = this.bmS.bmO;
        if (ahVar != null) {
            ahVar2 = this.bmS.bmO;
            ahVar2.a(str, this.bmQ);
        }
    }
}
