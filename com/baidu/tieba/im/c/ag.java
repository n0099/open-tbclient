package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, String> {
    private String bpL;
    private ChatMessage bpM;
    private ac bpN = new ac();
    final /* synthetic */ af bpO;

    public ag(af afVar, String str, ChatMessage chatMessage) {
        this.bpO = afVar;
        this.bpL = str;
        this.bpM = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: v */
    public String doInBackground(Object... objArr) {
        try {
            return this.bpN.hv(this.bpL);
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
        ahVar = this.bpO.bpK;
        if (ahVar != null) {
            ahVar2 = this.bpO.bpK;
            ahVar2.a(str, this.bpM);
        }
    }
}
