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
    protected TbPageContext<MsglistActivity<?>> ajr;
    protected com.baidu.adp.lib.c.a cJM;
    protected com.baidu.adp.lib.c.b cJN;
    protected long cJT;
    private boolean cJU;
    private boolean cJV;
    protected int cJW;

    public ao(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cJM = null;
        this.cJN = null;
        this.cJT = 0L;
        this.cJU = false;
        this.cJV = false;
        this.ajr = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.cJM = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.cJN = bVar;
    }

    private void aln() {
        this.cJT = System.currentTimeMillis() / 1000;
    }

    public boolean alo() {
        return this.cJU;
    }

    public void eZ(boolean z) {
        this.cJU = z;
    }

    public boolean alp() {
        return this.cJV;
    }

    public void fa(boolean z) {
        this.cJV = z;
    }

    public void kW(int i) {
        this.cJW = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aln();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends y.a {
        private T cJX;

        public a(View view, T t) {
            super(view);
            this.cJX = t;
        }

        public T alq() {
            return this.cJX;
        }
    }
}
