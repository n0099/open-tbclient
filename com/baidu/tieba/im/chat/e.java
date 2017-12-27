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
    protected com.baidu.adp.lib.c.a epM;
    protected b epN;
    protected long epT;
    private boolean epU;
    private boolean epV;
    protected int epW;
    protected TbPageContext<MsglistActivity<?>> mPageContext;

    public e(TbPageContext<MsglistActivity<?>> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.epM = null;
        this.epN = null;
        this.epT = 0L;
        this.epU = false;
        this.epV = false;
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        this.epM = aVar;
    }

    public void setOnItemViewLongClickListener(b bVar) {
        this.epN = bVar;
    }

    private void aEn() {
        this.epT = System.currentTimeMillis() / 1000;
    }

    public boolean aEo() {
        return this.epU;
    }

    public void gL(boolean z) {
        this.epU = z;
    }

    public boolean aEp() {
        return this.epV;
    }

    public void gM(boolean z) {
        this.epV = z;
    }

    public void pN(int i) {
        this.epW = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ChatMessage chatMessage, a<T> aVar) {
        if (chatMessage != null && chatMessage.getCacheData() == null) {
            chatMessage.setCacheData(new MsgCacheData());
        }
        aEn();
        return view;
    }

    /* loaded from: classes.dex */
    public static class a<T> extends r.a {
        private T epX;

        public a(View view, T t) {
            super(view);
            this.epX = t;
        }

        public T aEq() {
            return this.epX;
        }
    }
}
