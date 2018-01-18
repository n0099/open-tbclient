package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a erj;
    protected b erk;
    protected long erq;
    private boolean ers;
    private boolean ert;
    protected int eru;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.erj = null;
        this.erk = null;
        this.erq = 0L;
        this.ers = false;
        this.ert = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.erj = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.erk = bVar;
    }

    private void aEs() {
        this.erq = System.currentTimeMillis() / 1000;
    }

    public boolean aEt() {
        return this.ers;
    }

    public void gO(boolean z) {
        this.ers = z;
    }

    public boolean aEu() {
        return this.ert;
    }

    public void gP(boolean z) {
        this.ert = z;
    }

    public void pG(int i) {
        this.eru = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aEs();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends r.a {
        private T erv;

        public a(View view, T t) {
            super(view);
            this.erv = t;
        }

        public T aEv() {
            return this.erv;
        }
    }
}
