package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, String> {
    private String bpK;
    private ChatMessage bpL;
    private ac bpM = new ac();
    final /* synthetic */ af bpN;

    public ag(af afVar, String str, ChatMessage chatMessage) {
        this.bpN = afVar;
        this.bpK = str;
        this.bpL = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public String doInBackground(Object... objArr) {
        try {
            return this.bpM.hv(this.bpK);
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
        ahVar = this.bpN.bpJ;
        if (ahVar != null) {
            ahVar2 = this.bpN.bpJ;
            ahVar2.a(str, this.bpL);
        }
    }
}
