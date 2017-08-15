package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a djd;
    protected b dje;
    protected long djk;
    private boolean djl;
    private boolean djm;
    protected int djn;
    protected TbPageContext<MsglistActivity<?>> oV;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.djd = null;
        this.dje = null;
        this.djk = 0L;
        this.djl = false;
        this.djm = false;
        this.oV = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.djd = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.dje = bVar;
    }

    private void asx() {
        this.djk = System.currentTimeMillis() / 1000;
    }

    public boolean asy() {
        return this.djl;
    }

    public void fV(boolean z) {
        this.djl = z;
    }

    public boolean asz() {
        return this.djm;
    }

    public void fW(boolean z) {
        this.djm = z;
    }

    public void lU(int i) {
        this.djn = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        asx();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends j.a {
        private T djo;

        public a(View view, T t) {
            super(view);
            this.djo = t;
        }

        public T asA() {
            return this.djo;
        }
    }
}
