package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class VoiceSendModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f17781e;

    /* renamed from: f  reason: collision with root package name */
    public b f17782f;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f17783a;

        /* renamed from: b  reason: collision with root package name */
        public ChatMessage f17784b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.i0.e1.s.b f17785c = new d.b.i0.e1.s.b();

        public a(String str, ChatMessage chatMessage) {
            this.f17783a = str;
            this.f17784b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            try {
                return this.f17785c.a(this.f17783a);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (VoiceSendModel.this.f17782f != null) {
                VoiceSendModel.this.f17782f.a(str, this.f17784b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, ChatMessage chatMessage);
    }

    public VoiceSendModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void t(b bVar) {
        this.f17782f = bVar;
    }

    public void u(String str, ChatMessage chatMessage) {
        a aVar = new a(str, chatMessage);
        this.f17781e = aVar;
        aVar.execute(new Object[0]);
    }
}
