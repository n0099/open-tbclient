package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.e {
    private a bHr;
    private b bHs;

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, ChatMessage chatMessage);
    }

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void b(String str, ChatMessage chatMessage) {
        this.bHr = new a(str, chatMessage);
        this.bHr.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.bHs = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private String bHt;
        private ChatMessage bHu;
        private ac bHv = new ac();

        public a(String str, ChatMessage chatMessage) {
            this.bHt = str;
            this.bHu = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public String doInBackground(Object... objArr) {
            try {
                return this.bHv.il(this.bHt);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (af.this.bHs != null) {
                af.this.bHs.a(str, this.bHu);
            }
        }
    }
}
