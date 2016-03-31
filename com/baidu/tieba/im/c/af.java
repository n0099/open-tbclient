package com.baidu.tieba.im.c;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.e {
    private a cpW;
    private b cpX;

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
        this.cpW = new a(str, chatMessage);
        this.cpW.execute(new Object[0]);
    }

    public void a(b bVar) {
        this.cpX = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private String cpY;
        private ChatMessage cpZ;
        private ac cqa = new ac();

        public a(String str, ChatMessage chatMessage) {
            this.cpY = str;
            this.cpZ = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public String doInBackground(Object... objArr) {
            try {
                return this.cqa.jF(this.cpY);
            } catch (Exception e) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (af.this.cpX != null) {
                af.this.cpX.a(str, this.cpZ);
            }
        }
    }
}
