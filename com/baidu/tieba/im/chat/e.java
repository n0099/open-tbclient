package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public abstract class e<T> extends com.baidu.adp.widget.ListView.a<ChatMessage, a<T>> {
    protected com.baidu.adp.lib.c.a evT;
    protected com.baidu.adp.lib.c.b evU;
    protected long ewa;
    private boolean ewb;
    private boolean ewc;
    protected int ewd;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.evT = null;
        this.evU = null;
        this.ewa = 0L;
        this.ewb = false;
        this.ewc = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.evT = aVar;
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        this.evU = bVar;
    }

    private void aFR() {
        this.ewa = System.currentTimeMillis() / 1000;
    }

    public boolean aFS() {
        return this.ewb;
    }

    public void hg(boolean z) {
        this.ewb = z;
    }

    public boolean aFT() {
        return this.ewc;
    }

    public void hh(boolean z) {
        this.ewc = z;
    }

    public void pI(int i) {
        this.ewd = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aFR();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends r.a {
        private T ewe;

        public a(View view, T t) {
            super(view);
            this.ewe = t;
        }

        public T aFU() {
            return this.ewe;
        }
    }
}
