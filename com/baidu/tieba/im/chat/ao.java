package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class ao<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected TbPageContext<MsglistActivity<?>> ajT;
    private boolean cNA;
    private boolean cNB;
    protected int cNC;
    protected com.baidu.adp.lib.c.a cNs;
    protected com.baidu.adp.lib.c.b cNt;
    protected long cNz;

    public ao(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cNs = null;
        this.cNt = null;
        this.cNz = 0L;
        this.cNA = false;
        this.cNB = false;
        this.ajT = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cNs = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cNt = bVar;
    }

    private void ant() {
        this.cNz = System.currentTimeMillis() / 1000;
    }

    public boolean anu() {
        return this.cNA;
    }

    public void fo(boolean z) {
        this.cNA = z;
    }

    public boolean anv() {
        return this.cNB;
    }

    public void fp(boolean z) {
        this.cNB = z;
    }

    public void ld(int i) {
        this.cNC = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        ant();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cND;

        public a(View view, T t) {
            super(view);
            this.cND = t;
        }

        public T anw() {
            return this.cND;
        }
    }
}
