package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes2.dex */
public class VoiceSendModel extends BdBaseModel {
    private a jyP;
    private b jyQ;

    /* loaded from: classes2.dex */
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
        this.jyP = new a(str, chatMessage);
        this.jyP.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.jyQ = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private ChatMessage jyR;
        private com.baidu.tieba.im.sendmessage.b jyS = new com.baidu.tieba.im.sendmessage.b();
        private String mVid;

        public a(String str, ChatMessage chatMessage) {
            this.mVid = str;
            this.jyR = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            try {
                return this.jyS.KZ(this.mVid);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (VoiceSendModel.this.jyQ != null) {
                VoiceSendModel.this.jyQ.a(str, this.jyR);
            }
        }
    }
}
