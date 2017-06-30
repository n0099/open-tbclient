package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class VoiceSendModel extends BdBaseModel {
    private a doA;
    private b doB;

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, ChatMessage chatMessage);
    }

    public VoiceSendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void b(String str, ChatMessage chatMessage) {
        this.doA = new a(str, chatMessage);
        this.doA.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.doB = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private String doC;
        private ChatMessage doD;
        private ac doE = new ac();

        public a(String str, ChatMessage chatMessage) {
            this.doC = str;
            this.doD = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public String doInBackground(Object... objArr) {
            try {
                return this.doE.mc(this.doC);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (VoiceSendModel.this.doB != null) {
                VoiceSendModel.this.doB.a(str, this.doD);
            }
        }
    }
}
