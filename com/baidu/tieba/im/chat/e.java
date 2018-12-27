package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a eKG;
    protected com.baidu.adp.lib.c.b eKH;
    protected long eKN;
    private boolean eKO;
    private boolean eKP;
    protected int eKQ;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eKG = null;
        this.eKH = null;
        this.eKN = 0L;
        this.eKO = false;
        this.eKP = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.eKG = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.eKH = bVar;
    }

    private void aOY() {
        this.eKN = System.currentTimeMillis() / 1000;
    }

    public boolean aOZ() {
        return this.eKO;
    }

    /* renamed from: if  reason: not valid java name */
    public void m19if(boolean z) {
        this.eKO = z;
    }

    public boolean aPa() {
        return this.eKP;
    }

    public void ig(boolean z) {
        this.eKP = z;
    }

    public void pO(int i) {
        this.eKQ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aOY();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends q.a {
        private T eKR;

        public a(View view, T t) {
            super(view);
            this.eKR = t;
        }

        public T aPb() {
            return this.eKR;
        }
    }
}
