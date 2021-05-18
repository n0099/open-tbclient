package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes4.dex */
public class VoiceSendModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public a f17432e;

    /* renamed from: f  reason: collision with root package name */
    public b f17433f;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f17434a;

        /* renamed from: b  reason: collision with root package name */
        public ChatMessage f17435b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.k0.e1.s.b f17436c = new d.a.k0.e1.s.b();

        public a(String str, ChatMessage chatMessage) {
            this.f17434a = str;
            this.f17435b = chatMessage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            try {
                return this.f17436c.a(this.f17434a);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            if (VoiceSendModel.this.f17433f != null) {
                VoiceSendModel.this.f17433f.a(str, this.f17435b);
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
        this.f17433f = bVar;
    }

    public void u(String str, ChatMessage chatMessage) {
        a aVar = new a(str, chatMessage);
        this.f17432e = aVar;
        aVar.execute(new Object[0]);
    }
}
