package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Object, Integer, String> {
    private String bnf;
    private ChatMessage bng;
    private ac bnh = new ac();
    final /* synthetic */ af bni;

    public ag(af afVar, String str, ChatMessage chatMessage) {
        this.bni = afVar;
        this.bnf = str;
        this.bng = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public String doInBackground(Object... objArr) {
        try {
            return this.bnh.gS(this.bnf);
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
        ahVar = this.bni.bne;
        if (ahVar != null) {
            ahVar2 = this.bni.bne;
            ahVar2.a(str, this.bng);
        }
    }
}
