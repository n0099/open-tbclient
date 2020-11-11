package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class VoiceSendModel extends BdBaseModel {
    private a koQ;
    private b koR;

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
        this.koQ = new a(str, chatMessage);
        this.koQ.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.koR = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private ChatMessage koS;
        private com.baidu.tieba.im.sendmessage.b koT = new com.baidu.tieba.im.sendmessage.b();
        private String mVid;

        public a(String str, ChatMessage chatMessage) {
            this.mVid = str;
            this.koS = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            try {
                return this.koT.Ng(this.mVid);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (VoiceSendModel.this.koR != null) {
                VoiceSendModel.this.koR.a(str, this.koS);
            }
        }
    }
}
